Feature: Division Operation

  Scenario Outline: Dividing two numbers successfully
    Given Two input values for division, <number1> and <number2>
    When I divide the two values
    Then the division result should be <expected>

    Examples:
      | number1 | number2 | expected |
      | 10.0    | 2.0    | 5.0      |
      | 9.0     | 3.0    | 3.0      |
      | -10.0   | 2.0    | -5.0     |
      | 15.0    | -3.0   | -5.0     |

  Scenario: Division by zero should give error
    Given Two input values for division, 5.0 and 0.0
    When I divide the two values
    Then division should give error "Error: Division by zero"