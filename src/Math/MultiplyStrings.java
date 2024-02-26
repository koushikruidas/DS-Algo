package Math;

import java.util.Arrays;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int res = 0;
        String finalRes = "0";
        int carry = 0;
        String[] str = new String[Math.max(num1.length(),num2.length())];
        Arrays.fill(str, "");
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int inc = 0;
        for(int i = num2.length() - 1; i >= 0; i--){
            for(int j = num1.length() - 1; j >= 0; j--){
                int mul = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + + carry;
                int x = mul % 10 ;
                carry = mul / 10;
                str[inc] = x+str[inc];
            }
            if (carry != 0) {
                str[inc] = carry + str[inc];
                carry = 0;
                inc++;
            }
            else {
                inc++;
            }
        }
        for(int i = 1; i < str.length; i++){
            int j = i;
            while(j > 0){
                str[i] +='0';
                j--;
            }
        }
        for (String s : str) {
            finalRes = add(finalRes, s);
        }
        return finalRes;
    }

    public static String add(String a, String b){
        String res = "";
        int carry = 0;
        if(a.length() <= b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        while(ai >= 0 && bi >= 0){
            int x = (a.charAt(ai) - '0') + (b.charAt(bi) - '0') + carry;
            int di = x % 10;
            carry = x / 10;
            res = di + res;
            ai--;
            bi--;
        }
        while( ai >= 0){
            int x = a.charAt(ai) - '0' + carry;
            int di = x % 10;
            carry = x / 10;
            res = di + res;
            ai--;
        }
        while( bi >= 0){
            int x = b.charAt(ai) - '0' + carry;
            int di = x % 10;
            carry = x / 10;
            res = di + res;
            bi--;
        }
        if(carry != 0){
            res = carry + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(multiply("1234","4567"));
    }
}
