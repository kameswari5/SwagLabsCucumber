Feature: Login to Swaglabs
 
Background: 
   Given User is on SwagLabsLogin page "https://www.saucedemo.com/"
  

    
   @InvalidCredentials
   Scenario Outline: Login with invalid credentials
      
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"
     
  Examples:
  | username               | password      | errorMessage                                                           |
  | locked_out_user     | secret_sauce | Epic sadface: Sorry, this user has been locked out.   |
  |                               | secret_sauce | Epic sadface: Username is required                          |
  |standard_user          |                     | Epic sadface: Password is required                           |
   
   @ValidCredentials
   Scenario: Login with valid credentials
      
    When User enters username as "standard_user" and password as "secret_sauce"
    Then User should be able to login sucessfully and navigate to iventory page with title "PRODUCTS"
    
    
 