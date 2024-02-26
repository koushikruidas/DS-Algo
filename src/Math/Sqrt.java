package Math;

public class Sqrt {
    public static int sqrt(int x){
        for (int i = 1; i <= x/2; i++){
            if(i*i == x) return i;
            if(i*i < x && (i+1)*(i+1) > x) return i;
            if(i*i > x && (i-1)*(i-1) < x) return i - 1;
        }

        return x; // to deal with x=0 case;
    }

    static int floorSqrt(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;

        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            // If x is a perfect square
            if (mid * mid == x)
                return (int)mid;

            // Since we need floor, we update answer when
            // mid*mid is smaller than x, and move closer to
            // sqrt(x)
            if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            }
            else // If mid*mid is greater than x
                end = mid - 1;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(8));
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }
}
