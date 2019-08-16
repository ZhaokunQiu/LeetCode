import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChongZuQiuHe extends Thread{
    int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> arr1 = new HashMap<>();
        Map<Integer, Integer> arr2 = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i< n; ++i) {
            int temp = sc.nextInt();
            int count = arr1.getOrDefault(temp,0);
            arr1.put(temp, count + 1);
        }
        for(int i = 0; i< n; ++i) {
            int temp = sc.nextInt();
            int count = arr2.getOrDefault(temp,0);
            arr2.put(temp,count + 1);
        }

        for(int i = m -1; i >=0 ; i--){
            for (Map.Entry<Integer, Integer> entry : arr1.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                int sum = i >= key ? i : i + m;
                int val2 = arr2.getOrDefault(sum - key,0);
                int min = val > val2 ? val2 : val;
                if(min > 0){
                    for(int j = 0 ; j < min; j++){
                        res.add(i);
                    }
                    arr1.put(key, val - min);
                    arr2.put(sum - key,val2 - min);
                }
            }
        }
        for(int temp : res)
            System.out.print(temp + " ");


    }


}
