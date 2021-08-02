package FinancialPlanner.app.Controllers;


import FinancialPlanner.app.Services.ErrorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@RequestMapping("goalview")
@CrossOrigin
public class GoalController {

//    @Autowired - to call the service Kyle creates (can rename)
//    private GoalService goalService;

    @Autowired
    private ErrorsService errorsService;

    //need to import goal class from evab/sebas
    @PostMapping("")
    public ResponseEntity<?> createGoal(@Valid RequestBody Goal goal, BindingResult result) throws URISyntaxException {

        ResponseEntity<?> errors = errorsService.ErrorsValidation(result);
        if(errors!=null) {return errors; }

        //Todo: implement saving posted goal by calling goal service
        return null;
    }

    //need to double check id name from goal class
    @GetMapping("/{goalID}")
    public ResponseEntity<?> getGoalByID(@PathVariable String goalID) {

        //Todo: implement finding goal by id by calling goal service

        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGoals() {

        //Todo: call goalboard service by returning goalservice."findallGoals"

        return null;
    }


    @DeleteMapping("/goalID")
    public ResponseEntity<?> deleteGoal(@PathVariable String goalID) {

        //Todo: call goalboard service method that deletes goal by id

        return null;
    }

    ////need to import goal class from evab/sebas
    @PutMapping("/{goalID}")
    public ResponseEntity<?> updateGoal(@PathVariable String goalID, @RequestBody Goal goal) {

        //Todo: call goal service to update goal by id

        return null;
    }


}
