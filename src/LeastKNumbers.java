import java.util.ArrayList;
import java.util.PriorityQueue;

public class LeastKNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || k > input.length)
            return new ArrayList<>();
        quickSeek(input,0,input.length - 1,k);
        ArrayList<Integer> res = new ArrayList<>(k);
        for(int i = 0; i < k;i++)
            res.add(input[i]);
        return res;
    }


    private void quickSeek(int[] input, int start, int end, int k) {
        if(start >= end)
            return;
        int pivot = input[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && input[j] > pivot)
                j--;
            while(i < j && input[i] <= pivot)
                i++;
            if(i < j){
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }
        input[start] = input[i];
        input[i] = pivot;
        if(i < k)
            quickSeek(input,i + 1,end,k);
        if(i > k)
            quickSeek(input, start, i - 1,k);

    }
}
