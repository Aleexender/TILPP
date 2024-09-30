package serviceTest;

import java.util.HashMap;
import java.util.Map;
import org.example.testdouble.User;

public class FakeUserRepository {
    private Map<Long, User> database = new HashMap<>();

    public void save(User user) {
        database.put(user.getId(), user);
    }

    public User findById(Long id) {
        return database.get(id);
    }

}
