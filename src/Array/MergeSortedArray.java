package Array;

import java.util.Arrays;

public class MergeSortedArray {
    public static int[] merge(int[] ar1, int m, int[] ar2, int n){
        int[] temp = new int[m+n];
        int i = 0, j = 0, count = 0;
        while(i < m && j < n){
            if (ar1[i] <= ar2[j]){
                temp[count] = ar1[i];
                i++;
                count++;
            }
            else {
                temp[count] = ar2[j];
                j++;
                count++;
            }
        }
        while(i != m){
            temp[count++] = ar1[i];
            i++;
        }
        while(j != n){
            temp[count++] = ar2[j];
            j++;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] ar1 = {1,2,3};
        int[] ar2 = {2,5,6};
        Arrays.stream(merge(ar1,3,ar2,3)).forEach(s -> System.out.println(s));
    }
}
