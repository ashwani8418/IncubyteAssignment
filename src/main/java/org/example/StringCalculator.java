package org.example;

import java.util.ArrayList;
import java.util.List;

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
        String number2 = "//;\n1;2";
        System.out.println(Add(numbers));
        System.out.println(Add(number1));
        System.out.println(Add(number2));
//        System.out.println(Add("-1,2,-3,4,-5"));
        System.out.println(Add("21001"));
        System.out.println(Add("//[****]\n1*****2***3"));
    }

    public static int Add(String numbers){
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        } else if (numbers.length() > 1) {
            String delimiter = ",";
            String numbersOnly = numbers;
            if(numbers.startsWith("//")){
                int delimiterEndIndex = numbers.indexOf('\n');
                delimiter = numbers.substring(2, delimiterEndIndex);
                System.out.println(delimiter);
                numbersOnly = numbers.substring(delimiterEndIndex + 1);
            }
            numbersOnly = numbersOnly.replaceAll("[\n;+]", delimiter);
            String[] num = numbersOnly.split(delimiter);
            List<Integer> negativeNumber = new ArrayList<>();
            int sum = 0;
            for (String s : num) {
                if(s.isEmpty()){
                    sum += 0;
                }
                else{
                    int val = Integer.parseInt(s);
                    if(val < 0){
                        negativeNumber.add(val);
                    } else if (val <= 1000) {
                        sum += val;
                    }
                }
            }
            if(!negativeNumber.isEmpty()){
                throw new IllegalArgumentException("negatives not allowed : " + negativeNumber);
            }
            return sum;
        }

        return 0;
    }

}
