package serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.testdouble.User;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private final FakeUserRepository userRepository = new FakeUserRepository();

    @Test
    public void testSaveAndFindUser() {
        //given
        var testUser = new User(1L, "Alex", 25);
        userRepository.save(testUser);


        //when
        var user = userRepository.findById(1L);


        //then
        assertEquals("Alex",user.getName());
    }
}
