package FinancialPlanner.app;

import FinancialPlanner.app.Models.User;
import FinancialPlanner.app.Repos.UserRepo;
import FinancialPlanner.app.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Test
    @DisplayName("Test to find user by id - success")
    void testFindById() {
        User user = new User("first", "last");
        doReturn(Optional.of(user)).when(userRepo).findById(1L);

        Optional<User> returnUser = Optional.ofNullable(userService.getUserById(1L));

        Assertions.assertTrue(returnUser.isPresent(), "User was not found");
        Assertions.assertSame(returnUser.get(), user, "The user returned was not the same as the mock");
    }


}
