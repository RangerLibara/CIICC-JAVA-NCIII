import java.util.Scanner;

public class ActivityPracticePalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String reverseWord = "";

        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        for(int i = word.length() - 1; i >= 0; i--)
            reverseWord = reverseWord + word.charAt(i);
      
        System.out.println(reverseWord);
        if (reverseWord.equals(word)) {
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

    }
}
