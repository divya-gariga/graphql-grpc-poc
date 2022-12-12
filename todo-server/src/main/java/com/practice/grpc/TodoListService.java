package com.practice.grpc;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoListService extends TodoListGrpc.TodoListImplBase{
    public List<Todos.Todo> todoList = new ArrayList<>();
    @Override
    public void viewTodos(Todos.Empty request, StreamObserver<Todos.Todo> responseObserver) {

        if(todoList.isEmpty())
        {
          Status status = Status.FAILED_PRECONDITION.withDescription("No todos to display");
          responseObserver.onError(status.asException());
        }

        for (Todos.Todo todo : todoList) {
            responseObserver.onNext(todo);

        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteTodo(Todos.Todo request, StreamObserver<Todos.APIResponse> responseObserver) {

        if(todoList.size()==0){
            Status status = Status.NOT_FOUND.withDescription("Todo list is empty to delete");
            responseObserver.onError(status.asRuntimeException());
        }
        String id = request.getTaskId();
        Optional<Todos.Todo> optionalTodo = todoList.stream().filter(todo1 -> todo1.getTaskId().equals(id)).findFirst();
       if (optionalTodo.isEmpty()) {
            Status status = Status.NOT_FOUND.withDescription("Cannot find any todo with the given title");
            responseObserver.onError(status.asRuntimeException());

        } else {
            for (int i = 0; i < todoList.size(); i++) {
                Todos.Todo todo = todoList.get(i);

                if (todo.getTaskId().equals(id)) {
                    todoList.remove(i);
                    Todos.APIResponse.Builder apiResponse = Todos.APIResponse.newBuilder();
                    apiResponse.setResponseCode(0);
                    apiResponse.setResponseMessage("Todo deleted successfully having the title "+request.getTitle());
                    responseObserver.onNext(apiResponse.build());
                    responseObserver.onCompleted();
                    break;
                }
            }
        }
    }

    @Override
    public void editTodo(Todos.Todo request, StreamObserver<Todos.APIResponse> responseObserver) {

        String id = request.getTaskId();
        String title = request.getTitle();

        boolean completed = request.getCompleted();
        Optional<Todos.Todo> optionalTodo = todoList.stream().filter(todo1 -> todo1.getTaskId().equals(id)).findFirst();
        if(optionalTodo.isEmpty())   {
            Status status = Status.NOT_FOUND.withDescription("Cannot find any todo with the given id");
            responseObserver.onError(status.asRuntimeException());

        }
        else{
            Todos.Todo editedTodo;
            for(int i=0;i< todoList.size();i++){
                Todos.Todo todo = todoList.get(i);

                if(todo.getTaskId().equals(id))
                {
                    if(request.getEditTitle().length()>=5 && request.getEditTitle().length()<70) {
                        editedTodo = Todos.Todo.newBuilder().setTaskId(request.getTaskId()).setTitle(request.getEditTitle()).setCompleted(request.getCompleted()).build();
                        todoList.set(i,editedTodo);
                        Todos.APIResponse.Builder apiResponse = Todos.APIResponse.newBuilder();
                        apiResponse.setResponseCode(0);
                        apiResponse.setResponseMessage("Todo edited successfully with the title "+ todoList.get(i).getTitle());
                        responseObserver.onNext(apiResponse.build());
                        responseObserver.onCompleted();
                    }
                    else if ((request.getEditTitle().length()!=0)&&(request.getEditTitle().length()<5 ||request.getEditTitle().length()>70))
                    {
                        Status status = Status.INVALID_ARGUMENT.withDescription("Length of the new title is not within the limits 5-70, add correct title");
                        responseObserver.onError(status.asRuntimeException());

                    }
                    else if(request.getEditTitle().length()==0 && todo.getCompleted()!=request.getCompleted())
                    {
                        editedTodo = Todos.Todo.newBuilder().setTaskId(request.getTaskId()).setTitle(request.getTitle()).setCompleted(request.getCompleted()).build();
                        todoList.set(i,editedTodo);
                        Todos.APIResponse.Builder apiResponse = Todos.APIResponse.newBuilder();
                        apiResponse.setResponseCode(0);
                        apiResponse.setResponseMessage("Todo edited successfully with the status"+request.getCompleted());
                        responseObserver.onNext(apiResponse.build());
                        responseObserver.onCompleted();
                    }
                    else if ((request.getEditTitle().equals(request.getTitle())||request.getEditTitle().isBlank()) && todo.getCompleted()==request.getCompleted()){

                        Status status = Status.INVALID_ARGUMENT.withDescription("No changes have been made as the given title and status have not been modified");
                        responseObserver.onError(status.asRuntimeException());
                }



                }
            }

        }
    }
    @Override
    public void addTodo(Todos.Todo request, StreamObserver<Todos.APIResponse> responseObserver) {

        String name = request.getTitle();
        boolean completed = request.getCompleted();
        if(name.length()<5)
        {
            Status status = Status.INVALID_ARGUMENT.withDescription("Length of the title is too small, consider adding a explanatory title");
            responseObserver.onError(status.asRuntimeException());
        }

        if(name.length()>70)
        {
            Status status = Status.INVALID_ARGUMENT.withDescription("Length of the title exceeds required length, consider reducing the length");
            responseObserver.onError(status.asRuntimeException());
        }
        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId(request.getTaskId()).setTitle(name).setEditTitle(request.getEditTitle()).setCompleted(request.getCompleted()).buildPartial();
        todoList.add(todo);
        Todos.APIResponse.Builder apiResponse = Todos.APIResponse.newBuilder();
        apiResponse.setResponseCode(0);
        apiResponse.setResponseMessage("Todo added successfully");
        responseObserver.onNext(apiResponse.build());
        responseObserver.onCompleted();
    }
}
