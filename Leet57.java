package ojLeetCode;

import ojLeetCode.Base.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet57 {
    public static void main(String[] args) {

        List<Interval> itls = new ArrayList<Interval>();
        itls.add(new Interval(1,2));
        itls.add(new Interval(3,5));
        itls.add(new Interval(6,7));
        itls.add(new Interval(8,10));
        itls.add(new Interval(12,15));

        Interval insert = new Interval(4,9);
        List<Interval> result = insert(itls,insert);

        for (Interval e : result){
            System.out.println(e.start +" " + e.end);
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        //比上一题多下面一行代码，其余代码和逻辑都一样
        //作为一个整体合并
        intervals.add(newInterval);

        List<Interval> result = new ArrayList<Interval>();

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Interval i1 = (Interval) o1;
                Interval i2 = (Interval) o2;
                if (i1.start > i2.start)
                    return 1;
                else if (i1.start == i2.start)
                    return 0;
                else return -1;
            }
        };

        Collections.sort(intervals,comparator);

        Interval m = intervals.get(0);
        for (int i=1;i<intervals.size();i++){
            Interval next = intervals.get(i);

            if(m.end >= next.start){
                m = new Interval(m.start,Math.max(m.end,next.end));
            }else {
                result.add(m);
                m = next;
            }
        }
        result.add(m);
        return result;
    }

}
