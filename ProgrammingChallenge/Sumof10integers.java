package ProgrammingChallenge;

import java.util.Scanner;

public class Sumof10integers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 1;
        int sum =0;

        while (i <= 10) {
            System.out.print("Ipunt Interger: ");
            int num = sc.nextInt();

            sum += num;
            i++;
        }
        System.out.println("Sum of Integer is: "+sum);
    }
}
