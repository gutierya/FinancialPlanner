package FinancialPlanner.app.Services;

import FinancialPlanner.app.Exceptions.UserExceptions;
import FinancialPlanner.app.Models.Goal;
import FinancialPlanner.app.Repos.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private final GoalRepo goalRepo;

    public GoalService(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }

    public Goal saveGoal(Goal goal) {
        goalRepo.save(goal);
        return goal;
    }

    public Goal findById(Long goalId) {
        return goalRepo.findById(goalId).orElseThrow(() -> new UserExceptions(goalId)); // throw an exception
    }

    public void deleteGoal(Long goalId) throws Exception {
        // retrieves the goal by a specific id
        Goal goal = goalRepo.getById(goalId);
        // takes the goal by its id and deletes it
        goalRepo.delete(goal);
    }

    public List<Goal> getAllGoals() {
        return goalRepo.findAll();
    }

    /**
     * update board by id
     */
    public Goal updateGoalByID(Long goalId) {

        Goal goal = goalRepo.findById(goalId).orElseThrow(() -> new UserExceptions(goalId));

        goal.setGoalName(goal.getGoalName());
        goal.setGoalDescription(goal.getGoalDescription());
        goal.setGoalPrice(goal.getGoalPrice());
        goal.setStartDate(goal.getStartDate());
        goal.setCheckDate(goal.getCheckDate());
        goalRepo.save(goal);

        return goal;
    }

}





