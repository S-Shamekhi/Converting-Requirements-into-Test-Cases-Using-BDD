package calculator;

public class Calculator {


    public double mul(double value1, double value2) {
        return value1*value2;
    }

    public double divide(double value1, double value2) {
        if (value1 == 0) {
            throw new ArithmeticException("Error: Division by zero");
        }
        return value1/ value2;
    }

    public double power(double base, double exponent) {
        if (base == 0.0 && exponent < 0.0) {
            throw new ArithmeticException("Error: Zero cannot be raised to a negative exponent");
        }
        return Math.pow(base, exponent);
    }

}