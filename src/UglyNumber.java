import java.util.*;
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int[] num = new int[index];
        if(index <= 6)
            return index;
        num[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        int size = 6;
        for (int i= 1; i < index; ++i){
            num[i] = Math.min(num[t2] * 2, Math.min(num[t3] * 3, num[t5] * 5));
            if(num[i] == num[t2] * 2)t2++;
            if(num[i] == num[t3] * 3)t3++;
            if(num[i] == num[t5] * 5)t5++;
        }
        return num[index - 1];
    }
}