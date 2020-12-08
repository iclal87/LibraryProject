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
    Then user should see "<fullName>" user


    Examples:
      | fullName    | password | email            | startDate  | endDate    | address     |
      | robertrr | 123abc   | rtwnrsnd@hotmail.com | 2020-12-08 | 2020-12-12 | Columbus OH |
   #@AC-4
      #Scenario Outline: As an authorized user, the librarian should be able to edit user
      #When user clicks users module
      #And user clicks edit user button
      #And user make some necessary changes
      #And user clicks save changes button
      #Then user should see changes are made in the table

      #Examples:
       # | fullName  | password | email                |  startDate  | endDate    | address     |
        #| Vera Dengiz | 123abc   | alimahir@hotmail.com |  2020-12-08 | 2020-12-12 | Columbus OH |

  @AC-5
  Scenario Outline: As an authorized user , the librarian should be able to search by user id

    When user clicks users module
    And user clicks search box
    And user puts "<id>" in the search box
    Then user see given "<id>" in the table
    Examples:
      | id   |
      | 2042 |

  @AC-5SC2
  Scenario Outline: As an authorized user , the librarian should be able to search by full name

    When user clicks users module
    And user hits search box
    And user enters "<fullName>" in the search box
    Then user should see given "<fullName>" in the table
    Examples:
      | fullName       |
      | Jacinda Wehner |

  @AC-5SC3
  Scenario Outline: As an authorized user , the librarian should be able to search by email

    When user clicks users module
    Then user is clicking search box
    Then user is entering "<email>" in the search box
    Then user should be able to see given "<email>" in the table
    Examples:
      | email           |
      | ali@hotmail.com |


  @AC-6
  Scenario: As an authorized user , the librarian should be able to filter Users from user group dropdown

    When user clicks users module
    And user clicks user group dropdown
    Then user should see "Students" option on the table
    When user clicks forward button
    Then user should see selected option


  @AC-7
  Scenario: As an authorized user , the librarian should be able to filter User Status from status dropdown

    When user clicks users module
    And user clicks status dropdown
    And user selects "Inactive" from status dropdown
    When user hits forward button
    Then user should be able to see selected option on the table









