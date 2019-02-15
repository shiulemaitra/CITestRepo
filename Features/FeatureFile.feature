Feature: Login

Background: Launching Orion Portal
Given User navigates to Orion Portal
When I enter the username as "ssadm"
When I enter the password as "123456"
Then Login should pass


Scenario: PDF field data entries
When I click on Administrator menu
Then Scroll down the page
Then On clicking SearchFunction menu, user navigates to particular menu
When I click on Create button
Then I navigate to Create page
Then I enter all mandatory fields data with filepath





