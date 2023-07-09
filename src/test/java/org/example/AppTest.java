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

    @Test
    public void singleReturnValue(){
        assertEquals (strCalc.add("1"), 1);
    }

    @Test
    public void twoCommaSeparatedReturnSums(){
        assertEquals (strCalc.add("1,2"), 3);
    }

    @Test
    public void nCommaSeparatedReturnSums(){
        assertEquals (strCalc.add("1,2,3,4,5"), 15);
    }

    @Test
    public void twoLineSeparatedReturnSum(){
        assertEquals (strCalc.add("1\n2"), 3);
    }

    @Test
    public void nLineSeparatedReturnSum(){
        assertEquals (strCalc.add("1\n,2,3\n4,5"), 15);
    }

}
