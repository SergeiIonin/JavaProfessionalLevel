import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Test {
    int priority() default 5;
}

@Retention(RetentionPolicy.RUNTIME)
@interface BeforeSuite {
}

@Retention(RetentionPolicy.RUNTIME)
@interface AfterSuite {
}

@BeforeSuite
@Test
@AfterSuite
public class TestClass {

    Calculator calculator;

    @BeforeSuite
    public void beforeStart() {
        calculator = new Calculator();
        System.out.println("Before the test");
    }

    // This method is just for checking RuntimeException in case of using methods with @BeforeSuite more than once
    /*    @BeforeSuite
    public void beforeStar() {
       // calculator = new Calculator();
        System.out.println("Before");
    }*/

    @AfterSuite
    public void afterStart() {
        System.out.println("Test is finished");
    }

    // This method is just for checking RuntimeException in case of using methods with @AfterSuite more than once
    /* @AfterSuite
    public void after() {
        System.out.println("Finished");
    }*/

    @Test(priority = 2)
    public void checkSun() {
        System.out.print("+ ");
        TestHandler.compareInt(3, calculator.add(1, 2)); // OK
    }

    @Test(priority = 6)
    public void checkDif() {
        System.out.print("- ");
        TestHandler.compareInt(3, calculator.substr(1, 2));  // fail
    }

    @Test(priority = 6)
    public void checkProd() {
        System.out.print("* ");
        TestHandler.compareInt(2, calculator.mult(1, 2)); // OK
    }

    @Test(priority = 8)
    public void checkQuot() {
        System.out.print("/ ");
        TestHandler.compareInt(3, calculator.div(1, 2)); // fail
    }

}

