package String;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(isAlphabet(s.charAt(i)) || Character.isDigit(s.charAt(i)) ){
                str += Character.toLowerCase(s.charAt(i));
            }
        }
        int i = 0, j = str.length() - 1;
        while(i <= j){
            if( (Character.isAlphabetic(str.charAt(i)) || Character.isDigit(s.charAt(i)) )
                    && Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j)) ){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isAlphabet(char c){
        return ((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122);
    }

    public static void main(String[] args) {
        isPalindrome("0P");
    }
}
