package Array;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        int pos = partitionForSmallest(arr, l, r);
        if (pos == k - 1) return arr[pos];
        if (pos > k - 1) return kthSmallest(arr, l, pos - 1, k);
        return kthSmallest(arr, pos + 1, r, k);
    }

    static int partitionForLargest(int[] arr, int l, int r){
        int size = r - l;
        int var = (int) (Math.random()*100) % size;
        int pi = arr[l + var];
        int low = l - 1;
        for(int j = l; j <= r; j++){
            if(arr[j] > pi){
                low++;
                swap(arr,low,j);
            }
        }
        swap(arr,low + 1, l + var);
        return (low + 1);
    }

    static int partitionForSmallest(int[] arr, int l, int r){
        int pi = arr[r];
        int low = l - 1;
        for(int j = l; j < r; j++){
            if(arr[j] <= pi){
                low++;
                swap(arr,low,j);
            }
        }
        swap(arr,low + 1, r);
        return (low + 1);
    }

    static void swap(int[] arr, int l, int r){
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {12, 5, 787, 1, 23};
        System.out.println(kthSmallest(arr,0,4,2));
    }
}
