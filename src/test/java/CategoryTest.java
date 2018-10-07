import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {
    @Test
    public void category_instantiatesCorrectly_true() {
        Category testCategory = new Category("Home","fight","20");
        assertEquals(true, testCategory instanceof Category);
    }


    @Test
    public void getName_categoryInstantiatesWithName_Home() {
        Category testCategory = new Category("Home","sexism","15");
        assertEquals("Home", testCategory.getName());
    }

    @Test
    public void all_returnsAllInstancesOfCategory_true() {
        Category firstCategory = new Category("Home","corruption","30");
        Category secondCategory = new Category("Work","racism","5");
        assertEquals(true, Category.all().contains(firstCategory));
        assertEquals(true, Category.all().contains(secondCategory));
    }
    @Test
    public void clear_emptiesAllCategoriesFromList_0() {
        Category testCategory = new Category("Home","racism","6");
        Category.clear();
        assertEquals(Category.all().size(), 0);



}}