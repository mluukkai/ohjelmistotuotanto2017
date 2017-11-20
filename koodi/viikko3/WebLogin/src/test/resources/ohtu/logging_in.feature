Feature: As a registered user can log in with valid username/password-combination

Scenario: user can login with correct password
Given login is selected
When correct username "jukka" and password "akkuj" are given
Then user is logged in

Scenario: user can not login with incorrect password
Given login is selected
When correct username "jukka" and incorrect password "wrong" are given
Then user is not logged in and error message is given
<<<<<<< HEAD

 Scenario: nonexistent user can not login to 
        Given login is selected
        When  nonexisting username "eiOle" and password "wrong" are given
        Then  user is not logged in and error message is given
=======
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
