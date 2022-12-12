// GENERATED CODE -- DO NOT EDIT!

"use strict";
var todos_pb = require("./todos_pb.js");
var grpc = require("@grpc/grpc-js");

function serialize_APIResponse(arg) {
  if (!(arg instanceof todos_pb.APIResponse)) {
    throw new Error("Expected argument of type APIResponse");
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_APIResponse(buffer_arg) {
  return todos_pb.APIResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_Empty(arg) {
  if (!(arg instanceof todos_pb.Empty)) {
    throw new Error("Expected argument of type Empty");
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_Empty(buffer_arg) {
  return todos_pb.Empty.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_Todo(arg) {
  if (!(arg instanceof todos_pb.Todo)) {
    throw new Error("Expected argument of type Todo");
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_Todo(buffer_arg) {
  return todos_pb.Todo.deserializeBinary(new Uint8Array(buffer_arg));
}

var TodoListService = (exports["TodoList"] = {
  viewTodos: {
    path: "/TodoList/viewTodos",
    requestStream: false,
    responseStream: true,
    requestType: todos_pb.Empty,
    responseType: todos_pb.Todo,
    requestSerialize: serialize_Empty,
    requestDeserialize: deserialize_Empty,
    responseSerialize: serialize_Todo,
    responseDeserialize: deserialize_Todo,
  },
  editTodo: {
    path: "/TodoList/editTodo",
    requestStream: false,
    responseStream: false,
    requestType: todos_pb.Todo,
    responseType: todos_pb.APIResponse,
    requestSerialize: serialize_Todo,
    requestDeserialize: deserialize_Todo,
    responseSerialize: serialize_APIResponse,
    responseDeserialize: deserialize_APIResponse,
  },
  addTodo: {
    path: "/TodoList/addTodo",
    requestStream: false,
    responseStream: false,
    requestType: todos_pb.Todo,
    responseType: todos_pb.APIResponse,
    requestSerialize: serialize_Todo,
    requestDeserialize: deserialize_Todo,
    responseSerialize: serialize_APIResponse,
    responseDeserialize: deserialize_APIResponse,
  },
  deleteTodo: {
    path: "/TodoList/deleteTodo",
    requestStream: false,
    responseStream: false,
    requestType: todos_pb.Todo,
    responseType: todos_pb.APIResponse,
    requestSerialize: serialize_Todo,
    requestDeserialize: deserialize_Todo,
    responseSerialize: serialize_APIResponse,
    responseDeserialize: deserialize_APIResponse,
  },
});

exports.AppClient = grpc.makeGenericClientConstructor(TodoListService);
