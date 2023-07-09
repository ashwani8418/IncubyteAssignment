package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator
{
    private static final String delimeter = "[^0-9-]";
    public static int add(String numbers){
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        } else if (numbers.length() > 1) {

            String[] num = numbers.split(delimeter);
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
