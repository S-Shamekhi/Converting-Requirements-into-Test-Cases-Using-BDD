Feature: Power operation


  Scenario Outline: Raising a number to a power successfully
    Given Two input values for power operation, <base> and <exponent>
    When I raise the base to the power of the exponent
    Then the power result should be <expected>

    Examples:
      | base | exponent | expected |
      | 2.0  | 3.0      | 8.0      |
      | 5.0  | 0.0      | 1.0      |
      | -2.0 | 2.0      | 4.0      |
      | -2.0 | 3.0      | -8.0     |
      | 4.0  | -2.0     | 0.0625   |

  Scenario: Zero raised to a negative exponent should give error
    Given Two input values for power operation, 0.0 and -1.0
    When I raise the base to the power of the exponent
    Then power operation should give error "Error: Zero cannot be raised to a negative exponent"

