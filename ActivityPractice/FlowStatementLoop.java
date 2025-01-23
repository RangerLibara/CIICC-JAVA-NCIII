public class FlowStatementLoop {

    public static void main(String[] args) {
        int check_number = 10;
        String message = "";
        int i =1;

        while (i<=check_number) {
            message = (i%2==0) ? i+" is even number" : i+" is odd number";
            System.out.println(message);
            i++;
        }
    }
}