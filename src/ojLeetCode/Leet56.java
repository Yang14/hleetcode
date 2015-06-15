package ojLeetCode;

import ojLeetCode.Base.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet56 {
    public static void main(String[] args) {

        List<Interval> itls = new ArrayList<Interval>();
        itls.add(new Interval(1,4));
//        itls.add(new Interval(8,10));
        itls.add(new Interval(2,3));
//        itls.add(new Interval(12,15));

        List<Interval> result = merge(itls);

        for (Interval e : result){
            System.out.println(e.start +" " + e.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {

        //题意是合并给定区间中重叠的区间
        //易错的地方：如果一个区间包含另一个区间合并的结果应该是大的区间，
        // 这个在代码中用Math.max函数处理了

        //1.将给定的区间按start从小到大排序
        //2.从最小的开始向后合并区间
        //2.1前一个的end >= 后一个的start，区间重复
        //选前一个的start和后一个与前一个的end最大值，最为新区间
        //2.2不满足上面的条件，前一个区间后面不会被处理到，加入结果集
        //并更新比较用的区间
        if (intervals.size() < 1 ) return intervals;

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
