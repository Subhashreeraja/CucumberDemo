Feature:Categories of the Demoblaze Application


Background:
Given User is on the HomePage

@VisibleCategories
Scenario: Display all the categories
Then  user should see the all categories

@LaptopsCategory
Scenario: Display the laptop category
When the user click the laptop section
Then the user should see the various laptop options

@MonitorsCategory
Scenario: Display the monitors category

When the user click the monitor section
Then the user should see the various monitor options