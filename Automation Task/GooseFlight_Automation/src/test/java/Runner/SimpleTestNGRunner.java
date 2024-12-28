package Runner;

import tests.FlightSearchTest;

import org.testng.annotations.Factory;

public class SimpleTestNGRunner {

    @Factory
    public Object[] createTests() {
        return new Object[] {
                new FlightSearchTest(),
        };
    }


}