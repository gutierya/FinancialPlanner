package FinancialPlanner.app.Repos;

import FinancialPlanner.app.Models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoalRepo extends JpaRepository<Goal, Long> {
}
