package FinancialPlanner.app.Repos;

import FinancialPlanner.app.Models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepo extends JpaRepository<Goal, Long> {
}
