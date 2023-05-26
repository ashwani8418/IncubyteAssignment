package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.example.StringCalculator.Add;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
//        TestCase 1 passing empty string to Add method and expected result is 0;
        assertEquals(0, Add(""));

//        TestCase 2 passing "1" to Add method and expected result is 1;
        assertEquals(1, Add("1"));

//        TestCase 3 passing String number("1,2") separated by commas and expected result is 3
        assertEquals(3, Add("1,2"));


//    TestCase 4 passing String number("9099,10900,1,4859") unknown amount of number separated by commas and expected result is 24859
//        assertEquals(24859, Add("9099,10900,1,4859"));

//      Testcase 5 passing String number("1\n2,3") and expected sum value is 6
        assertEquals(6, Add("1\n2,3"));
        assertEquals(1, Add("1\n,"));
        assertEquals(10,Add("1\n2\n3\n4"));

//      Test case 6: Passing numbers ("//;\n1;2") with custom delimiter
        assertEquals(12, Add("//;\n1;2;\n9"));


//         Test case 7: Passing negative numbers and validating exception message
        try{
            StringCalculator.Add("-1,2,-3,6,8,-9");
            fail("Exception should be thrown for negative numbers");
        }catch (IllegalArgumentException e){
            assertEquals("negatives not allowed : [-1, -3, -9]", e.getMessage() );
        }

//        Test case 8: Passing number greater than 1000

        assertEquals(2,Add("2,1001"));
        assertEquals(168,Add("2,1001,6,160"));
        assertEquals(168,Add("2,1001,6;\n160"));
//        assertEquals(168,Add("//2+1001+6;\n160"));

//    Test case 9 Passing numbers with any number of delimiters
        assertEquals(6, Add("//[***]\n1***2***3"));

//    Test case 10   Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6

        assertEquals(6,Add("//[*][%]\n1*2%%%+3"));

    }


}
