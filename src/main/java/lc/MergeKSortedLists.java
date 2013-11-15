package lc;

import java.util.ArrayList;

import lc.util.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author leili
 *
 */
public class MergeKSortedLists {

  public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0)
      return null;

    ListNode result = new ListNode(0);
    ListNode cur = result;

    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    while (lists.size() > 0) {
      // find the minimal node of the current list
      for (int i = 0; i < lists.size(); i++) {
        if (lists.get(i) != null && lists.get(i).val < min) {
          min = lists.get(i).val;
          minIdx = i;
        }
      }
      if (minIdx == -1)
        return result.next;

      cur.next = new ListNode(min);
      cur = cur.next;
      ListNode minNode = lists.get(minIdx);
      minNode = minNode.next;
      if (minNode == null)
        lists.remove(minIdx);
      else
        lists.set(minIdx, minNode);
      min = Integer.MAX_VALUE;
      minIdx = -1;
    }
    return result.next;
  }

}
