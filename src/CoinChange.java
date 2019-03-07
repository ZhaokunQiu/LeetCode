import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class CoinChange {
    private static int[] help = new int[10000];
    public int coinChange(int[] coins, int amount) {
        boolean flag = true;
        int num =0 ;
        int size =1;
        help[0]=0;
        Set<Integer> helper1= new HashSet<>();
        Set<Integer> helper2= new HashSet<>();
        helper2.add(0);
        while(flag){
            helper1 = helper2;
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
        }
        return 0;
    }
}
