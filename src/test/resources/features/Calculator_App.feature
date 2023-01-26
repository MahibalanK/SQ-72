Feature: Add any two numbers in Android Native Calculator application

  @AddTwoNumbersInCalc
  Scenario Outline: User open calculator app in android mobile ,add two numbers passed
    through examples and verify the sum of those numbers are correct.

    Given : User Launch Android native calculator app in emulator
    And : User pass "<number1>" and "<number2>" to be entered in the app
    Then : User press addition operator and verify the result is equal to the "<result>"

    Examples:
      | number1 | number2     |  result |
      | 3       |   4          |     7     |