public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray f = new FindFirstandLastPositionofElementinSortedArray();
        for(int a:f.searchRange(new int[]{5,7,7,8,8,10},8))
        System.out.println(a);
    }

    public int[] searchRange(int[] nums, int target) {
        int result[] = new int[]{-1,-1};
        int lo = 0,hi = nums.length - 1;
        int right = -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(target==nums[mid]){
                right = mid;
                break;
            }
            else if(target < nums[mid]){
                hi = mid -1;
            }
            else lo = mid + 1;
        }
        if(right == -1){
            result[0] = -1;
            result[1] = -1;
            return  result;
        }
        int left = right;
        while(left>=0&&nums[left]==target)
            left--;
        while(right<nums.length&&nums[right]==target)
            right++;
        result[0]=left+1;
        result[1]=right-1;
        return result;
    }
}
