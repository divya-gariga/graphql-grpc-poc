package com.practice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: todos.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TodoListGrpc {

  private TodoListGrpc() {}

  public static final String SERVICE_NAME = "TodoList";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.practice.grpc.Todos.Empty,
      com.practice.grpc.Todos.Todo> getViewTodosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewTodos",
      requestType = com.practice.grpc.Todos.Empty.class,
      responseType = com.practice.grpc.Todos.Todo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.practice.grpc.Todos.Empty,
      com.practice.grpc.Todos.Todo> getViewTodosMethod() {
    io.grpc.MethodDescriptor<com.practice.grpc.Todos.Empty, com.practice.grpc.Todos.Todo> getViewTodosMethod;
    if ((getViewTodosMethod = TodoListGrpc.getViewTodosMethod) == null) {
      synchronized (TodoListGrpc.class) {
        if ((getViewTodosMethod = TodoListGrpc.getViewTodosMethod) == null) {
          TodoListGrpc.getViewTodosMethod = getViewTodosMethod =
              io.grpc.MethodDescriptor.<com.practice.grpc.Todos.Empty, com.practice.grpc.Todos.Todo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "viewTodos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.Todo.getDefaultInstance()))
              .setSchemaDescriptor(new TodoListMethodDescriptorSupplier("viewTodos"))
              .build();
        }
      }
    }
    return getViewTodosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo,
      com.practice.grpc.Todos.APIResponse> getEditTodoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "editTodo",
      requestType = com.practice.grpc.Todos.Todo.class,
      responseType = com.practice.grpc.Todos.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo,
      com.practice.grpc.Todos.APIResponse> getEditTodoMethod() {
    io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo, com.practice.grpc.Todos.APIResponse> getEditTodoMethod;
    if ((getEditTodoMethod = TodoListGrpc.getEditTodoMethod) == null) {
      synchronized (TodoListGrpc.class) {
        if ((getEditTodoMethod = TodoListGrpc.getEditTodoMethod) == null) {
          TodoListGrpc.getEditTodoMethod = getEditTodoMethod =
              io.grpc.MethodDescriptor.<com.practice.grpc.Todos.Todo, com.practice.grpc.Todos.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "editTodo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.Todo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TodoListMethodDescriptorSupplier("editTodo"))
              .build();
        }
      }
    }
    return getEditTodoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo,
      com.practice.grpc.Todos.APIResponse> getAddTodoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addTodo",
      requestType = com.practice.grpc.Todos.Todo.class,
      responseType = com.practice.grpc.Todos.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo,
      com.practice.grpc.Todos.APIResponse> getAddTodoMethod() {
    io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo, com.practice.grpc.Todos.APIResponse> getAddTodoMethod;
    if ((getAddTodoMethod = TodoListGrpc.getAddTodoMethod) == null) {
      synchronized (TodoListGrpc.class) {
        if ((getAddTodoMethod = TodoListGrpc.getAddTodoMethod) == null) {
          TodoListGrpc.getAddTodoMethod = getAddTodoMethod =
              io.grpc.MethodDescriptor.<com.practice.grpc.Todos.Todo, com.practice.grpc.Todos.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addTodo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.Todo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TodoListMethodDescriptorSupplier("addTodo"))
              .build();
        }
      }
    }
    return getAddTodoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo,
      com.practice.grpc.Todos.APIResponse> getDeleteTodoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteTodo",
      requestType = com.practice.grpc.Todos.Todo.class,
      responseType = com.practice.grpc.Todos.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo,
      com.practice.grpc.Todos.APIResponse> getDeleteTodoMethod() {
    io.grpc.MethodDescriptor<com.practice.grpc.Todos.Todo, com.practice.grpc.Todos.APIResponse> getDeleteTodoMethod;
    if ((getDeleteTodoMethod = TodoListGrpc.getDeleteTodoMethod) == null) {
      synchronized (TodoListGrpc.class) {
        if ((getDeleteTodoMethod = TodoListGrpc.getDeleteTodoMethod) == null) {
          TodoListGrpc.getDeleteTodoMethod = getDeleteTodoMethod =
              io.grpc.MethodDescriptor.<com.practice.grpc.Todos.Todo, com.practice.grpc.Todos.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteTodo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.Todo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.practice.grpc.Todos.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TodoListMethodDescriptorSupplier("deleteTodo"))
              .build();
        }
      }
    }
    return getDeleteTodoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TodoListStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TodoListStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TodoListStub>() {
        @java.lang.Override
        public TodoListStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TodoListStub(channel, callOptions);
        }
      };
    return TodoListStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TodoListBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TodoListBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TodoListBlockingStub>() {
        @java.lang.Override
        public TodoListBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TodoListBlockingStub(channel, callOptions);
        }
      };
    return TodoListBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TodoListFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TodoListFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TodoListFutureStub>() {
        @java.lang.Override
        public TodoListFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TodoListFutureStub(channel, callOptions);
        }
      };
    return TodoListFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TodoListImplBase implements io.grpc.BindableService {

    /**
     */
    public void viewTodos(com.practice.grpc.Todos.Empty request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.Todo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getViewTodosMethod(), responseObserver);
    }

    /**
     */
    public void editTodo(com.practice.grpc.Todos.Todo request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditTodoMethod(), responseObserver);
    }

    /**
     */
    public void addTodo(com.practice.grpc.Todos.Todo request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddTodoMethod(), responseObserver);
    }

    /**
     */
    public void deleteTodo(com.practice.grpc.Todos.Todo request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTodoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getViewTodosMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.practice.grpc.Todos.Empty,
                com.practice.grpc.Todos.Todo>(
                  this, METHODID_VIEW_TODOS)))
          .addMethod(
            getEditTodoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.practice.grpc.Todos.Todo,
                com.practice.grpc.Todos.APIResponse>(
                  this, METHODID_EDIT_TODO)))
          .addMethod(
            getAddTodoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.practice.grpc.Todos.Todo,
                com.practice.grpc.Todos.APIResponse>(
                  this, METHODID_ADD_TODO)))
          .addMethod(
            getDeleteTodoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.practice.grpc.Todos.Todo,
                com.practice.grpc.Todos.APIResponse>(
                  this, METHODID_DELETE_TODO)))
          .build();
    }
  }

  /**
   */
  public static final class TodoListStub extends io.grpc.stub.AbstractAsyncStub<TodoListStub> {
    private TodoListStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TodoListStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TodoListStub(channel, callOptions);
    }

    /**
     */
    public void viewTodos(com.practice.grpc.Todos.Empty request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.Todo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getViewTodosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editTodo(com.practice.grpc.Todos.Todo request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditTodoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addTodo(com.practice.grpc.Todos.Todo request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddTodoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteTodo(com.practice.grpc.Todos.Todo request,
        io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTodoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TodoListBlockingStub extends io.grpc.stub.AbstractBlockingStub<TodoListBlockingStub> {
    private TodoListBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TodoListBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TodoListBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.practice.grpc.Todos.Todo> viewTodos(
        com.practice.grpc.Todos.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getViewTodosMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.practice.grpc.Todos.APIResponse editTodo(com.practice.grpc.Todos.Todo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditTodoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.practice.grpc.Todos.APIResponse addTodo(com.practice.grpc.Todos.Todo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddTodoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.practice.grpc.Todos.APIResponse deleteTodo(com.practice.grpc.Todos.Todo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTodoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TodoListFutureStub extends io.grpc.stub.AbstractFutureStub<TodoListFutureStub> {
    private TodoListFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TodoListFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TodoListFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.practice.grpc.Todos.APIResponse> editTodo(
        com.practice.grpc.Todos.Todo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditTodoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.practice.grpc.Todos.APIResponse> addTodo(
        com.practice.grpc.Todos.Todo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddTodoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.practice.grpc.Todos.APIResponse> deleteTodo(
        com.practice.grpc.Todos.Todo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTodoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VIEW_TODOS = 0;
  private static final int METHODID_EDIT_TODO = 1;
  private static final int METHODID_ADD_TODO = 2;
  private static final int METHODID_DELETE_TODO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TodoListImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TodoListImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VIEW_TODOS:
          serviceImpl.viewTodos((com.practice.grpc.Todos.Empty) request,
              (io.grpc.stub.StreamObserver<com.practice.grpc.Todos.Todo>) responseObserver);
          break;
        case METHODID_EDIT_TODO:
          serviceImpl.editTodo((com.practice.grpc.Todos.Todo) request,
              (io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse>) responseObserver);
          break;
        case METHODID_ADD_TODO:
          serviceImpl.addTodo((com.practice.grpc.Todos.Todo) request,
              (io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse>) responseObserver);
          break;
        case METHODID_DELETE_TODO:
          serviceImpl.deleteTodo((com.practice.grpc.Todos.Todo) request,
              (io.grpc.stub.StreamObserver<com.practice.grpc.Todos.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TodoListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TodoListBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.practice.grpc.Todos.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TodoList");
    }
  }

  private static final class TodoListFileDescriptorSupplier
      extends TodoListBaseDescriptorSupplier {
    TodoListFileDescriptorSupplier() {}
  }

  private static final class TodoListMethodDescriptorSupplier
      extends TodoListBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TodoListMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TodoListGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TodoListFileDescriptorSupplier())
              .addMethod(getViewTodosMethod())
              .addMethod(getEditTodoMethod())
              .addMethod(getAddTodoMethod())
              .addMethod(getDeleteTodoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
