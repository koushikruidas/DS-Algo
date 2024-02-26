package Array;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int[] res = new int[nums.length];
        Set<Integer> set = new LinkedHashSet<>();
        for(int val : nums){
            set.add(val);
        }
        System.out.println("set size: "+set.size());
        int i = 0;
        for (Integer integer : set) {
            res[i] = (int) integer;
            i++;
        }
        for (int val : res){
            System.out.println(val);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println("::"+removeDuplicates(arr));
    }
}
