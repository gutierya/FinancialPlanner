package FinancialPlanner.app.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Goal {
    private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id Long id;
    @NotBlank(message = "Goal name is needed!")
    private String goalName;
    @NotBlank(message = "Goal description is needed!")
    private String goalDescription;// holds a brief description of what the goal is for
    @NotBlank(message = "Goal target amount is needed!")
    private double goalPrice;// holds the price tage of the goal
    private double goalCount;// hold how much you have saved
    @JsonFormat(pattern = "mm-dd-yyy")
    private LocalDate StartDate;// initializes start date of saving for goal
    @JsonFormat(pattern = "mm-dd-yyy")
    private LocalDate checkDate;// initializes a week from start to check to remind user to save money
    private int weeksLeft;// will hold a # of how many weeks are left until complete


    /**
     * every time we create a new object, this assigns the created new date
     */
    @PrePersist
    protected void whenCreate() {this.StartDate = LocalDate.now();}



    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;// is mapped to user to hold all of his/her goals


    //constructors

    public Goal(){}
    public Goal(String goalName, String goalDescription, double goalPrice, LocalDate startDate) {
        this.goalName = goalName;
        this.goalDescription = goalDescription;
        this.goalPrice = goalPrice;
        this.StartDate = startDate;
        this.checkDate = startDate.plusWeeks(1);

    }
     //setters and getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public double getGoalPrice() {
        return goalPrice;
    }

    public void setGoalPrice(double goalPrice) {
        this.goalPrice = goalPrice;
    }

    public double getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(double goalCount) {
        this.goalCount = goalCount;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }

    public int getWeeksLeft() {
        return weeksLeft;
    }

    public void setWeeksLeft(int weeksLeft) {
        this.weeksLeft = weeksLeft;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    //toString() method
    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", goalName='" + goalName + '\'' +
                ", goalDescription='" + goalDescription + '\'' +
                ", goalPrice=" + goalPrice +
                ", goalCount=" + goalCount +
                ", checkDate=" + checkDate +
                ", weeksLeft=" + weeksLeft +
                '}';
    }
}




