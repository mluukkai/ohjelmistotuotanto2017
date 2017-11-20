package ohtu.domain;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
public class User {

    private String username;
    private String password;

<<<<<<< HEAD
    @Autowired
=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
