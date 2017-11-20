Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
       Given command login is selected
       When  username "pekka" and password "akkep" are entered
       Then  system will respond with "logged in"
<<<<<<< HEAD

    Scenario: user can not login with incorrect password
        Given command login is selected
        When  username "pekka" and password "pekka" are entered
        Then  system will respond with "wrong username or password"

    Scenario: nonexistent user can not login to 
        Given command login is selected
        When  username "kalle" and password "akkep" are entered
        Then  system will respond with "wrong username or password"
=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
