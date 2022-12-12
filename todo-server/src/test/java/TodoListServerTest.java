import com.practice.grpc.TodoListGrpc;
import com.practice.grpc.TodoListService;
import com.practice.grpc.Todos;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Iterator;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TodoListServerTest {
    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();


    @Test
    public void testAddSuccessfulTodo() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());
        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        Todos.APIResponse response = blockingStub.addTodo(Todos.Todo.newBuilder().setTaskId("test-1").setTitle("Test task").setCompleted(false).build());
        assertEquals("Todo added successfully", response.getResponseMessage());

    }

    @Test
    public void testAddTodoWithSmallTitle() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        try {
            Todos.APIResponse response = blockingStub.addTodo(Todos.Todo.newBuilder().setTaskId("test-2").setTitle("smt").setCompleted(false).build());
        } catch (Exception re) {
            System.out.println(re.getMessage());
            assertEquals("INVALID_ARGUMENT: Length of the title is too small, consider adding a explanatory title", re.getMessage());
        }
    }

    @Test
    public void testAddTodoWithLongTitle() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        try {
            Todos.APIResponse response = blockingStub.addTodo(Todos.Todo.newBuilder().setTaskId("test-3").setTitle("This task title's length is more than 70 characters, verifying whether long title creates an exception").setCompleted(false).build());
        } catch (Exception re) {
            System.out.println(re.getMessage());
            assertEquals("INVALID_ARGUMENT: Length of the title exceeds required length, consider reducing the length", re.getMessage());
        }
    }

    @Test
    public void testViewEmptyTodoList() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        try {
            Iterator<Todos.Todo> response = blockingStub.viewTodos(Todos.Empty.newBuilder().build());
        } catch (Exception re) {
            System.out.println(re.getMessage());
            assertEquals("No todos to display", re.getMessage());
        }
    }

    @Test
    public void testViewTodoList() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        blockingStub.addTodo(Todos.Todo.newBuilder().setTaskId("test-4").setTitle("Test task").setCompleted(false).build());
        Iterator<Todos.Todo> response = blockingStub.viewTodos(Todos.Empty.newBuilder().build());
        assertTrue(response.hasNext());

    }

    @Test
    public void testDeleteNonexistentTodo() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
        try {
            blockingStub.addTodo(Todos.Todo.newBuilder().setTaskId("test-5").setTitle("Test task").setCompleted(false).build());
            Todos.APIResponse response = blockingStub.deleteTodo(Todos.Todo.newBuilder().setTaskId("todo-7").setTitle("Test task").setCompleted(true).build());

        } catch (Exception re) {
            System.out.println(re.getMessage());
            assertEquals("NOT_FOUND: Cannot find any todo with the given title", re.getMessage());
        }
    }

    @Test
    public void testDeleteTodo() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-6").setTitle("Test task").setCompleted(true).build();
        blockingStub.addTodo(todo);

        Todos.APIResponse response = blockingStub.deleteTodo(todo);

        assertEquals("Todo deleted successfully having the title Test task", response.getResponseMessage());

    }

    @Test
    public void testDeleteTodoWhenTodoListIsEmpty() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-7").setTitle("Test task").setCompleted(true).build();

        try {
            Todos.APIResponse response = blockingStub.deleteTodo(todo);
        } catch (Exception e) {
            assertEquals("NOT_FOUND: Todo list is empty to delete", e.getMessage());
        }


    }

    @Test
    public void testEditTodo() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-8").setTitle("Test task").setCompleted(true).build();
        blockingStub.addTodo(todo);
        Todos.Todo editTodo = Todos.Todo.newBuilder().setTaskId("test-8").setEditTitle("Test edit task").setCompleted(true).build();

        Todos.APIResponse response = blockingStub.editTodo(editTodo);
        assertEquals("Todo edited successfully with the title Test edit task",response.getResponseMessage());


    }
    @Test
    public void testEditTodoWithVeryShortOrVeryLongLengthEditTitle() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-8").setTitle("Test task").setCompleted(true).build();
        blockingStub.addTodo(todo);
        Todos.Todo editTodo = Todos.Todo.newBuilder().setTaskId("test-8").setEditTitle("This task title's edit length is more than 70 characters, verifying whether long edit title creates an exception").setCompleted(true).build();

        try {
            Todos.APIResponse response = blockingStub.editTodo(editTodo);
            System.out.println("response: "+response.getResponseMessage());
        }
        catch(Exception e){
            assertEquals("INVALID_ARGUMENT: Length of the new title is not within the limits 5-70, add correct title", e.getMessage());
        }

    }
    @Test
    public void testEditWithNonexistentTodo() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-9").setTitle("Test task").setCompleted(true).build();
        blockingStub.addTodo(todo);
        Todos.Todo editTodo = Todos.Todo.newBuilder().setTaskId("test-8").setEditTitle("Test edit task").setCompleted(true).build();

        try {
            Todos.APIResponse response = blockingStub.editTodo(editTodo);
        }
        catch(Exception e){
            assertEquals("NOT_FOUND: Cannot find any todo with the given id", e.getMessage());
        }

    }
    @Test
    public void testEditTodoWithOnlyStatusChange() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-9").setTitle("Test edit task with status change").setCompleted(false).build();
        blockingStub.addTodo(todo);
        Todos.Todo editTodo = Todos.Todo.newBuilder().setTaskId("test-9").setCompleted(true).build();

        try {
            Todos.APIResponse response = blockingStub.editTodo(editTodo);
        }
        catch(Exception e){
            assertEquals("Todo edited successfully with the status true", e.getMessage());
        }

    }

    @Test
    public void testEditTodoWithNoChanges() throws Exception {
        String serverName = InProcessServerBuilder.generateName();
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new TodoListService()).build().start());

        TodoListGrpc.TodoListBlockingStub blockingStub = TodoListGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        Todos.Todo todo = Todos.Todo.newBuilder().setTaskId("test-9").setTitle("Test edit task with no changes").setCompleted(false).build();
        blockingStub.addTodo(todo);
        Todos.Todo editTodo = Todos.Todo.newBuilder().setTaskId("test-9").setTitle("Test edit task with no changes").setCompleted(false).build();

        try {
            Todos.APIResponse response = blockingStub.editTodo(editTodo);
            System.out.println("response: "+response.getResponseMessage());
        }
        catch(Exception e){
            assertEquals("INVALID_ARGUMENT: No changes have been made as the given title and status have not been modified", e.getMessage());
        }

    }
}
