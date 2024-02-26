package Math;

import java.util.Random;

public class Power {
    //Given two integers x and n, write a function to compute xn. We may assume that x and n are small and overflow doesn’t happen.

    // Time: O(n) , Space: O(1)
    public static int power(int x, int n){
        int res = x;
        if (x == 0 ) return 0;
        if (n == 0 ) return 1;
        for (int i = 1; i < n; i++ ){
            res *= x;
        }
        return res;
    }

    // Time: O(n) Space: O(n)
    public static int power1(int x, int n){
        if (x == 0 ) return 0;
        if (n == 0 ) return 1;
        if (n % 2 == 0){
            return power1(x,n/2) * power1(x,n/2);
        }
        return x * power1(x,n/2) * power1(x,n/2);
    }

    // Time: O(logn) Space: O(logn)
    public static int power2(int x, int n){
        if (x == 0 ) return 0;
        if (n == 0 ) return 1;
        int temp = power2(x,n/2);
        if (n % 2 == 0 ) return temp*temp;
        return x*temp*temp;
    }

    // Time: O(log|n|) Space: O(log|n|)
    // Will accomodate negative powers too
    public static float power3(int x, int n){
        if (x == 0 ) return 0;
        if (n == 0 ) return 1;
        float temp = power3(x,n/2);
        if (n % 2 == 0 ) return temp * temp;
        else {
            if (n > 0) return x * temp * temp;
            else return (temp * temp) / x;
        }
    }

    static int getRandom(int size){
        return (int) (Math.random()*100) % size;
    }

    public static void main(String[] args) {
//        System.out.println(power3(2,-5));
//        for (int i = 0; i < 10; i++)
            System.out.println(power3(2,31));
    }
}
