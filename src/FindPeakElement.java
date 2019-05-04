public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (start + end) / 2;
            boolean flag = true;
            if(mid == 0 || nums[mid] > nums[mid - 1]){
                if(mid == nums.length - 1 || nums[mid] > nums[mid + 1]){
                    return mid;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                    end = mid - 1;
                }
            }
        return start;

    }
}
