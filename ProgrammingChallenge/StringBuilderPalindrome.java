package ProgrammingChallenge;

import java.util.Scanner;

public class StringBuilderPalindrome {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a word: ");
        String s = sc.nextLine();
      
        StringBuilder reverse = new StringBuilder("madam");

        if (s.equals(reverse.reverse().toString())) {
            System.out.println("Palindrome");
        }else{
            System.out.println("Not a Palindrome");
        }
        
    }
}
