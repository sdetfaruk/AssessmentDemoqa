Feature: Practice form
  @wip
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
    |First Name|Last Name|Gender|Email|Mobile| Subject | Hobbies |
    | Alan  | Dylon     |   Male   |  alan_dylon@adsdasd.com   |  4938274635    |    subject 1     |   Sports      |

