Feature: Search Box Functionality
  Agile Story: As a librarian, l should be able to search for the books by name, author,category, year, borrowed by
  and ISSS by typing them on the search box and clicking on it

  Background:
    Given user is on the given url
    When user enters user name
    And user enters password and clicks the enter button
    When user clicks books module
    And user clicks on search box

  @US1-AC1
  Scenario Outline: As a librarian l should be able to search books by name


    And user puts "<book name>" in the box
    Then user should see the given "<book name>" in the table

    Examples:
      | book name |
      | Ali Nino  |

  @US1-AC2
  Scenario Outline: As a librarian l should be able to search books by category
    And user puts "<author>" in the box
    Then user should see the given "<author>" in the table
    Examples:
      | author  |
      | Ahmet Altan|
