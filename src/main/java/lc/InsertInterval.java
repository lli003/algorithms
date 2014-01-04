package lc;

import java.util.ArrayList;

import lc.util.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * @author leili
 *
 */
public class InsertInterval {

  public ArrayList<Interval> insert(ArrayList<Interval> intervals,
      Interval newInterval) {
    assert (intervals != null && newInterval != null);
    ArrayList<Interval> result = new ArrayList<Interval>();
    if (intervals.size() == 0) {
      result.add(newInterval);
      return result;
    }

    result.add(newInterval);
    for (int i = 0; i < intervals.size(); i++) {
      Interval last = result.get(result.size() - 1);
      result.remove(result.size() - 1);
      Interval toCheck = intervals.get(i);
      if (last.end < toCheck.start || last.start > toCheck.end) {
        if (last.start > toCheck.end) {
          result.add(toCheck);
          result.add(last);
        } else {
          result.add(last);
          result.add(toCheck);
        }
      } else {
        result.add(new Interval(Math.min(last.start, toCheck.start), Math.max(
            last.end, toCheck.end)));
      }
    }
    return result;
  }

}
