import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));
        String ss = "Let's take LeetCode contest";
        String array[] = ss.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = array.length -1; i >= 0; i--){
            char[] temp = array[i].toCharArray();
            for(int j = temp.length-1;j>=0;j--){
                result.append(temp[j]);
            }
            result.append(' ');
        }
        result.deleteCharAt(result.length()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> kong = new LinkedList<>();
        result.add(kong);
        for(int temp : nums){
            List<List<Integer>> tr = new LinkedList<>();
            for(List<Integer> mid : result){
                List<Integer> zj = new LinkedList<>(mid);
                zj.add(temp);
                tr.add(zj);
            }
            for(List<Integer> mid : tr)
                result.add(mid);
        }
        return result;
    }
}
