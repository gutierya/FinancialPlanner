package FinancialPlanner.app.Models;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Component
public class User {
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "userId")
    private List<Goal> currentGoals;
    @OneToMany(mappedBy = "userId")
    private List<Goal> completedGoals;

    @Id
    @GeneratedValue
    private int id;

    public User(){}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        currentGoals = new ArrayList<Goal>();
        completedGoals = new ArrayList<Goal>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Goal> getCompletedGoals() {
        return completedGoals;
    }

    public List<Goal> getCurrentGoals() {
        return currentGoals;
    }

    public Long getId() {
        return id;
    }

    public void addGoal(Goal goal) {
        currentGoals.add(goal);
    }

    public void removeGoal(int id) {
        //get goal, remove from list
        currentGoals.remove(currentGoals.get(id));
    }
}
