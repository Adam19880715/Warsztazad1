Feature: Buy sweater

  Background:
    Given User opened correct url
    And User is logged
    And User goes to main page


  Scenario Outline: Buy Hummingbird Printed Sweater
    When User selects "<productName>"
    Then User sees "Home Clothes Women Hummingbird printed sweater" breadcrumbs
    And User selects size "<size>"
    And User selects quantity "<quantity>"
    And User clicks add to cart button
    Then Modal with "Product successfully added to your shopping cart" success information is visible
    When User proceed to checkout
    Then User is on card page
    When User proceed to checkout
    And User enters address data "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"
    And User selects "PrestaShop" shipping method
    And User selects payment method
    And User agrees terms of service
    And User goes to next step
    Then User sees "YOUR ORDER IS CONFIRMED" title
    And User sees "An email has been sent to your mail address test1@test1.test1." information
    And User makes screenshot
    Examples:
      | productName                 | size | quantity |  |  | address     | postalCode | city     | country        | phoneNumber |
      | Hummingbird Printed Sweater | M    | 5        |  |  | Gadzinowski | 01-001     | Warszawa | United Kingdom | 123456789   |
