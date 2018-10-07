import java.util.List;
import java.util.ArrayList;

//construtor with Squad category Characteristics
public class Category {
    private String mName;
    private static List<Category> instances = new ArrayList<Category>();
    private int mId;
    private String mname;
    private String mdedication;
    private String msize;
    private List<Task> mTasks;

//    method that holds Squad properties
    public Category(String name,String dedication,String size) {
        mName = name;
        mdedication=dedication;
        msize=size;
        instances.add(this);
        mId = instances.size();
        mTasks = new ArrayList<Task>();


    }

//    method that herros in an array
    public void addTask(Task task) {
        mTasks.add(task);
    }

//    getter method return getname characteristic of the Hero
    public String getName(){return mName;}
//    getter method return description of the Hero
    public String getDedication(){return mdedication;}
    public String getsize(){return msize;}



    public List<Task> getTasks() {
        return mTasks;
    }

    public static List<Category> all() {
        return instances;
    }
    public static void clear() {
        instances.clear();
    }
    public int getId() {
        return mId;
    }
    public static Category find(int id) {
        return instances.get(id - 1);
    }

}