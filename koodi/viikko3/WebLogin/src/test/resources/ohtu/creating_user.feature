Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  a too short username "a" and password "salasana4" and matching password confirmation are entered
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  a valid username "jarmo" and a too short password "bc" and matching password confirmation are entered
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails with already taken username and valid password
        Given command new user is selected
        When  existing username "liisa" and password "salainen1" and matching password confirmation are entered
        Then user is not created and error "username is already taken" is reported 

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  a valid username "keijo" and password "sulasana3" and non-matching password confirmation are entered
        Then user is not created and error "password and password confirmation do not match" is reported 

    Scenario: user can login with successfully generated account
        Given user with username "lea" and password "salainen1" is successfully created
        And   login is selected
        When  correct username "lea" and password "salainen1" are given
        Then  user is logged in  

    Scenario: user can not login with account that is not successfully created
        Given user with username "aa" and password "bad" is tried to be created
        And   login is selected
        When  username "aa" and password "bad" are given
        Then  user is not logged and error "invalid username or password" is reported