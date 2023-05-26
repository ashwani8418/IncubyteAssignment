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
        String number2 = "//;\n1;2";
        System.out.println(Add(numbers));
        System.out.println(Add(number1));
        System.out.println(Add(number2));
    }

    public static int Add(String numbers){
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        } else if (numbers.length() > 1) {
            if(numbers.startsWith("//")){
                numbers = numbers.substring(2);
            }
            if(numbers.contains("\n")){
                numbers = numbers.replace("\n", ",");
            }
            if(numbers.contains(";")){
                numbers = numbers.replace(";", ",");
            }
            String[] num = numbers.split(",");
            int sum = 0;
            for (String s : num) {
                if(s.isEmpty()){
                    sum += 0;
                }
                else{
                    sum += Integer.parseInt(s);
                }
            }
            return sum;
        }

        return 0;
    }

}
