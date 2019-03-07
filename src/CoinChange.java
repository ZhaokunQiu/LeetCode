import java.lang.reflect.Array;
import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange c =new CoinChange();
        System.out.println(c.coinChange(new int[]{90,3,89},11));
    }

    public int coinChange(int[] coins, int amount) {
        if(coins.length==0||amount<0)
            return -1;
        int arr[]=new int[amount+1];
        Arrays.fill(arr,Integer.MIN_VALUE);
        arr[0]=0;
        arr[amount]=-1;
        for(int i=0;i<=amount;++i){
            for(int temp:coins){
                if(i-temp<0)
                    continue;
                else{
                    if(arr[i]<0&&arr[i-temp]>=0)
                        arr[i]=arr[i-temp]+1;
                    else if(arr[i-temp]>=0)
                        arr[i]=arr[i]<arr[i-temp]+1?arr[i]:arr[i-temp]+1;
                }
            }
        }
        return arr[amount];
    }

    private int minCnt = Integer.MAX_VALUE;

    //更高效的实现
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0)
            return -1;
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }

    private void coinChange(int[] coins, int amount, int index, int cnt) {
        if (index < 0)
            return;
        for (int i = amount / coins[index]; i >= 0; i--) {
            int curAmount = amount - coins[index] * i;
            int curCnt = cnt + i;
            if (curAmount > 0 && curCnt + 1 < minCnt)
                coinChange(coins, curAmount, index - 1, curCnt);
            else {
                if (curAmount == 0 && curCnt < minCnt)
                    minCnt = curCnt;
                break;
            }
        }
    }


}
