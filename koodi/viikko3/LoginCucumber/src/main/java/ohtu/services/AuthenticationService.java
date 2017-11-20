package ohtu.services;

import ohtu.domain.User;
<<<<<<< HEAD
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
=======
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
public class AuthenticationService {

    private UserDao userDao;

<<<<<<< HEAD
    @Autowired
=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
<<<<<<< HEAD
        if(username.length()<3) {
            return true;
        }
        
        if(password.length() < 8) {
            return true;
        }
        
        int numbers = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetter(password.charAt(i))) {
                numbers++;
            }
        }
        if(numbers==0) {
            return true;
        }
        
        numbers = 0;
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLowerCase(username.charAt(i))) {
                numbers++;
            }
        }
        
        if(numbers==0) {
            return false;
        }
=======
        // validity check of username and password
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f

        return false;
    }
}
