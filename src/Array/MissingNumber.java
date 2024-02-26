package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {
    public static int find(int[] arr){
        int test = arr[0];
        int res = -1;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != test + i){
                res = test + i;
                return res;
            }
        }
        return res;
    }

    public static void sort(int[] arr){
        List<Integer> list = Arrays.stream(arr).boxed().sorted((a,b) -> b - a).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void main(String[] args) {

//        System.out.println(find(new int[] {0,1,2,4,5,6}));
        sort(new int[] {2,5,3,7,6,9,8});
    }
}
