package LeetCodeQuestions;

public class ValidPalindrome125 {
    public static String s = "A man, a plan, a canal: Panama";
    public static void main(String[] args) {
        System.out.println(validPal(s));
    }
    public static boolean validPal(String s) {
        s = format(s);
        boolean isValid = true;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
    public static String format(String s){
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length()];
        int j = 0;
        for(int i = 0; i < chars.length; i++) {
            if(Character.isLetterOrDigit(chars[i])){
                newChars[j] = chars[i];
                j++;
            }
        }
        return new String(newChars, 0, j);
    }
}
