import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mDescription;
    private String mage;
    private String mpower;
    private LocalDateTime mCreatedAt;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int mId;


//    Constructor with hero characteristics
    public Hero(String description, String age, String power) {
        mDescription = description;
        mage=age;
        mpower=power;
        instances.add(this);
        mId = instances.size();

    }

//    Getter method collecting hero descritpion character
    public String getDescription() {

        return mDescription;
    }
//    Getter method return age character of the hero
    public String getAge() {

        return mage;
    }
//    getter method return Specialpower of the hero
    public String getMpower(){
        return mpower;
    }

    public static List<Hero> all() {
        return instances;
    }
    public static void clear() {
        instances.clear();
    }
    public int getId() {
        return mId;
    }
    public static Hero find(int id) {
        return instances.get(id - 1);
    }
}
