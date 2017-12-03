Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When username "uusi" and password "passwordd" are entered
        Then system will respond with "new user registered"

    Scenario: creation fails with already taken username and valid password
        Given command new user is selected
        When  username "pekka" and password "akasasddaskep" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  username "a" and password "wadsadsadsadsadsa" are entered
        Then  system will respond with "new user not registered"


 Scenario: creation fails with valid username and password enough long but consisting of only letters
        Given command new user is selected
        When  username "apina" and password "" are entered
        Then  system will respond with "new user not registered"

    Scenario: can login with successfully generated account
        Given user "eero" with password "salainen1" is created
        And   command login is selected
        When  username "eero" and password "salainen1" are entered
        Then  system will respond with "logged in"