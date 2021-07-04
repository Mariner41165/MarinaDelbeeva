Feature: Complete home assignment. Part Two

  Scenario: Assert Username is logged in
    Given Open Home Page
    When Perform login with username 'Roman' and password 'Jdi1234'
    Then Check that the user is logged in

  Scenario: Open through the header menu Service -> Different Elements Page
    Given Open Home Page
    When Perform login with username 'Roman' and password 'Jdi1234'
    And Click on Different Elements in Service menu
    Then Assert that Page 'Different Elements' is opened

  Scenario: Select checkboxes Water, Wind
    Given Open Different Elements Page with credentials 'Roman' and 'Jdi1234'
    When Select checkboxes Water and Wind
    And Select radio Selen
    And Select Yellow color in dropdown
    Then Assert that for each chosen parameter an individual log row and corresponding value are displayed
