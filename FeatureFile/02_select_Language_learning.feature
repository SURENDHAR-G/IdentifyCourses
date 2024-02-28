Feature: Language Learning

  @Smoke
  Scenario: select the language learning
    Given navigate to the home page
    When select the Language Learning Subject
    Then fetch the language learning counts
    And fetch the different level counts
