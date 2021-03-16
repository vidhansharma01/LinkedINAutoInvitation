@Connection
Feature: To validate that the user is able to send connection request

  Scenario: User sends connection request based on roles on LinkedIn
    Given User is on Welcome page
    When User enter email as "emial@gmail.com" & password "humptydumpty"
    And User click on My Network
    And User enters "sdet 3" in the search bar
    And User click on See all People link
    And User click on Connect button
    Then Connect requet is send
