import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Permutations {

    public static void main(String[] args) {
        Permutations p =new Permutations();
        Queue q =new ArrayBlockingQueue(12);


        System.out.println(p.permute(new int[]{1,2,3,4}));
    }

    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return null;
        result = new LinkedList() ;
        LinkedList<Integer> list = new LinkedList<>();
        for(int num :nums){
            list.add(num);
        }
        permuteOne(new LinkedList<Integer>(),list);
        return result;
    }
    void permuteOne(LinkedList<Integer> temp ,List<Integer> rest){
        if(rest.size()==1){
            temp.add(rest.get(0));
            result.add(temp);
        }
        else{
            int i=0;
            for(int cur:rest){
                LinkedList<Integer> newTemp = new LinkedList<>(temp);
                newTemp.add(cur);
                LinkedList<Integer> newRest = new LinkedList<>(rest);
                newRest.remove(i);
                i++;
                permuteOne(newTemp,newRest);
            }
        }
    }

    // 优秀解法
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int cur) {
        if (cur == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (Integer item : nums)
                temp.add(item);
            res.add(temp);
        } else for (int i = cur; i < nums.length; i++) {
            swap(nums, cur, i);
            dfs(res, nums, cur + 1);
            swap(nums, cur, i);
            //这里一定要交换回来，因为不是和C++一样是数组的拷贝，Java中是数组的引用，不能改变，不然得不到正确的结果
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
