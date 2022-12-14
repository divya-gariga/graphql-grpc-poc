import React, { useState, useRef, useEffect } from "react";
import Form from "./components/Form";
import FilterButton from "./components/FilterButton";
import Todo from "./components/Todo";
import { nanoid } from "nanoid";
import { useQuery, useMutation, useLazyQuery, gql } from "@apollo/client";
import { ADD_TODO, DELETE_TODO, EDIT_TODO, GET_TODOS } from "./utils/queries";
function usePrevious(value) {
  const ref = useRef();
  useEffect(() => {
    ref.current = value;
  });
  return ref.current;
}
var operation = "";
const FILTER_MAP = {
  All: () => true,
  Active: (task) => !task.completed,
  Completed: (task) => task.completed,
};

const FILTER_NAMES = Object.keys(FILTER_MAP);

function App(props) {
  const [editTodoTask] = useMutation(EDIT_TODO);
  const [deleteTodoTask] = useMutation(DELETE_TODO);
  const [addTodoTask] = useMutation(ADD_TODO);

  const [tasks, setTasks] = useState([]);
  const [filter, setFilter] = useState("All");

  const { loading, error, data, refetch } = useQuery(GET_TODOS);
  useEffect(() => {
    
   
    if (data) {
      setTasks(data.getTodos);
      console.log("coming inside useEffect's if condition");
    }
  }, [data]);

  function toggleTaskCompleted(id) {
    let status;
    let taskTitle = "";

    const updatedTasks = tasks.map((task) => {
      if (id == task.taskId) {
        // use object spread to make a new obkect
        // whose `completed` prop has been inverted
        // console.log("toggle task: ", task.completed);
        taskTitle = task.title;
        status = !task.completed;
        return { ...task, completed: !task.completed };
      }
      return task;
    });
    operation = "toggle task";
    // console.log("updated tasks", updatedTasks);
    editTodoTask({
      variables: {
        task_id: id,
        edit_title: taskTitle,
        completed: status,
      },
    });
    // refetch();
    setTasks(updatedTasks);
  }

  function deleteTask(id) {
    const remainingTasks = tasks.filter((task) => id !== task.task_id);
    deleteTodoTask({
      variables: {
        task_id: id,
      },
    });
    console.log("remaining tasks: ", remainingTasks);
    if (remainingTasks.length == 1) setTasks([]);

    refetch();
  }

  function editTask(id, newName) {
    const editedTaskList = tasks.map((task) => {
      if (id === task.task_id) {
        //
        return { ...task, name: newName };
      }
      return task;
    });
    editTodoTask({
      variables: {
        task_id: id,
        edit_title: newName,
      },
    });
    refetch();

    //
  }

  const taskList = tasks
    .filter(FILTER_MAP[filter])
    .map((task) => (
      <Todo
        id={task.taskId}
        name={task.title}
        completed={task.completed}
        key={task.taskId}
        toggleTaskCompleted={toggleTaskCompleted}
        deleteTask={deleteTask}
        editTask={editTask}
      />
    ));
  const filterList = FILTER_NAMES.map((name) => (
    <FilterButton
      key={name}
      name={name}
      isPressed={name === filter}
      setFilter={setFilter}
    />
  ));

  function addTask(name) {
    let title = name;
    let done = false;
    const newTask = { id: "todo-" + nanoid(), name: name, completed: false };
    addTodoTask({
      variables: {
        task_id: "todo-" + nanoid(),
        title: name,
        completed: done,
      },
    });

    refetch();
  }

  const tasksNoun = taskList.length !== 1 ? "tasks" : "task";
  const headingText = `${taskList.length} ${tasksNoun} remaining`;

  const listHeadingRef = useRef(null);
  const prevTaskLength = usePrevious(tasks.length);

  useEffect(() => {
    if (tasks.length - prevTaskLength === -1) {
      listHeadingRef.current.focus();
    }
  }, [tasks.length, prevTaskLength]);

  return (
    <div className="todoapp stack-large">
      <Form addTask={addTask} />
      <div className="filters btn-group stack-exception">{filterList}</div>
      <h2 id="list-heading" tabIndex="-1" ref={listHeadingRef}>
        {headingText}
      </h2>
      <ul
        role="list"
        className="todo-list stack-large stack-exception"
        aria-labelledby="list-heading"
      >
        {/* {console.log("tasks", tasks)} */}
        {taskList}
      </ul>
    </div>
  );
}

export default App;
