Feature: verification of adding ad to Memo as a favorite

  Background:
    Given User is on Home page
    Then User chooses category
    Then User chooses product

  Scenario: adding ad to Memo from Single Page

    Then User chooses single product
    Then User adds single product to memo
    When User gets to Memo page
    Then Verify ad is added to Memo Page


  Scenario: adding ad to Memo from Product Page

    Then User adds products from product list
    When User gets to Memo page from Product Page
    Then Verify ads are added from Product Page to Memo Page


  Scenario: adding ad to Memo from Search Result Page

    Then User gets to Search page
    When User fills out searching forms
    When Verify user is on Search Result page
    Then User adds products from list at Search Result Page
    When User gets to Memo page from Search Result Page
    Then Verify ads are added from Search Result Page to Memo Page


  Scenario: adding ad to Memo from Recently Viewed Tab on Memo Page

    Then User adds two products from product list
    Then User views single products
    When User gets to Recently Viewed Tab on Memo Page
    Then User adds product from Recently Viewed Tab
    Then Verify ad is added from Recently Viewed Tab to Memo Page