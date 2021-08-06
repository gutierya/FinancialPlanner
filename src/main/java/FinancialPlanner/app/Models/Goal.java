package FinancialPlanner.app.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Goal {
    private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id Long id;
    @NotBlank(message = "Goal name is needed!")
    private String goalName;
    @NotBlank(message = "Goal description is needed!")
    private String goalDescription;// holds a brief description of what the goal is for
    @NotNull(message = "Goal target amount is needed!")
    private double goalPrice;// holds the price tage of the goal
    private double goalCount;// hold how much you have saved
    @NotNull(message = "Goal weekly target amount is needed!")
    private double goalWeekly;//holds how much they will pay each week
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate StartDate;// initializes start date of saving for goal
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkDate;// initializes a week from start to check to remind user to save money
    private int weeksLeft;// will hold a # of how many weeks are left until complete


    /**
     * every time we create a new object, this assigns the created new date
     */

    @PrePersist
    protected void whenCreate() {this.StartDate = LocalDate.now();//takes today's date
                                 this.checkDate = LocalDate.now().plusWeeks(1);// takes today's date and adds a week
    }





    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;// is mapped to user to hold all of his/her on going goals
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user2;// is mapped to user to hold all of his/her complete goals

    //constructors

    public Goal(){}
    public Goal(String goalName, String goalDescription, double goalPrice, double goalWeekly) {
        this.goalName = goalName;
        this.goalDescription = goalDescription;
        this.goalPrice = goalPrice;
        this.goalWeekly = goalWeekly;

    }
    // this calculates how many weeks it will take to reach their goal
    public void settingUpGoal(double goalPrice, double goalWeekly){
        this.weeksLeft = (int)Math.ceil(goalPrice / goalWeekly);
    }
    // this will check itself to make sure its updating when need be
    @Scheduled(cron="0 0 0 * * ?")// will be check everyday at 12:00AM
    public void checkingGoal(){
        if (LocalDate.now().equals(this.checkDate)){
            this.weeksLeft--;//this will take away a week
            this.goalCount+= this.goalWeekly;// this will add the money to the total saved to far
            this.checkDate = LocalDate.now().plusWeeks(1);// this will set a new check date for the next payment
        }
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

    public double getGoalWeekly() {
        return goalWeekly;
    }

    public void setGoalWeekly(double goalWeekly) {
        this.goalWeekly = goalWeekly;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
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




