Feature: Submit request functionality
  Scenario Outline: User Submit a request
    Given Since the user enters to CIIE
    When The user enters to CIIE with <userName> and password <pass>
    Then The user can view the Homepage and the user select new request
    Then Accept the terms and conditions
    And Complete form Step 1
    And Complete form Step 2
    And Complete form Step 3
    And Complete form Step 4
    And Complete form Step 5
    Then A new request is created

    Examples:
      |userName|pass|
      | pruebaQA@Khensys.com|123456|