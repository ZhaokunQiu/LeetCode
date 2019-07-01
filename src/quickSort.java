import java.util.PriorityQueue;

public class quickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,3,5,6};
        quickSort q = new quickSort();
        q.sort(nums,0,nums.length - 1);
        System.out.println(nums);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxK = new PriorityQueue<Integer>();

        // edge case: empty array
        if (nums.length == 0) return -1;

        // since k is given as always valid, we can safely do this
        for (int i = 0; i < k; i++)
            maxK.add(nums[i]);

        // for the rest of the numbers in the array, insert into the
        // priority queue if it is larger than the smallest number
        // in the queue and then remove the smallest number.
        for (int i = k; i < nums.length; i++) {
            if (maxK.peek() < nums[i]) {
                maxK.add(nums[i]);
                maxK.poll();
            }
        }

        // return the smallest number in the priority queue which
        // is the kth largest number in the array.
        return maxK.poll();
    }


    void sort(int[] nums, int start, int end){
        if(start >= end)
            return;
        int key = nums[start];
        int i = start, j = end;
        while(i < j){
            while(i < j && nums[j] <= key)
                --j;
            while(i < j && nums[i] >= key)
                ++i;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[start] = nums[i];
        nums[i] = key;
        sort(nums,start,i - 1);
        sort(nums,i + 1,end);
    }
}
