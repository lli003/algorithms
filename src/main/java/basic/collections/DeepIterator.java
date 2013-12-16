package basic.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement an iterator that provides a flattening iterator over a
 * Collection<?>.
 * 
 * i.e. The constructor takes in a Collection<?> object which may nest
 * either a Collection<?> object or an object of type T.
 * Also, it is expected that the nested Collection<?> objects will not
 * reference their container Collection<?> objects as this will lead
 * to a loop. But they can nest other Collection<?> objects. The class
 * then iterates through elements in the given Collection<?> object,
 * returning the values in the leaves of the nested structure one-by-one
 * upon each call to next().
 *
 * Example: This deep iterator can be used to iterate over a vector that
 *          either contains a vector of integers, or just plain integers,
 *          or both. Lets assume that the Collection<?> passed has the
 *          following structure:
 *
 *                           [int_a, vector_1, int_d, vector_2, int_h]
 *                                     /                 \
 *                                    /                   \
 *                               [int_b, int_c]        [int_e, vector_3]
 *                                                                /
 *                                                               /
 *                                                         [int_f, int_g]
 *
 *          The iterator returns the leaves in order of: int_a, int_b,
 *          int_c, int_d, int_e, int_f, int_g, int_h.
 * 
 * Methods expected to be implemented:
 * 
 * public class DeepIterator<T> implements Iterator<T> {
 *                 public DeepIterator(Collection<?> collection) {..}
 *                 public boolean hasNext() {...}
 *                 public T next() {...}
 * }
 */

public class DeepIterator<T> implements Iterator<T> {
  
  /* reference of next element. */
  private T next;
  
  /* store the intermediate collection iterators. */
  private final Stack<Iterator<?>> stack = new Stack<Iterator<?>>();
  
  public DeepIterator(Collection<?> collection){
    if (collection == null){
      throw new NullPointerException("a null collection!");
    } else {
      stack.push(collection.iterator());
    }
  }

  @SuppressWarnings("unchecked")
  public boolean hasNext() {
    if (next != null)
      return true;
    
    while (!stack.empty()){
      Iterator<?> iterator = stack.peek();
      if (iterator.hasNext()){
        Object o = iterator.next();
        if (o instanceof Collection<?>){
          stack.push(((Collection<?>)o).iterator());
        } else {
          next = (T) o;
          return true;
        }
      } else 
        stack.pop();
    }
    
    return false;
  }

  public T next() {
    if (hasNext()){
      T cur = next;
      next = null;
      return cur;
    } else {
      throw new NoSuchElementException("No more elements!");
    }
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
  
  public static void main(String[] args){
    
    ArrayList<Object> list = new ArrayList<Object>();
    list.add(1);
    ArrayList<Integer> i1 = new ArrayList<Integer>();
    i1.add(2);
    i1.add(3);
    list.add(i1);
    
    list.add(4);
    ArrayList<Integer> i2 = new ArrayList<Integer>();
    i2.add(5);
    i2.add(6);
    list.add(i2);
    
    DeepIterator ni = new DeepIterator(list);
    while (ni.hasNext()){
      System.out.println((Integer)ni.next());
    }
  }

}
