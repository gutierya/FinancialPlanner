package FinancialPlanner.app.Models;

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

    @OneToMany(mappedBy = "user")////reference to the uncompleted form of user list
    private List<Goal> currentGoals = new ArrayList<Goal>();
    @OneToMany(mappedBy = "user2")//reference to the completed form of user list
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


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCurrentGoals(List<Goal> currentGoals) {
        this.currentGoals = currentGoals;
    }

    public void setCompletedGoals(List<Goal> completedGoals) {
        this.completedGoals = completedGoals;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", currentGoals=" + currentGoals.toString() +
                ", completedGoals=" + completedGoals.toString() +
                '}';

    }
}
