Feature: Create Address

  Background:
    Given User opens correct url

  Scenario Outline: Fill address
    When User opens address form
    And User enters address data "<alias>" "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"
    And User clicks save button
    And User sees "Address successfully added!" as success confirmation alert
    Then Data are correct "<alias>" "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"
    Examples:
      | alias | address     | postalCode | city     | country        | phoneNumber |
      | Adam  | Gadzinowski | 01-001     | Warszawa | United Kingdom | 123456789   |


  Scenario Outline: Fill address and remove it
    When User opens address form
    And User enters address data "<alias>" "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"
    And User clicks save button
    And User sees "Address successfully added!" as success confirmation alert
    Then Data are correct "<alias>" "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"
    When User removes address
    Then Box with address is not exist
    And User sees "Address successfully deleted!" as success confirmation alert
    Examples:
      | alias | address     | postalCode | city     | country        | phoneNumber |
      | Adam  | Gadzinowski | 01-001     | Warszawa | United Kingdom | 123456789   |