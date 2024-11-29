package ProgrammingChallenge;

import java.util.Scanner;

public class computeDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amount of Item: ");
        double price = sc.nextDouble();

        
        computeDiscountInterface ten = (a,b)-> price - (price * .10);
        System.out.println("Amount Discounted by 10%: "+ ten.getDiscound(price, 0.10));

        computeDiscountInterface two = (a,b)-> price - (price * .20);
        System.out.println("Amount Discounted by 20%: " +two.getDiscound(price, 0.20));
        
        computeDiscountInterface fifty = (a,b)-> price - (price * .50);
        System.out.println("Amount Discounted by 50%: "+ fifty.getDiscound(price, 0.50));
    }

    public interface computeDiscountInterface {
        public double getDiscound(double a, double b);
    }
}
