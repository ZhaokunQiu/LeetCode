public class MaximumProductSubarray {


    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] record = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            record[i] = nums[i];
            max = max > nums[i] ? max : nums[i];
            for(int j = i + 1; j < nums.length; j++){
                record[j] = record[j - 1] * nums[j];
                max = max > record[j] ? max : record[j];
                if(record[j] == 0)
                    break;
            }
        }
        return max;
    }

    // 遍历一遍，到每一位的最大值只能是前一位的最大值或最小值与当前位的乘积的大者，或本身
    public int maxProduct2(int[] nums) {
        if(nums.length == 0)
            return 0;
        int result = nums[0];
        int max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            result = max > result ? max : result;
        }
        return result;
    }
}
