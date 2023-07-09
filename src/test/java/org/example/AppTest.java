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

    public void emptyReturnZero () throws Exception{
        assertEquals (strCalc.add(""), 0);
    }

    @Test
    public void singleReturnValue() throws Exception{
        assertEquals (strCalc.add("1"), 1);
    }

    @Test
    public void twoCommaSeparatedReturnSums() throws Exception{
        assertEquals (strCalc.add("1,2"), 3);
    }

    @Test
    public void nCommaSeparatedReturnSums() throws Exception{
        assertEquals (strCalc.add("1,2,3,4,5"), 15);
    }

    @Test
    public void twoLineSeparatedReturnSum() throws Exception{
        assertEquals (strCalc.add("1\n2"), 3);
    }

    @Test
    public void nLineSeparatedReturnSum() throws Exception{
        assertEquals (strCalc.add("1\n,2,3\n4,6"), 16);
    }

    @Test

    public void twoAnyDelimeterSeparatedReturnSum() throws Exception{
        assertEquals (strCalc.add ("//;\\n1;2"), 3);
    }

    @Test
    public void nAnyDelimiterSeparatedReturnSum() throws Exception{
        assertEquals (strCalc.add("//;\\n1XY;2_+3(4)$5"),15);
    }

    @Test(expectedExceptions = Exception.class, expectedExceptionsMessageRegExp = "^Negatives not allowed: -1.*")
    public void singleNegativeThrowsException() throws Exception{
        try{
            strCalc.add ("-1");
        }
        catch (Exception e){
            System.out.println (e.getMessage ());
            throw e;
        }
    }

    @Test(expectedExceptions = Exception.class, expectedExceptionsMessageRegExp = "^Negatives not allowed: -1 -10 -11 -12.*")
    public void  nNegativesThrowsException() throws Exception{
        try {
            strCalc.add("-1,5,-10,-11,-12,9,20");
        }
        catch (Exception e){
            System.out.println (e.getMessage ());
            throw e;
        }
    }
}