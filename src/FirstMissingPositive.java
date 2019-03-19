public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length ==0)
            return 1;
        for(int i = 0;i<nums.length;++i){
            if(nums[i]<=0)
                nums[i] = nums.length+1;
        }
        int i = 0;
        for(int j =0;j<nums.length;++j){
            if(nums[j]>nums.length || nums[j]<0-nums.length)
                continue;
            else if(nums[j]<0 ){
                if(nums[0-nums[j]-1]>0)
                    nums[0-nums[j]-1] = 0 - nums[0-nums[j]-1];
            }
            else{
                if(nums[nums[j]-1]>0)
                    nums[nums[j]-1] = 0 - nums[nums[j]-1];
            }
        }
        for(;i<nums.length;++i){
            if(nums[i]>0)
                break;
        }
        return i+1;
    }
}
