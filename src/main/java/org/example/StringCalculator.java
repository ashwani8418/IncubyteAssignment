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
        String number1 = "1\n2,15";
        System.out.println(Add(numbers));
        System.out.println(Add(number1));
    }

    public static int Add(String numbers){
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        } else if (numbers.length() > 1) {
            numbers = numbers.replace("\n", ",");
            String[] num = numbers.split(",");
            int sum = 0;
            for (String s : num) {
                sum += Integer.parseInt(s);
            }
            return sum;
        }

        return 0;
    }

}
