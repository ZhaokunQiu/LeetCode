import java.security.KeyPair;
import java.util.*;

public class TopKFrequentElements {

    public class Pair{
        int first;
        int second;
        Pair(int a,int b){first=a;second=b;};
    }
    boolean cmp(Pair a,Pair b){
        return a.second>b.second;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> temp = new HashMap<>();
        for(int tem:nums){
            if(temp.containsKey(tem)){
                temp.put(tem,temp.get(tem)+1);
            }
            else temp.put(tem,1);
        }
        int size = temp.size();
        PriorityQueue<Pair> hel = new PriorityQueue<Pair>(size,new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2) {
                if(o1.second < o2.second){
                    return 1;
                }
                else if(o1.second > o2.second){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        Iterator<Map.Entry<Integer, Integer>> iterator = temp.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            hel.add(new Pair(entry.getKey(),entry.getValue()));
        }
        List<Integer> res = new ArrayList<>(k);
        for(int i=0;i<k;++i){
            res.add(i,hel.poll().first);
        }
        return res;
    }


    //高效的实现

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        if (length > 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int maxFreq = Integer.MIN_VALUE;
            int minFreq = Integer.MAX_VALUE;
            for (int n : nums) {
                if (n > max) {
                    max = n;
                }
                if (n < min) {
                    min = n;
                }
            }

            int range = max - min + 1;
            int[] frequency = new int[range];

            for (int n : nums) {
                frequency[n - min]++;
                if (frequency[n - min] > maxFreq) {
                    maxFreq = frequency[n - min];
                }
                if (frequency[n - min] < minFreq) {
                    minFreq = frequency[n - min];
                }
            }

            List<Integer>[] freqList = new ArrayList[maxFreq - minFreq + 1];
            for (int i = 0; i < range; ++i) {
                if (frequency[i] > 0) {
                    if (freqList[frequency[i] - minFreq] == null) {
                        freqList[frequency[i] - minFreq] = new ArrayList<>();
                    }
                    freqList[frequency[i] - minFreq].add(i + min);
                }
            }

            for (int i = freqList.length - 1; i >= 0 && res.size() < k; --i) {
                if (freqList[i] != null) {
                    res.addAll(freqList[i]);
                }
            }
        }
        return res;
    }
}
