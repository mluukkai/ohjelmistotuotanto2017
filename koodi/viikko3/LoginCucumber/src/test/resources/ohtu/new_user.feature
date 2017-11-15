Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  username "Tontsa" and password "jeesuksenpylly69" is entered
        Then  system will respond with "new user registered"
    
    Scenario: creation fails with already taken username and valid password
        Given command new user is selected
        When  username "Pekka" and password "jeesuksenpylly69" is entered
        And username "Pekka" and password "JumalatonJuttu3" is entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  username "a" and password "jeesuksenpylly69" is entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new user is selected
        When  username "Tontsa" and password "a" is entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password enough long but consisting of only letters
        Given command new user is selected
        When  username "Tontsa" and password "jeesuksenpylly" is entered
        Then  system will respond with "new user not registered"

    Scenario: can login with successfully generated account
        Given user "eero" with password "salainen1" is created
        And   command login is selected
        When  username "eero" and password "salainen1" is entered
        Then  system will respond with "logged in"