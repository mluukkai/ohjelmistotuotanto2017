package ohtu.data_access;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InMemoryUserDao implements UserDao {

    private List<User> users;
    
=======

public class InMemoryUserDao implements UserDao {

    private List<User> users;

>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    public InMemoryUserDao() {
        users = new ArrayList<User>();
        users.add(new User("pekka", "akkep"));
    }        

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
