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
        if(!numbers.isEmpty()){
            return Integer.parseInt(numbers);
        }
        return 0;
    }

}
