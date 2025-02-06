package GcashApp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		UserAuthentication userAuth = new UserAuthentication();

//		System.out.println("Enter your Name: ");
//		String name = sc.nextLine();
//		
//		System.out.println("Enter your Email: ");
//		String email = sc.nextLine();
		
		System.out.println("Enter your Number: ");
		String number = sc.nextLine();
		
		System.out.println("Enter your PIN: ");
		String pin = sc.nextLine();
		
		System.out.println("Enter your new PIN: ");
		String newpin = sc.nextLine();
		
//		userAuth.Registration(name, email, number, pin);
		userAuth.changePin(number, pin, newpin);
		
	}


}
