public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums.length <2)
            return;
        quickSelect(nums, 0, nums.length -1);
        int mid = nums[nums.length - 1 >> 1];
        int left = 1;
        int right = (nums.length & 1) == 0 ? nums.length - 2 : nums.length - 1;
        int idx = 0;
        while(idx < nums.length){
            if(nums[idx] > mid && ((idx & 1) == 0 || idx > left)){
                int temp = nums[idx];
                nums[idx] = nums[left];
                nums[left] = temp;
                left += 2;
            }
            else if(nums[idx] < mid && ((idx & 1) == 1 || idx < right)){
                int temp = nums[idx];
                nums[idx] = nums[right];
                nums[right] = temp;
                right -= 2;
            }
            else idx++;
        }
    }

    private void quickSelect(int[] nums, int start, int end){
        int pivot = nums[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && nums[j] > pivot)
                j--;
            while(i < j && nums[i] <= pivot)
                i++;
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[start] = nums[i];
        nums[i] = pivot;
        if(i == nums.length - 1 >> 1)
            return;
        if(i < nums.length - 1 >> 1)
            quickSelect(nums, i + 1, end);
        else quickSelect(nums, start, i - 1);
    }
}
