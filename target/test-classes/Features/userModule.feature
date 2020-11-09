Feature:
  Agile Story: As a Librarian, I should be able to manage user module

  Background:
    Given user is on the given url
    When user enters user name
    And user enters password and clicks the enter button

  @AC-1
  Scenario:As an authorized user, the librarian should be able to log in and see the dashboard page
    Then user should see dashboard page

  @AC-2
  Scenario: As an authorized user librarian should be able to choose users page

    Given user is on the main page
    When user clicks users module
    Then user should see user management page

  @AC-3
  Scenario Outline: As an authorized user,the librarian should be able to add user

    When user clicks users module
    And user clicks to add user button
    And user fills out fullname "<fullName>"
    And  User fills out password "<password>"
    And user fills out email "<email>"
    And user choose userGroup
    And  user chooses status
    And  User enters startDate "<startDate>"
    And  User enters endDate "<endDate>"
    And User enters address "<address>"
    And user clicks save changes button
    Then user should see saved user


    Examples:
      | fullName  | password | email                | userGroup | status   | startDate  | endDate    | address     |
      | Ali Mahir | 123abc   | alimahir@hotmail.com | 3         | INACTIVE | 2020-12-08 | 2020-12-12 | Columbus OH |

  @AC-6
  Scenario: As an authorized user , the librarian should be able to filter Users from user group dropdown

    When user clicks users module
    And user clicks user group dropdown
    Then user should see "Librarian" option on the table
    When user clicks forward button
    Then user should see selected option









