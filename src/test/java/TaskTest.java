import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaskTest {
    @Test
    public void all_returnsAllInstancesOfTask_true() {
        Task firstTask = new Task("Fight racism","6","sexism");
        Task secondTask = new Task("Buy druga","7","fight");
        assertEquals(true, Task.all().contains(firstTask));
        assertEquals(true, Task.all().contains(secondTask));
    }
    @Test
    public void clear_emptiesAllTasksFromArrayList_0() {
        Task myTask = new Task("Mow the lawn","6","racism");
        Task.clear();
        assertEquals(Task.all().size(), 0);
    }
    @Test
    public void getId_tasksInstantiateWithAnID_1() {
        Task.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
        Task myTask = new Task("fight corruption","67","powerful");
        assertEquals(1, myTask.getId());
    }

    @Test
    public void find_returnsTaskWithSameId_secondTask() {
        Task firstTask = new Task("fight racism","6","feminism");
        Task secondTask = new Task("fight corruption","8","kill defaults");
        assertEquals(Task.find(secondTask.getId()), secondTask);
    }

}