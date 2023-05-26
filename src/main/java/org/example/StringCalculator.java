package org.example;

/**
 * Hello world!
 *
 */
public class StringCalculator
{
    public static void main( String[] args )
    {
        String numbers = "";
        System.out.println(Add(numbers));
    }

    public static int Add(String numbers){
        if(numbers.equals("1")){
            return 1;
        }
        return 0;
    }

}
