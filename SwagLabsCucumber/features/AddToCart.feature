Feature: Add items to cart
 
Background: 
   Given User is on SwagLabsLogin page "https://www.saucedemo.com/"

  Scenario: Product add to the cart
   When User enters username as "standard_user" and password as "secret_sauce"
   Then User should be able to login sucessfully and navigate to iventory page with title "PRODUCTS"
   When I add an "Sauce Labs Backpack" to cart 
   Then click on the cart
   Then Should see "Sauce Labs Backpack"in cart