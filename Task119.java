import java.util.Scanner;

public class Task119 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter 2nd number: ");
        int num2 = sc.nextInt();

        System.out.println("Method of Addition: " + sum(num1,num2));
        System.out.println("Method of Subtraction: " + sub(num1,num2));
        System.out.println("Method of Division: " + div(num1,num2));
        System.out.println("Method of Multiplication: " + mult(num1,num2));
    }

    static int sum(int num1, int num2) {
        int add = num1 + num2;
        return add;  
    }
    static int sub(int num1, int num2) {
        int sub = num1 - num2;
        return sub;  
    }
    static int div(int num1, int num2) {
        int div = num1 / num2;
        return div;  
    }
    static int mult(int num1, int num2) {
        int mult = num1 * num2;
        return mult;  
    }
}
