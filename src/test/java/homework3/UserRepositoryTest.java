package homework3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRep = new UserRepository();

    @BeforeEach
    void init () {

        User user1 = new User("user1", "password1", true);
        User user2 = new User("user2", "password2", false);
        User user3 = new User("user3", "password3", false);
        User user4 = new User("user4", "password4", false);
        User user5 = new User("user5", "password5", false);
        User user6 = new User("user6", "password6", false);

        user1.isAuthenticate = true;
        user2.isAuthenticate = true;
        user3.isAuthenticate = true;
        user4.isAuthenticate = true;
        user5.isAuthenticate = true;
        user6.isAuthenticate = false;

        userRep.addUser(user1);
        userRep.addUser(user2);
        userRep.addUser(user3);
        userRep.addUser(user4);
        userRep.addUser(user5);
        userRep.addUser(user6);
    }

    @Test
    void logOut() {
        userRep.logOut();
        for (User user : userRep.data) {
            if (!user.isAdmin) {
                assertFalse(user.isAuthenticate);
            }
        }
    }
}