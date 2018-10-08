import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquadTest {
    @Test
    public void category_instantiatesCorrectly_true() {
        Squad testSquad = new Squad("Home","fight","20");
        assertEquals(true, testSquad instanceof Squad);
    }


    @Test
    public void getName_categoryInstantiatesWithName_Home() {
        Squad testSquad = new Squad("Home","sexism","15");
        assertEquals("Home", testSquad.getName());
    }

    @Test
    public void all_returnsAllInstancesOfCategory_true() {
        Squad firstSquad = new Squad("Home","corruption","30");
        Squad secondSquad = new Squad("Work","racism","5");
        assertEquals(true, Squad.all().contains(firstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
    }
    @Test
    public void clear_emptiesAllCategoriesFromList_0() {
        Squad testSquad = new Squad("Home","racism","6");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);



}}