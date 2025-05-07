# Converting-Requirements-into-Test-Cases-Using-BDD
After trying TDD we will take a look at BBD for converting Requirements into Test Cases using Behavior-Driven Development (BDD)
Based on your provided code and the structure of the sample report, here is a clean, well-organized report for your BDD-based calculator project that includes **multiplication**, **division**, and **power** operations. This is suitable for inclusion in your project’s `README.md` or project documentation:

---

##  هدف پروژه

هدف این پروژه، پیاده‌سازی تست‌های BDD برای یک کلاس ماشین‌حساب با پشتیبانی از عملیات‌های ریاضی زیر می‌باشد:

* ضرب دو عدد
* تقسیم دو عدد (همراه با مدیریت خطای تقسیم بر صفر)
* محاسبه توان (با مدیریت خطای توان منفی برای صفر)

این پروژه از متدولوژی BDD (Behavior-Driven Development) برای طراحی تست‌ها استفاده کرده تا ارتباط بین تیم توسعه و تحلیل نیازمندی‌ها واضح‌تر و تست‌ها قابل فهم‌تر باشند.

---

## فناوری‌های مورد استفاده

* **زبان برنامه‌نویسی:** Java
* **فریمورک‌های تست:**

  * Cucumber برای تعریف تست‌های BDD به زبان Gherkin
  * JUnit برای اجرای تست‌ها
* **ابزار مدیریت پروژه:** Maven
* **محیط توسعه:** IntelliJ IDEA
* **کتابخانه‌های اضافی:** بدون نیاز به کتابخانه خاصی به جز وابستگی‌های Cucumber

---

##  ساختار پروژه

```
bdd-calculator/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── calculator/
│   │           └── Calculator.java
│   └── test/
│       ├── java/
│       │   └── calculator/
│       │       ├── MyStepdefs.java
│       │       └── RunnerTest.java
│       └── resources/
│           └── features/
│               ├── calculator.feature
│               ├── division.feature
│               └── power.feature
```

---

بعد از تعریف سناریو ی هر فیچر با انتخاب  create step defenitions در فایل MyStepdefs.java متد های لازم را پیاده سازی می کنیم 
مشابه tdd اینجا باید بعد از  پیاده سازی  متد ها در فایل MyStepdefs.java باید متد مربوطه را در کلاس calculator  پیاده سازی کنیم 


##  کلاس Calculator
```java
public class Calculator {

    public double mul(double value1, double value2) {
        return value1 * value2;
    }

    public double divide(double value1, double value2) {
        if (value1 == 0) {
            throw new ArithmeticException("Error: Division by zero");
        }
        return value1 / value2;
    }

    public double power(double base, double exponent) {
        if (base == 0.0 && exponent < 0.0) {
            throw new ArithmeticException("Error: Zero cannot be raised to a negative exponent");
        }
        return Math.pow(base, exponent);
    }
}
```

---

## فایل‌های فیچر (Feature Files)

###  ضرب

```gherkin
Feature: Calculator

  Scenario: multiplying two numbers
    Given Two input values, -12.0 and -15.0
    When I multiple the two values
    Then I expect the result 180.0 for mul
```

###  تقسیم

```gherkin
Feature: Division Operation

  Scenario Outline: Dividing two numbers successfully
    Given Two input values for division, <number1> and <number2>
    When I divide the two values
    Then the division result should be <expected>

    Examples:
      | number1 | number2 | expected |
      | 10.0    | 2.0     | 5.0      |
      | 9.0     | 3.0     | 3.0      |
      | -10.0   | 2.0     | -5.0     |
      | 15.0    | -3.0    | -5.0     |

  Scenario: Division by zero should give error
    Given Two input values for division, 5.0 and 0.0
    When I divide the two values
    Then division should give error "Error: Division by zero"
```

###  توان

```gherkin
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
```

---

##  Step Definitions (`MyStepdefs.java`)

در این کلاس، پیاده‌سازی مراحل تعریف شده در Gherkin با زبان Java انجام شده و شامل مدیریت خطاهای ممکن نیز می‌باشد (مثل تقسیم بر صفر و صفر به توان منفی).

* مدیریت خطا با استفاده از `try/catch`
* مقایسه‌ی نتایج با `Assert.assertEquals`
* بررسی نمایش پیام خطا با `Assert.assertNotNull`

---

##  نحوه اجرای پروژه

### پیش‌نیازها:

* نصب Java JDK نسخه ۱۷ یا بالاتر
* نصب IntelliJ IDEA یا هر محیط توسعه سازگار با Maven و Java
* دیپندنسی های فایل pom.xml
  

### اجرای تست‌ها:

یا 
```bash
mvn test
```

یا از طریق دکمه Run در IntelliJ روی RunnerTest.java


## نتایج اجرای تست‌ها 

![Untitled](https://github.com/user-attachments/assets/fe6fca16-be7c-4f52-b894-1c97b3278e5b)


