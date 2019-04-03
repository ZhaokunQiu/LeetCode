public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 0)
            return true;
        int start = 0;
        int max = 0;
        int length = nums.length;
        while(start <= max && max < length){
            max = max > start + nums[start] ? max : start +nums[start];
            start ++;
        }
        if(max >= length -1)
            return true;
        return false;
    }
}
