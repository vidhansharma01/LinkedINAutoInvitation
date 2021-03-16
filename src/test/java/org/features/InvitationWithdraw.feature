Feature: To validate that the user can withdraw connection request

  Scenario: User is on Home Page and from there they try to withdraw connections
    Given User is on Welcome page
    When User enter email as "email@gmail.com" & password "humtydumpty"
    And User click on My Network
    And User click on Manage Text
    And User click on the Sent button
    And User click on the Withdraw button to withdraw the connection request
    Then The connection are withdrawn