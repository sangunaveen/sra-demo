#@madhu
Feature: Tours smoke tests

  Background:

    Given user is in landing page


  @smoke
  Scenario: User can go through the basic booking path

    When he go to "tour" tab
    And leave the default option and search
    When he select to "Details"
    Then he should see "DETAILS" text
    When he select to "Book Now"
    Then he should see "EXTRAS" text
#    When he select to "CONFIRM THIS BOOKING"
#    Then he should see "INVOICE" text




  Scenario Outline: User should select invalid mode as sea for transport and system should show error


    When he go to "visa" tab
    And he select the travelling by option as "<TravelMode>"
    And submits the form
    Then he should see and error message "<Error>"

    @smoke3@rajeswari
    Examples:

      | TravelMode | Error                                    |
      | Sea        | ETA is only required for arrival via Air |

  @smoke4
    Examples:

      | TravelMode | Error                                    |
      | Land       | ETA is only required for arrival via Airkjgkjgk |
      | Air        |                                          |








