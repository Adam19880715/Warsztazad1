Feature: Create Address

  Scenario : create and add new address
    Given I have an open browser and log on created user
    When I enter site through tiles to user Address
    Then I check if page is open on Address Page
    When I create address and fill the form with "<alias>" "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"
    Then I checked if data are add it and correct with data "<alias>" "<address>" "<postalCode>" "<city>" "<country>" "<phoneNumber>"