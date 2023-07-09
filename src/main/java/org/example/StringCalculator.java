package org.example;
public class StringCalculator
{
    private static final String delimiter = "[^0-9-]";
    public static int add(String numbers) throws  Exception{
        String[] nums = numbers.split(delimiter);
        int sum = 0;
        int integerNum;
        for(String num : nums){
            try{
                integerNum = Integer.parseInt (num);
                if(integerNum < 0){
                    throw new Exception ("Negatives not allowed: " + getNegative(nums));
                } else {
                    if (integerNum <= 1000) {
                        sum += integerNum;
                    }
                }
            }
            catch (NumberFormatException e){
                continue;
            }
        }
        return sum;
    }

    private static String getNegative(String[] nums){
        StringBuilder negNum = new StringBuilder ();
        for(String num : nums){
            try{
                if(Integer.parseInt (num) < 0){
                    negNum.append (num).append (" ");
                }
            }
            catch (NumberFormatException e){
                continue;
            }
        }

        return negNum.toString ();
    }
}
