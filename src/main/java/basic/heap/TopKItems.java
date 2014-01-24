package basic.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class Item {
  String itemId;
  int count;

  Item(String itemId, int count) {
    this.itemId = itemId;
    this.count = count;
  }
}

public class TopKItems {

  /* basic idea: a max heap to store items with more count. */
  PriorityQueue<Item> queue = new PriorityQueue<Item>(10, new ItemComparator());
  HashMap<String, Integer> map = new HashMap<String, Integer>();

  public void recordPurchase(String itemId) {
    if (map.containsKey(itemId)) {
      map.put(itemId, map.get(itemId) + 1);
      Item item = new Item(itemId, map.get(itemId));
      if (!this.updateQueue(item)) {
        queue.add(item);
      }
    } else {
      map.put(itemId, 1);
      Item item = new Item(itemId, 1);
      queue.add(item);
    }
  }

  private boolean updateQueue(Item item) {
    boolean changed = false;
    Iterator<Item> iterator = queue.iterator();
    while (iterator.hasNext()) {
      Item i = (Item) iterator.next();
      if (i.itemId.equals(item.itemId)) {
        iterator.remove();
        changed = true;
        break;
      }
    }
    if (changed) {
      queue.add(item);
      return true;
    }
    return false;
  }

  public List<String> getTopTenPurchasedItems() {
    PriorityQueue<Item> newQueue = new PriorityQueue<Item>(queue);
    List<String> items = new ArrayList<String>();

    if (newQueue.isEmpty())
      return items;
    else {
      int size = newQueue.size();
      for (int i = 0; i < size; i++) {
        items.add(newQueue.remove().itemId);
      }
    }
    return items;
  }
}

class ItemComparator implements Comparator<Item> {
  public int compare(Item i1, Item i2) {
    if (i1.count > i2.count)
      return 1;
    else if (i1.count < i2.count)
      return -1;
    else
      return 0;
  }
}
