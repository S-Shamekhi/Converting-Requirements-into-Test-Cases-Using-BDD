package calculator;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {
    private Calculator calculator;
    private double value1;
    private double value2;
    private double result;
    private String errorMessage;

    @Before
    public void before() {
        calculator = new Calculator();
        errorMessage = null;
    }
    @io.cucumber.java.en.Given("Two input values, {double} and {double}")
    public void twoInputValuesAnd(double arg0, double arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @io.cucumber.java.en.When("I multiple the two values")
    public void iMultipleTheTwoValues() {
        result = calculator.mul(value1, value2);
    }

    @io.cucumber.java.en.Then("I expect the result {double} for mul")
    public void iExpectTheResultForMul(double arg0) {
        Assert.assertEquals(arg0, result, 0.1);
    }


    @Given("Two input values for division, {double} and {double}")
    public void givenTwoInputValuesForDivision(double arg0, double arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When("I divide the two values")
    public void iDivideTheTwoValues() {
        try {
            result = calculator.divide(value1, value2);
            errorMessage = null;
        } catch (ArithmeticException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the division result should be <expected>")
    public void thenTheDivisionResultShouldBe(double expected) {
        Assert.assertNull("Expected numeric result but got error: " + errorMessage, errorMessage);
        Assert.assertEquals(expected, result, 0.0001);
    }


    @Then("division should give error {string}")
    public void thenDivisionShouldGiveError(String expectedError) {
        Assert.assertNotNull("Expected error message but got numeric result: " + result, errorMessage);
        Assert.assertEquals(expectedError, errorMessage);
    }


    @Given("Two input values for power operation,  {double} and {double}")
    public void givenTwoInputValuesForPowerOperation(double base, double exponent) {
        value1 = base;
        value2 = exponent;
    }


    @When("I raise the base to the power of the exponent")
    public void iRaiseTheBaseToThePowerOfTheExponent() {
        try {
            result = calculator.power(value1, value2);
            errorMessage = null;
        } catch (ArithmeticException e) {
            errorMessage = e.getMessage();
        }
    }


    @Then("the power result should be{double}")
    public void thenThePowerResultShouldBe(double expected) {
        Assert.assertNull("Expected numeric result but got error: " + errorMessage, errorMessage);
        Assert.assertEquals(expected, result, 0.0001);
    }



    @Then("power operation should give error {string}")
    public void powerOperationShouldGiveError(String expectedError) {
        Assert.assertNotNull("Expected error message but got numeric result: " + result, errorMessage);
        Assert.assertEquals(expectedError, errorMessage);
    }

}
