import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t =new TrappingRainWater();

        System.out.println(t.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
    }

    public int trap(int[] height) {
        int result = 0;
        if(height.length == 0 ||height.length == 1 ||height.length == 2)
            return 0;
        int index = 0;
        LinkedList<Integer> peaks = new LinkedList<>();
        while(index + 1< height.length){
            if(height[index]<=height[index+1]){
                ++index;
            }
            else break;
        }
        peaks.push(index);
        index+=2;
        for(;index<height.length;++index){
            if(height[index]< height[index -1]){
                int peak = index -1;
                while(!peaks.isEmpty()&& ((height[peak = peaks.peek()]) <height[index  -1]))
                    peaks.pop();
                peaks.push(index -1);
                result += capacity(height, peak,index-1);
                while(index < height.length&&height[index]<=height[index-1])
                    ++index;
            }
        }
        int peak = height.length -1;
        while(!peaks.isEmpty() && ((height[peak = peaks.peek()]) < height[height.length -1]))
            peaks.pop();
        result += capacity(height,peak,height.length -1);
        return result;
    }

    int capacity(int[] height, int start , int end){
        int sum = 0;
        int heig = Math.min(height[start],height[end]);
        for(int i = start + 1 ;i<end;++i){
            if(heig>height[i]) {
                sum += (heig - height[i]);
                height[i] = heig;
            }
        }
        return sum;
    }

    //巧妙解法
    public int trap2(int[] height) {
        int left = 0, right = height.length-1;
        int ans = 0;
        int left_max = 0;
        int right_max = 0;

        while(left<right){
            if(height[left]<height[right]){ //这里用来保证即使中间都为0，也能够有效的计算蓄水面积
                if(height[left]>=left_max){
                    left_max = height[left];
                }
                else{
                    ans += left_max-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=right_max){
                    right_max = height[right];
                }
                else{
                    ans+=right_max-height[right];
                }
                right--;
            }
        }
        return ans;
    }


}
