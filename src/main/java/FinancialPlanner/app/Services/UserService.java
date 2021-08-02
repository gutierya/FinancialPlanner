package FinancialPlanner.app.Services;


import FinancialPlanner.app.Models.User;
import FinancialPlanner.app.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void createUser(User user) {
        userRepo.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id); //add exception for user not found
    }

    public void deleteUser(Long id) {
        User currentUser = userRepo.getById(id);
        userRepo.delete(currentUser);
    }



}
