Feature: Courses details

  @Sanity
  Scenario: Fetch the course details from coursera site
    Given user search the WebDevelopment in search bar
    When user click on the webDevelopment course
    And user select the English Language in Filter
    And user select the Beginner Level in Filter
    Then user fetch the first two courses details
