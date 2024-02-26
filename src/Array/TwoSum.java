package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++){
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget)){
                res[0] = i;
                res[1] = map.get(newTarget);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,3},6)));
    }
}
