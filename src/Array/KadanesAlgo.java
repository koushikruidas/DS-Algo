package Array;

public class KadanesAlgo {
    // Driver Code
    public static void main(String[] args)
    {
        int[] a = { -1 };
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(a));
    }

    // Function Call
    static int maxSubArraySum(int a[])
    {
        int max_so_far = 0;
        int max = Integer.MIN_VALUE;
        for (int val : a){
            max_so_far += val;
            max = Math.max(max_so_far,max);
            max_so_far = Math.max(0,max_so_far);
        }
        return max;
    }
}
