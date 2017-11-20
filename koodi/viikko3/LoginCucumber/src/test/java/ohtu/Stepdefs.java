package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
<<<<<<< HEAD

=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    App app;
    StubIO io;
    UserDao userDao = new InMemoryUserDao();
    AuthenticationService auth = new AuthenticationService(userDao);
    List<String> inputLines = new ArrayList<>();
<<<<<<< HEAD

=======
    
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    @Given("^command login is selected$")
    public void command_login_selected() throws Throwable {
        inputLines.add("login");
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void a_username_and_password_are_entered(String username, String password) throws Throwable {
<<<<<<< HEAD
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
=======
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    }

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
<<<<<<< HEAD

    @Given("^command new user is selected$")
    public void command_new_user_is_selected() throws Throwable {
        inputLines.add("new");
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" is entered$")
    public void username_and_password_is_entered(String arg1, String arg2) throws Throwable {
        inputLines.add(arg1);
        inputLines.add(arg2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Given("^user \"([^\"]*)\" with password \"([^\"]*)\" is created$")
    public void user_with_password_is_created(String arg1, String arg2) throws Throwable {
        inputLines.add("new");
        inputLines.add(arg1);
        inputLines.add(arg2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
}