package FinancialPlanner.app.Controllers;


import FinancialPlanner.app.Models.Goal;
import FinancialPlanner.app.Services.ErrorsService;
import FinancialPlanner.app.Services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("goalview")
@CrossOrigin
public class GoalController {

    @Autowired
    private GoalService goalService;

    @Autowired
    private ErrorsService errorsService;

    //need to import goal class from evab/sebas
    @PostMapping("")
    public ResponseEntity<?> createGoal(@Valid @RequestBody Goal goal, BindingResult result) throws URISyntaxException {

        ResponseEntity<?> errors = errorsService.ErrorsValidation(result);
        if(errors!=null) {return errors; }

        Goal savedGoal = goalService.saveGoal(goal);
        return new ResponseEntity<Goal>(goal, HttpStatus.CREATED);

    }

    //need to double check id name from goal class
    @GetMapping("/{goalID}")
    public ResponseEntity<?> getGoalByID(@PathVariable Long goalID) {

        Goal gettingGoal = goalService.findById(goalID);

        return new ResponseEntity<Goal>(gettingGoal, HttpStatus.OK);

    }

    @GetMapping("/all")
    public Iterable<Goal> getAllGoals() {

        return goalService.getAllGoals();
    }


    @DeleteMapping("/goalID")
    public ResponseEntity<?> deleteGoal(@PathVariable Long goalID) throws Exception {

        goalService.deleteGoal(goalID);

        return new ResponseEntity<String>("Goal with id " + goalID + "was deleted.", HttpStatus.OK);
    }


    @PutMapping("/{goalID}")
    public ResponseEntity<?> updateGoal(@PathVariable Long goalID, @RequestBody Goal goal) {

//        Goal currentGoal = goalService.updateGoalByID()
        return null;
    }


}
