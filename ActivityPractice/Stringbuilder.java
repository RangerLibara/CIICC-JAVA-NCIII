

public class Stringbuilder {

    public static void main(String[] args) {
        
        StringBuilder a = new StringBuilder("abc");
        a.append("def");
        StringBuilder b = a.append("ghijk");
        System.out.println(b);

 }
}
