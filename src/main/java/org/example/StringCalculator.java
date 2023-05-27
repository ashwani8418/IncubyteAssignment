package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class StringCalculator
{
    public static int Add(String numbers){
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        } else if (numbers.length() > 1) {
            if (numbers.contains (";")) {
                numbers = numbers.replace (";" , ",");
            }
            String delimiter = ",";
            String numbersOnly = numbers;
            if (numbers.startsWith ("//")) {
                int delimiterEndIndex = numbers.indexOf ('\n');
                delimiter = numbers.substring (2 , delimiterEndIndex);
                numbersOnly = numbers.substring (delimiterEndIndex + 1);
            }
            String[] num = numbersOnly.split("[\n" + delimiter + "]");
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
