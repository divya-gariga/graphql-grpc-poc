const { Empty, Todo } = require("../../proto/todos_pb");
const grpc = require("@grpc/grpc-js");
// const { client } = require("../../todo-client");
const { AppClient } = require("../../proto/todos_grpc_pb");

const client = new AppClient(
  "localhost:9090",
  grpc.credentials.createInsecure()
);
const resolvers = {
  Query: {
    getTodos: () => {
      return new Promise((resolve, reject) => {
        const stream = client.viewTodos(new Empty());
        var todos = [];
        stream.on("data", (todo) => {
          todos.push(todo.toObject());
        });
        stream.on("error", reject);
        stream.on("end", () => {
          console.log("todos test", todos);
          resolve(todos);
        });
      });
    },
  },
  Mutation: {
    deleteTodo: (parent, { task_id }) => {
      return new Promise((resolve, reject) => {
        const removeTodo = new Todo();
        // removeTodo.setTitle(title);
        removeTodo.setTaskId(task_id);
        const stream = client.deleteTodo(removeTodo, (err, response) => {
          if (err) {
            reject(err);
            console.log(err);
          } else {
            console.log(response);
            resolve({
              responseCode: 200,
              responseMessage: response.toString(),
            });
          }
        });
      });
    },
    addTodo: (parent, { task_id, title,completed }) => {
      return new Promise((resolve, reject) => {
        const newTodo = new Todo();
        newTodo.setTaskId(task_id);
        newTodo.setTitle(title);
        newTodo.setCompleted(completed);
        const stream = client.addTodo(newTodo, (err, response) => {
          if (err) {
            reject(err);
            console.log(err);
          } else {
            console.log(response);
            resolve({
              responseCode: 200,
              responseMessage: response.toString(),
            });
          }
        });
      });
    },
    editTodo: (parent, { task_id, edit_title, completed }) => {
      return new Promise((resolve, reject) => {
        const newTodo = new Todo();
        newTodo.setTaskId(task_id);
        newTodo.setEditTitle(edit_title);
        newTodo.setCompleted(completed);
        const stream = client.editTodo(newTodo, (err, response) => {
          if (err) {
            reject(err);
            console.log(err);
          } else {
            console.log(response);
            resolve({
              responseCode: 200,
              responseMessage: response.toString(),
            });
          }
        });
      });
    },
  },
};

module.exports = resolvers;
