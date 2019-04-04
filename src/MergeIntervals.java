import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        List<Interval> temp = new ArrayList<>();
        temp.add(new Interval (2,3));
        temp.add(new Interval (4,5));
        temp.add(new Interval (6,7));
        temp.add(new Interval (8,9));
        temp.add(new Interval (1,10));

        System.out.println(m.merge(temp));
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0)
            return new ArrayList<>();
        int size = intervals.size();
        Collections.sort(intervals, (o1, o2) -> o1.start < o2.start ? -1 : (o1.start == o2.start ? 0 : 1));
        return mergeIntervals(intervals, 0, size -1);
    }

    private List<Interval> mergeIntervals(List<Interval> intervals, int start, int end){
        if(start == end) {
            List<Interval> temp = new ArrayList<>();
            temp.add(intervals.get(start));
            return temp;
        }
        // divide
        int mid = (start + end) / 2;
        List<Interval> left = mergeIntervals(intervals,start,mid);
        List<Interval> right = mergeIntervals(intervals,mid + 1, end);

        // conquer
        int leftSize = left.size();
        int rightSize = right.size();
        List<Interval> res = new ArrayList<>();
        int i,j;
        for( i = 0,j = 0;i < leftSize && j < rightSize;){
            if(left.get(i).end < right.get(j).start){
                res.add(left.get(i));
                i++;
                continue;
            }
            else{
                Interval temp = new Interval();
                temp.start = left.get(i).start;
                temp.end = left.get(i).end > right.get(j).end ? left.get(i).end : right.get(j).end;

                j++;
                while(j < rightSize && right.get(j).start <= left.get(i).end){
                    temp.end = left.get(i).end > right.get(j).end ? left.get(i).end : right.get(j).end;
                    j++;
                }
                res.add(temp);
                i++;
            }
        }
        while(i < leftSize)
            res.add(left.get(i++));
        while(j < rightSize)
            res.add(right.get(j++));
        return res;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
