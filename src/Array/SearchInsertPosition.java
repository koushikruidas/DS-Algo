package Array;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int index = bsearch(nums,0,nums.length - 1, target);
        if(index == -1){
            if(target > nums[nums.length - 1]) return nums.length;
            if(target < nums[0]) return 0;
            return searchInsertIndex(nums,0,nums.length - 1, target);
        }
        return index;
    }

    public static int bsearch(int[] arr, int start, int end, int target){
        if(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) return bsearch(arr, start, mid - 1, target);
            return bsearch(arr,mid + 1, end, target);
        }
        return -1;
    }

    public static int searchInsertIndex(int[] arr, int start, int end, int target){
            int mid = start + (end - start)/2;
            if(mid > 0 && arr[mid] > target && arr[mid - 1] < target) return mid;
            if(arr[mid] < target && arr[mid + 1] > target) return mid + 1;
            if(arr[mid] > target) return searchInsertIndex(arr, start, mid - 1, target);
            return searchInsertIndex(arr,mid + 1, end, target);
    }

    public static void main(String[] args) {
        int[] arr = {3,6,7,8,10};
        System.out.println(searchInsert(arr,5));
    }
}
