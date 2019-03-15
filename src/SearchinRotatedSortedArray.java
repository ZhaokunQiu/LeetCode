public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
        System.out.println(s.search(new int[]{5,1,2,3,4},1));
    }

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid]<nums[hi]){
                if(nums[mid] < target && target <= nums[hi]) lo = mid+1;
                else hi = mid-1;
            } else {
                if(nums[lo] <= target && target < nums[mid]) hi = mid-1;
                else lo = mid +1;
            }

        }
        return -1;
    }



}
