import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        String[] temp = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(temp,((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        StringBuilder result = new StringBuilder();
        if(temp[temp.length - 1].equals("0"))
            return "0";
        for(int i = nums.length - 1; i >=0; i--)
            result.append(temp[i]);
        return result.toString();
    }
}
