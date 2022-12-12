const { gql } = require("apollo-server");

exports.typeDefs = gql`
  type Todo {
    task_id: String
    title: String
    edit_title: String
    completed: Boolean
  }
  type ReturnTodo {
    taskId: String
    title: String
    editTitle: String
    completed: Boolean
  }
  type APIResponse {
    response_message: String
    response_code: Int
  }
  type Query {
    getTodos: [ReturnTodo]
  }

  type Mutation {
    deleteTodo(task_id: String): APIResponse
    addTodo(task_id: String, title: String, completed: Boolean): APIResponse
    editTodo(
      task_id: String
      edit_title: String
      completed: Boolean
    ): APIResponse
  }
`;
