public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{1,2,3,4,5,6}));
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int maxValue = Integer.MIN_VALUE;
        int left = 0;
        int right = length - 1;
        while(left < right){
            int hl = height[left];
            int hr = height[right];
            maxValue = maxValue > (right - left)*Math.min(hl,hr)? maxValue : (right - left)*Math.min(hl,hr);
            if(height[left] <= height[right]) {
                while(left < right && height[left] <= hl) left++;
            }else {
                while(left < right && height[right] <= hr) right--;
            }
        }
        return maxValue;
    }
}
