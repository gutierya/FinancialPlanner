package FinancialPlanner.app;

import FinancialPlanner.app.Models.Goal;
import FinancialPlanner.app.Repos.GoalRepo;
import FinancialPlanner.app.Services.GoalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import FinancialPlanner.app.Models.User;
import FinancialPlanner.app.Repos.UserRepo;
import FinancialPlanner.app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
@SpringBootTest
public class GoalServiceTest {

    @Autowired
    private GoalService goalService;

    @MockBean
    private GoalRepo goalRepo;

    @Test
    @DisplayName("Test to find goal id - success")
    void testFindGoalById() {
        Goal goal = new Goal("buy a house", "a multi family house buy", 500000D,50);
        doReturn(Optional.of(goal)).when(goalRepo).findById(1L);

        Optional<Goal> returnGoal = Optional.ofNullable(goalService.findById(1L));

        Assertions.assertTrue(returnGoal.isPresent(), "Goal was not found");
        Assertions.assertSame(returnGoal.get(), goal, "The goal returned was not the same as the mock");
    }

}
