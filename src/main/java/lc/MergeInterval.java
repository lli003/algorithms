package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lc.util.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * @author leili
 *
 */
public class MergeInterval {

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    assert (intervals != null);
    ArrayList<Interval> result = new ArrayList<Interval>();
    if (intervals.size() == 0)
      return result;

    Comparator<Interval> comparator = new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        if (i1.start < i2.start)
          return -1;
        else if (i1.start > i2.start)
          return 1;
        else
          return 0;
      }
    };

    Collections.sort(intervals, comparator);

    result.add(intervals.get(0));
    for (int i = 1; i < intervals.size(); i++) {
      Interval last = result.get(result.size() - 1);
      result.remove(result.size() - 1);
      Interval toCheck = intervals.get(i);
      if (last.end < toCheck.start) {
        result.add(last);
        result.add(toCheck);
      } else {
        result.add(new Interval(last.start, Math.max(last.end, toCheck.end)));
      }
    }
    return result;
  }

}
