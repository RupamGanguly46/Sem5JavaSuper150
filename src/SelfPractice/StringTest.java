package SelfPractice;

public class StringTest {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("Hello");
        System.out.println(s.charAt(0));
        String s2 = "Hello";
        System.out.println(s2.charAt(0));
        for(int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
    }
}
