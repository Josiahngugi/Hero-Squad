import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class heroTest {
    @Test
    public void all_returnsAllInstancesOfTask_true() {
        Hero firstHero = new Hero("Fight racism","6","sexism");
        Hero secondHero = new Hero("Buy druga","7","fight");
        assertEquals(true, Hero.all().contains(firstHero));
        assertEquals(true, Hero.all().contains(secondHero));
    }
    @Test
    public void clear_emptiesAllTasksFromArrayList_0() {
        Hero myHero = new Hero("Mow the lawn","6","racism");
        Hero.clear();
        assertEquals(Hero.all().size(), 0);
    }
    @Test
    public void getId_tasksInstantiateWithAnID_1() {
        Hero.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
        Hero myHero = new Hero("fight corruption","67","powerful");
        assertEquals(1, myHero.getId());
    }

    @Test
    public void find_returnsTaskWithSameId_secondTask() {
        Hero firstHero = new Hero("fight racism","6","feminism");
        Hero secondHero = new Hero("fight corruption","8","kill defaults");
        assertEquals(Hero.find(secondHero.getId()), secondHero);
    }

}