package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals){
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(arr1, arr2) -> arr1[0] - arr2[0]);
        int[] current = intervals[0];
        list.add(current);
        for(int[] interval : intervals){
            int current_begin = current[0];
            int current_end = current[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            if(current_end >= next_begin){
                current[1] = Math.max(current_end,next_end);
            }
            else {
                current = interval;
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{4,6},{8,10},{10,18}};
        int[][] res = merge(intervals);
        System.out.println("Hllo");
    }
}
