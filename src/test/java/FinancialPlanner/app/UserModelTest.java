package FinancialPlanner.app;


import FinancialPlanner.app.Models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelTest {

    private User user;

    @BeforeEach
    void setUp() throws Exception{
        user = new User();
        user.setFirstName("first");
        user.setLastName("last");
    }

    @AfterEach
    void tearDown() throws Exception{
        System.out.println("Execution of j unit tests is done");
    }

    @Test
    void testConstructors() {
        User user1 = new User();
        User user2 = new User();

        assertNotEquals(user1, user2);
    }

    @Test
    void testObjects1() {
        User user3 = new User();
        User user4 = new User();

        assertNotSame(user3, user4);
    }

    @Test
    void testObjects2() {
        User user3 = new User();
        User user4 = new User();

        user4 = user3;
        assertSame(user3, user4);
    }
}
