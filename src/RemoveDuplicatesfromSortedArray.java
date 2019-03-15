public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        Integer a = new Integer(100);
        String b = "aa";
        Object o =new Object();
        o.hashCode();
        System.out.println(b.hashCode());
    }

    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int mark = 1;

        for(int i=1;i<nums.length;++i,++mark)
            if(nums[i-1]!=nums[i]){
                nums[mark]=nums[i];
            }
            else {
                --result;
                mark--;
            }
        return result;
    }
}
