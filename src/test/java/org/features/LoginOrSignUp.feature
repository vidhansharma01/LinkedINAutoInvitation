Feature: Application Login

  Scenario: Home Page default login
    Given User is on Welcome page
    When User enter email as "djkwejjwerj@gmail.com" & password "hwhejkjje3kler"
    Then Home page is populated


  Scenario: User is on MyNetwork Page
    Given User is on Home Page
    When User click on My Network
    Then User is navigated to their network page


  Scenario: User sees his network
    Given User is on MyNetwork Page
    When User click on Manage Text
    And User click on the Sent button
    And User click on the Withdraw button to withdraw the connection request
    Then User is navigated to the Manage Invitations Page
