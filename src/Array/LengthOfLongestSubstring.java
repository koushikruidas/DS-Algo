package Array;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int size = s.length();
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < size; i++){
            if(map.containsKey(s.charAt(i))){
                maxCount = Math.max(count,maxCount);
                i = map.get(s.charAt(i)) + 1;
                count = 0;
                map = new HashMap<>();
            }
            count++;
            map.put(s.charAt(i),i);
        }
        return Math.max(maxCount,count);
    }

    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
