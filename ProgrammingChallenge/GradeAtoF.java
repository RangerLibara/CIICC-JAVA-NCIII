package ProgrammingChallenge;

import java.util.Scanner;

public class GradeAtoF {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your Grade: ");
        int grade = sc.nextInt();

        if(grade >= 95) {
            System.out.println("Ratings: A");
        }else if(grade >= 90 || grade < 95){
            System.out.println("Ratings: B");
        }else if(grade >= 85 || grade < 90){
            System.out.println("Ratings: C");
        }else if(grade >= 80 || grade < 85){
            System.out.println("Ratings: D");
        }else if(grade >= 75 || grade < 80){
            System.out.println("Ratings: E");
        }else if(grade < 75){
            System.out.println("Ratings: F");
        }
    }
}
