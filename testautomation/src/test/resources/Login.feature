Feature: Authentication Functionality
  Scenario Outline: User Authentication
    Given Since the user enters to CIIE
    When The user enters to CIIE with <userName> and password <pass>
    Then The user can view the Homepage
    And Close the browser

    Examples:
    |userName|pass|
    | pruebaQA@Khensys.com|123456|
