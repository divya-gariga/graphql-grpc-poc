import { gql } from "@apollo/client";

export const GET_TODOS = gql`
  query {
    getTodos {
      taskId
      title
      editTitle
      completed
    }
  }
`;

export const ADD_TODO = gql`
  mutation ($task_id: String, $title: String, $completed: Boolean) {
    addTodo(task_id: $task_id, title: $title, completed: $completed) {
      response_code
      response_message
    }
  }
`;

export const DELETE_TODO = gql`
  mutation ($task_id: String) {
    deleteTodo(task_id: $task_id) {
      response_code
      response_message
    }
  }
`;

export const EDIT_TODO = gql`
  mutation ($task_id: String, $edit_title: String, $completed: Boolean) {
    editTodo(
      task_id: $task_id
      edit_title: $edit_title
      completed: $completed
    ) {
      response_code
      response_message
    }
  }
`;
