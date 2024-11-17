package ProgrammingChallenge;

import java.util.Scanner;



public class LargestNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first Number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second Number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter third Number: ");
        int num3 = sc.nextInt();

        

        int largestNum = largestNumber(num1, num2, num3);
        System.out.println("The largest number is: " + largestNum);
        
    }

    static int largestNumber(int num1, int num2, int num3){
        
        int largeNum = num1;
       
        if(num2 > largeNum){
            largeNum = num2;
        }else if(num3 > largeNum){
            largeNum = num3;
        } 
        return largeNum;
    }
}




