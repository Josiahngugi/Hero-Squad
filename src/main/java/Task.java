import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String mDescription;
    private String mage;
    private String mpower;
    private LocalDateTime mCreatedAt;
    private static List<Task> instances = new ArrayList<Task>();
    private int mId;

    public Task(String description,String age,String power) {
        mDescription = description;
        mage=age;
        mpower=power;
        instances.add(this);
        mId = instances.size();

    }

    public String getDescription() {

        return mDescription;
    }
    public String getAge() {

        return mage;
    }
    public String getMpower(){
        return mpower;
    }

    public static List<Task> all() {
        return instances;
    }
    public static void clear() {
        instances.clear();
    }
    public int getId() {
        return mId;
    }
    public static Task find(int id) {
        return instances.get(id - 1);
    }
}
