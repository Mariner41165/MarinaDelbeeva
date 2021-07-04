Feature: Complete home assignment. Part One

  Scenario: Assert the user is logged in
    Given Open Home Page
    When Perform login with username 'Roman' and password 'Jdi1234'
    Then Check that the user is logged in

  Scenario: Assert that there are 4 items on the header section are displayed and they have proper texts
    Given Open Home Page
    When Perform login with username 'Roman' and password 'Jdi1234'
    Then Check that there are 4 items on the header section are displayed and they have proper texts

  Scenario: Assert that there are 4 images on the Index Page and they are displayed
    Given Open Home Page
    When Perform login with username 'Roman' and password 'Jdi1234'
    Then Assert that there are 4 images on the Index Page and they are displayed

  Scenario: Assert that there are 4 texts on the Index Page under icons and they have proper text
    Given Open Home Page
    When Perform login with username 'Roman' and password 'Jdi1234'
    Then Assert that there are 4 texts on the Index Page under icons and they have proper text

    Scenario: Assert that there is the iframe with “Frame Button” exist
      Given Open Home Page
      When Perform login with username 'Roman' and password 'Jdi1234'
      Then Assert that there is the iframe with “Frame Button” exist

    Scenario: Switch to the iframe and check that there is “Frame Button” in the iframe
      Given Open Home Page
      When Perform login with username 'Roman' and password 'Jdi1234'
      And Switch to the iframe
      Then Assert that there is “Frame Button” in the iframe

    Scenario: Switch from frame to original window and assert that there are 5 items in the Left Section are displayed and they have proper text
      Given Open Home Page
      When Perform login with username 'Roman' and password 'Jdi1234'
      And Switch to the iframe
      And Switch back from frame
      Then Assert that there are 5 items in the Left Section are displayed and they have proper text
