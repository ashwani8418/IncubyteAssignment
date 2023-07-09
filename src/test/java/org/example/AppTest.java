package org.example;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
@SuppressWarnings("ALL")
public class AppTest {
    private StringCalculator strCalc;

    @BeforeTest
    public void init(){
        strCalc = new StringCalculator ();
    }

    @Test

    public void emptyReturnZero(){
        assertEquals (strCalc.add(""), 0);
    }
}
