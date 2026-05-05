Feature: Cart functionality on Demoblaze Application

Background:
  Given User is on the HomePage
  When user click the login link
  And user enters username as "Admin"
  And User enters password as "admin"
  And user click the log in button

@AddToCart
Scenario: Add a product to the cart
  When user clicks on a product named "Samsung galaxy s6"
  And user clicks the Add to cart button
  Then user should see a cart confirmation alert

@ViewCart
Scenario: View items in the cart
  When user navigates to the cart page
  Then user should see the cart with items

@DeleteFromCart
Scenario: Delete a product from the cart
  When user navigates to the cart page
  And user clicks the delete link on a cart item
  Then the item should be removed from the cart
