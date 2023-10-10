Feature: Login feature to SFDC application

  @smoke
  Scenario: Login Error Message
    Given Launch App "https://login.salesforce.com/"
    When User enters User Name "anusha@tek.com"
    And User clears the Password field
    And User clicks on the Login button
    Then User should see the error message "Please enter your password." should be displayed
    And Close the browser

    @regression
    Scenario Outline: Login with multiple creds
    Given Launch App "https://login.salesforce.com/"
    When User enters User Name <username>
    And User enters Password <password>
    And User clicks on the Login button
    Then User should be navigated to Home page
    And Close the browser
    
    Examples:
|username|password|
|"anusha@tek.com"|"Sumedh@03"|  
|"anu@tek.com"|"Sumedh@03"| 
|"anusha@tek.com"|"Sumedh"| 
|"anu@tek.com"|"Sume"|  