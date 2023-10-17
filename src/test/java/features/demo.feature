Feature: Login to Application
#  Scenario: Verify login is successful for NetBanking
#    Given User is on NetBanking page
#    When user login into the application with "admin" and password "admin"
#    Then Home Page is displayed

  @Smoke
  Scenario Outline:
    Given User is on NetBanking page
    When user login into application "<username>" and password "<password>" with multiple data
    Then Home Page is displayed
    Examples:
      | username       | password |
      | debituser      | user123  |
      | creditcarduser | user123  |