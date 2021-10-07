Feature: Navigate Aspirations home page and verify products

  Scenario: User navigates from home page to products page and views products
    Given User launches Chrome browser
    When User clicks on Spend & Save
    Then Our products page should be displayed
    When User clicks on Get Aspiration
    Then Get Aspiration email input is displayed
    When User clicks on top right X
    Then User is brought back to our products page
    When User clicks on Get Aspiration Plus
    Then Yearly and Monthly Plan is displayed
