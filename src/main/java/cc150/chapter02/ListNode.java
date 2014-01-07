package cc150.chapter02;

public class ListNode {
  
  ListNode next = null;
  int val;
  
  public ListNode(int x){
    this.val = x;
  }
  
  public void append(int value){
    ListNode end = new ListNode(value);
    ListNode n = this;
    while (n.next != null)
      n = n.next;
    n.next = end;
  }
  
  public ListNode delete(ListNode head, int value){
    ListNode n = head;
    if (n.val == value)
      return head.next;
    while (n.next != null){
      if (n.next.val == value){
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
    return head;
  }

}
