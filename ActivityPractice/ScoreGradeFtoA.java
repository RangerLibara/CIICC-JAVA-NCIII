import java.util.Scanner;

public class ScoreGradeFtoA {

    public static void main(String[] args) {
       9
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your Grade: ");
        double grade = sc.nextDouble();
        if(grade >= 90){
            System.out.println("A score of: " + grade + " rating is A grade");
        }else if(grade >= 80 && grade <= 89){
            System.out.println("A score of: " + grade + " rating is B grade");
        }else if(grade >= 70 && grade <= 79){
            System.out.println("A score of: " + grade + " rating is C grade");
        }else if(grade >= 60 && grade <= 69){
            System.out.println("A score of: " + grade + " rating is B grade");
        }else if(grade < 60){
            System.out.println("A score of: " + grade + " rating is F grade");
        }
    }
    
}