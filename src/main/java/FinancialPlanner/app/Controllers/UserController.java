package FinancialPlanner.app.Controllers;

import FinancialPlanner.app.Models.Goal;
import FinancialPlanner.app.Models.User;
import FinancialPlanner.app.Services.ErrorsService;
import FinancialPlanner.app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userview")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ErrorsService errorsService;

    //retrieves all user to be seen
    @GetMapping("")
    List<User> viewAll(){

        return userService.getAllUsers();//gets and returns all users
    }
    // creates a new user to be stored
    @PostMapping("")
    ResponseEntity<?> createUser(@RequestBody User user, BindingResult result){
        // checks for any errors
        ResponseEntity<?> errors = errorsService.ErrorsValidation(result);
        if(errors!=null) {return errors; }
        //saves user to repo
        userService.createUser(user);
        //returns an Response of created
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    // finds user by id
    @GetMapping("/{userID}")
    public User getGoalByID(@PathVariable Long userID) {
        // is us
        User gettingUser = userService.getUserById(userID);

        new ResponseEntity<User>(gettingUser, HttpStatus.OK);//returns response that user was found
        return gettingUser;// returns the user

    }


}
