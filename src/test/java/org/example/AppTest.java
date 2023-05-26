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
        assertEquals(24859, Add("9099,10900,1,4859"));
    }

}
