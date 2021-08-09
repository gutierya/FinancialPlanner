package FinancialPlanner.app;

import FinancialPlanner.app.Models.Goal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoalModelTest {

    private Goal goal;

    @BeforeEach
    void setUp() throws Exception{
        goal = new Goal();
        goal.setGoalName("foo");
        goal.setGoalDescription("test description");
        goal.setGoalPrice(50D);
    }

    @AfterEach
    void tearDown() throws Exception{
        System.out.println("Execution of j unit tests is done");
    }

    @Test
    void testConstructors() {
        Goal goal1 = new Goal();
        Goal goal2 = new Goal();

        assertNotEquals(goal1, goal2);
    }

    @Test
    void testObjects1() {
        Goal goal3 = new Goal();
        Goal goal4 = new Goal();

        assertNotSame(goal3, goal4);
    }

    @Test
    void testObjects2() {
        Goal goal3 = new Goal();
        Goal goal4 = new Goal();

        goal4 = goal3;
        assertSame(goal3, goal4);
    }



}