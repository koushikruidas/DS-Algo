package Math;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

public class ReverseInteger {
    public static int reverse(int x){
        int res = 0;
        while(x != 0){
            int digit = x % 10;
            /**
             * The maximum value for a 32-bit signed integer is Integer.MAX_VALUE, which is 2147483647.
             * When we divide it by 10 (Integer.MAX_VALUE / 10), we get 214748364.
             * If the current result is equal to this value and the next digit (digit) we want to add is greater than 7,
             * adding the digit will cause an overflow.
             *
             * Here's why:
             *
             * If result is already equal to Integer.MAX_VALUE / 10 (214748364),
             * then the next digit we want to add must be between 0 and 7 (inclusive) to prevent overflow.
             * If the next digit is 8 or 9, adding it to result will exceed the maximum value for a 32-bit signed integer, causing an overflow
             */
            if (res > Integer.MAX_VALUE / 10 ||(res == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }
            /**
             * For the minimum value of a 32-bit signed integer (Integer.MIN_VALUE), which is -2147483648,
             * the condition is result == Integer.MIN_VALUE / 10 && digit < -8
             */
            if (res < Integer.MIN_VALUE / 10 ||(res == Integer.MIN_VALUE / 10 && digit > 8)){
                return 0;
            }
            res = res*10 + digit;
            x = x/10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
