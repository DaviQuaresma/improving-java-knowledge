package LibrarySystem_exercise_2;
import java.util.Random;

public class User {
    private final String name;
    private final int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public User(String name){
        Random random = new Random();
        int randomId = random.nextInt(100);

        this.name = name;
        id = randomId;
    }
}
