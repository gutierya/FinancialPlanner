package FinancialPlanner.app.Models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Goal> currentGoals = new ArrayList<Goal>();
    @OneToMany(mappedBy = "user")
    private List<Goal> completedGoals = new ArrayList<Goal>();

    @Id
    @GeneratedValue
    private Long id;

    public User(){}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

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
