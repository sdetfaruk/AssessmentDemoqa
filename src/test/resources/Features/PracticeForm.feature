#Requirements
#Please keep the requirements same as they are displayed in that form:
#
#Mandatory
#•	Name (First and Last are mandatory with what it seems to be at least 1 alpha numeric character)
#•	Gender – any value selected
#•	Email (a valid email address)
#•	Mobile (10 digits)
#
#Optional
#•	All other fields
#
#When the form is successfully sent a popup is displayed showing all information that was sent.
@wip
Feature: Practice form
  @positive
  Scenario Outline: The user submits the form with valid data
      Given The user is on the practice form page
      When The user fills full name with "<First Name>" and "<Last Name>"
      And The user fills contact info with "<Email>" and "<Mobile>"
      And The user choses gender "<Gender>"
      And The user fills subject "<Subject>"
      And The user fills hobbies "<Hobbies>"
      And The user clicks the submit button
      Then The user should see the popup window with form details


    Examples:
      | First Name | Last Name | Gender | Email                  | Mobile     | Subject   | Hobbies |
      | Alan       | Dylon     | Male   | alan_dylon@adsdasd.com | 4938274635 | subject 1 | Sports  |
      | Alan       | Dylon     | Male   | alan_dylon@adsdasd.com | 4938274635 |           | Sports  |
      | Alan       | Dylon     | Male   | alan_dylon@adsdasd.com | 4938274635 | subject 1 |         |
      | Alan       | Dylon     | Male   | alan_dylon@adsdasd.com | 4938274635 |           |         |

    @negative
  Scenario Outline: The user submits the form with invalid data
    Given The user is on the practice form page
    When The user fills full name with "<First Name>" and "<Last Name>"
    And The user fills contact info with "<Email>" and "<Mobile>"
    And The user choses gender "<Gender>"
    And The user fills subject "<Subject>"
    And The user fills hobbies "<Hobbies>"
    And The user clicks the submit button with invalid data
    Then The user should not be able to submit the form


    Examples:
      | First Name | Last Name | Gender | Email                  | Mobile     | Subject   | Hobbies |
      | Alan       | Dylon     | Male   | alan_dylonadsdasd.com  | 4938274635 | subject 1 | Sports  |
      | Alan       | Dylon     | Male   | alan_dylon@adsdasd.com | 4938275    |           | Sports  |
      | Alan       | Dylon     | Male   | alan_dylon@adsdasd.com | 49382746xx | subject 1 |         |
      | Alan       |           | Male   | alan_dylon@adsdasd.com | 4938274635 |           |         |

