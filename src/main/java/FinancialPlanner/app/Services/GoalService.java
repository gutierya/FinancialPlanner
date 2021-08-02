package FinancialPlanner.app.Services;

import FinancialPlanner.app.Repos.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    GoalRepo goalRepo;

    public void saveGoal(Goal goal) {
        goalRepo.save(goal);
    }

    public Goal findById(Long goalId) {
        return goalRepo.findById(goalId); // throw an exception
    }

    public void deleteGoal(Goal currentGoal) {
        goalRepo.delete(currentGoal);
    }

    public List<Goal> getAllGoals() {
        return goalRepo.findAll();
    }

}
