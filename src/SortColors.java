
public class SortColors {

    public static void main(String[] args) {
        SortColors s = new SortColors();
        s.sortColors(new int[]{0,2,1,2,0,0,1,2,1,1,1,0,2,1,2,1,1,1,1,2,1,0,0,0,1,2,2,0,2,1,0,0,1,2,2,
                1,2,1,0,0,0,0,2,0,2,1,2,1,1,1,1,0,1,2,0,0,0,0,0,0,2,1,1,0,0,1,1,0,0,0,0,1,1,2,2,0,2,1,1,1,2,0,1,1,1,0,2,
                1,1,2,2,0,1,0,0,1,0,2,2,1,2,1,2,0,0});
    }


    public void sortColors(int[] nums) {
        if(nums.length==0)
            return;
        int zeroIndex = 0;
        int twoIndex = nums.length -1;
        while(zeroIndex <= twoIndex && nums[zeroIndex] == 0)
            zeroIndex++;
        while(twoIndex >= zeroIndex && nums[twoIndex] == 2)
            twoIndex--;
        for(int i = zeroIndex;i <= twoIndex; ++i){
            switch(nums[i]) {
                case 0:
                    swap(nums,i,zeroIndex);
                    zeroIndex++;
                    break;
                case 2:
                    swap(nums,i,twoIndex);
                    twoIndex--;
                    i--;
                    break;
                default:
                    break;
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
