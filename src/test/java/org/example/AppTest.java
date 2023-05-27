package org.example;
import junit.framework.TestCase;
import static org.example.StringCalculator.Add;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
//        TestCase 1 passing empty string to Add method and expected result is 0;
        assertEquals(0, Add(""));

//        TestCase 2 passing "1" to Add method and expected result is 1;
        assertEquals(1, Add("1"));
        assertEquals(50, Add("50"));
        assertEquals(1000, Add("1000"));
        assertEquals(0, Add("1001"));

//        TestCase 3 passing String number("1,2") separated by commas and expected result is 3
        assertEquals(3, Add("1,2"));
        assertEquals(313, Add("1,2,150,1500,160"));
        assertEquals(150, Add("10000,20000,150,1500,1600"));
        assertEquals(0, Add("10000,20000,1500,1500,1600,15064,465111566,4565645"));


//    TestCase 4 passing String number("9099,10900,1,4859") unknown amount of number separated by commas and expected result is 24859
        assertEquals(331, Add("1,10,20,100,200"));

//      Testcase 5 passing String number("1\n2,3") and expected sum value is 6
        assertEquals(6, Add("1\n2,3"));
        assertEquals(1, Add("1\n"));
        assertEquals(10,Add("1\n2\n3\n4"));

//      Test case 6: Passing numbers ("//;\n1;2") with custom delimiter
        assertEquals(12, Add("//;\n1;2;\n9"));
        assertEquals(12, Add("\n1;2;\n9"));


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


//    Test case 9 Passing numbers with any number of delimiters
        assertEquals(6, Add("//[***]\n1***2***3"));

//    Test case 10   Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6

        assertEquals(6,Add("//[*][%]\n1*2%+3"));
        assertEquals(12,Add("//[***][%****]\n6\n1*2%%%+3"));

    }


}
