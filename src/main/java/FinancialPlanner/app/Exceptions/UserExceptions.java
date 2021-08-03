package FinancialPlanner.app.Exceptions;

public class UserExceptions extends RuntimeException{
    public UserExceptions(Long id){super("user id not found "+id );}
}
