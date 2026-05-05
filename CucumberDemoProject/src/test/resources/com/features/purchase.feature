Feature: Purchase functionality on Demoblaze Application

Background:
  Given User is on the HomePage
  When user click the login link
  And user enters username as "Admin"
  And User enters password as "admin"
  And user click the log in button

@CompletePurchase
Scenario: Complete a purchase with valid details
  When user clicks on a product named "Samsung galaxy s6"
  And user clicks the Add to cart button
  Then user should see a cart confirmation alert
  When user navigates to the cart page
  And user clicks the Place Order button
  And user fills in the order form with name "John" and card "1234567890"
  And user clicks the Purchase button
  Then user should see the purchase confirmation message

@PurchaseWithoutName
Scenario: Place order without entering name
  When user clicks on a product named "Samsung galaxy s6"
  And user clicks the Add to cart button
  Then user should see a cart confirmation alert
  When user navigates to the cart page
  And user clicks the Place Order button
  And user fills in the order form with name "" and card "1234567890"
  And user clicks the Purchase button
  Then user should see a validation alert for missing details

@PurchaseWithoutCard
Scenario: Place order without entering card number
  When user clicks on a product named "Samsung galaxy s6"
  And user clicks the Add to cart button
  Then user should see a cart confirmation alert
  When user navigates to the cart page
  And user clicks the Place Order button
  And user fills in the order form with name "John" and card ""
  And user clicks the Purchase button
  Then user should see a validation alert for missing details
