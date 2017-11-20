package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {
<<<<<<< HEAD
    
    private UserDao userDao;
    
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }
    
=======

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }
<<<<<<< HEAD
        
        return false;
    }
    
    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        invalid(username, password, status);
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }
        
        if (username.length() < 3) {
            status.addError("username should have at least 3 characters");
        }
        
        if(!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }
        
=======

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }

>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
<<<<<<< HEAD
    
    private void invalid(String username, String password, CreationStatus status) {
        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }
        
        int numbers = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetter(password.charAt(i))) {
                numbers++;
            }
        }
        if (numbers == 0) {
            status.addError("password should contain atleast 2 of 3: letters, numbers, special characters");
        }
        
    }
    
=======

>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
}
