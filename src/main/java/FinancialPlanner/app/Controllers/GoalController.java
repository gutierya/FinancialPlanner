package FinancialPlanner.app.Controllers;


import FinancialPlanner.app.Models.Goal;
import FinancialPlanner.app.Models.User;
import FinancialPlanner.app.Services.ErrorsService;
import FinancialPlanner.app.Services.GoalService;
import FinancialPlanner.app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@CrossOrigin
@RestController
@RequestMapping("goalview")
public class GoalController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoalService goalService;

    @Autowired
    private ErrorsService errorsService;

    @CrossOrigin
    @PostMapping("/{userId}")
    public ResponseEntity<?> createGoalWithUser(@PathVariable Long userId,@Valid @RequestBody Goal goal, BindingResult result) throws URISyntaxException {

        ResponseEntity<?> errors = errorsService.ErrorsValidation(result);
        if(errors!=null) {return errors; }

        //finds user and retrieves all information within user
        User user = userService.getUserById(userId);
        //sets the goal to user
        goal.setUser(user);
        //this sets up how many weeks this goal will take
        goal.settingUpGoal(goal.getGoalPrice(), goal.getGoalWeekly());
        //then adds the goal to goal repo
        goalService.saveGoal(goal);

        return new ResponseEntity<Goal>(goal, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<?> createGoal(@Valid @RequestBody Goal goal, BindingResult result) throws URISyntaxException {
        ResponseEntity<?> errors = errorsService.ErrorsValidation(result);
        if(errors!=null) {return errors; }
        Goal savedGoal = goalService.saveGoal(goal);
        return new ResponseEntity<Goal>(goal, HttpStatus.CREATED);
    }



    @GetMapping("/{goalID}")
    public ResponseEntity<?> getGoalByID(@PathVariable Long goalID) {

        Goal gettingGoal = goalService.findById(goalID);

        return new ResponseEntity<Goal>(gettingGoal, HttpStatus.OK);

    }

    @GetMapping("/all")
    public Iterable<Goal> getAllGoals() {

        return goalService.getAllGoals();
    }


    @DeleteMapping("/{goalID}")
    public ResponseEntity<?> deleteGoal(@PathVariable Long goalID) throws Exception {

        goalService.deleteGoal(goalID);

        return new ResponseEntity<String>("Goal with id " + goalID + "was deleted.", HttpStatus.OK);
    }


    @PutMapping("/{goalID}")
    public ResponseEntity<?> updateGoal(@PathVariable Long goalID, @RequestBody Goal goal) {

        Goal currentGoal = goalService.updateGoalByID(goalID);

        return new ResponseEntity<Goal>(currentGoal, HttpStatus.OK);
    }


}
