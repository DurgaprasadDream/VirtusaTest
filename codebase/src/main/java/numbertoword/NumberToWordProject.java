package numbertoword;

import java.util.Scanner;

public class NumberToWordProject {
    public static void main(String[] args) {
    	
	
    	NumberToWordProject obj = new NumberToWordProject();
      /*  System.out.println("*** " + obj.convert(123456789));
        System.out.println("*** " + obj.convert(-55));
        System.out.println("**********"+obj.convert(616166161));*/
       int inputNumber = inputNumber();
       obj.convert(inputNumber);
       System.out.println("INPUT NUMBER IS :: "+inputNumber);
       System.out.println("OUTPUT WORD IS :: "+obj.convert(inputNumber));
        
    }
    
    
    private static int inputNumber() {
    	
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    
    	
        
        boolean inputFlag = true;
        while (true) {
            System.out.println("PLEASE GIVE A NUMBER FOR CONVERTING TO WORD...");
            System.out.println("");
            try {
                int number = input.nextInt();
                return number;
            }catch (java.util.InputMismatchException e) {
            	input.nextLine();
            	System.out.println("PLEASE GIVE A VALID NUMBER AND NUMBER SHOULD NOT EXCEED 999999999 ...");
            	System.out.println("");
            	}
            }
        }
    
    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
        };
        
        private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
        };
        
        private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
        };
        
        private String convertLessThanOneThousand(int number) {
            String current;
            
            if (number % 100 < 20){
                current = numNames[number % 100];
                number /= 100;
            }
            else {
                current = numNames[number % 10];
                number /= 10;
                
                current = tensNames[number % 10] + current;
                number /= 10;
            }
            if (number == 0) return current;
            return numNames[number] + " hundred" + current;
        }
        
        public String convert(int number) {

            if (number == 0) { return "zero"; }
            
            String prefix = "";
            
            if (number < 0) {
                number = -number;
                prefix = "negative";
            }
            
            String current = "";
            int place = 0;
            
            do {
                int n = number % 1000;
                if (n != 0){
                    String s = convertLessThanOneThousand(n);
                    current = s + specialNames[place] + current;
                }
                place++;
                number /= 1000;
            } while (number > 0);
            
            return (prefix + current).trim();
        }

}
