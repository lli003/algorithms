package basic.ds;

import java.util.LinkedList;

class HashtableNode {
  private Object key;
  private Object data;

  public HashtableNode() {
    this.key = null;
    this.data = null;
  }

  public HashtableNode(Object inKey, Object inData) {
    this.key = inKey;
    this.data = inData;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Object getKey() {
    return key;
  }

  public void setKey(Object key) {
    this.key = key;
  }

  /*
   * Equality can be based on key alone because there can't be 2 nodes with the
   * same key in the table
   */
  public boolean equals(Object obj) {
    if (obj instanceof HashtableNode) {
      HashtableNode node = (HashtableNode) obj;
      return this.key.equals(node.getKey());
    } else {
      return false;
    }
  }

  public String toString() {
    return "Key: [" + this.key + "] data: [" + this.data + "]";
  }
}

public class SimpleHashTable {

  private final int tableSize = 20;
  private int numElements;
  private Object[] table;

  private int hash(Object key) {
    /* Start with a base, just so that it's not 0 for empty strings */
    int result = 42;

    String inputString = key.toString().toLowerCase();

    char[] characters = inputString.toCharArray();
    for (int i = 0; i < characters.length; i++) {
      char currentChar = characters[i];

      if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c'
          || currentChar == 'e' || currentChar == 'e' || currentChar == 'f') {
        result += Integer.parseInt("" + currentChar, 16);
      }

      int j = (int) currentChar;
      result += j;
    }

    return (result % this.tableSize);
  }
  
  public boolean contains(Object key) {
    boolean result = false;
    int hash = this.hash(key);

    if (this.table[hash] != null) {
      HashtableNode node = new HashtableNode();
      node.setKey(key);
      if (((LinkedList<HashtableNode>)this.table[hash]).indexOf(node) > -1) {
        result = true;
      }
    }

    return result;
  }
  
  public void add(Object key, Object data) {
    if (data == null || key == null) {
      System.err.println("ERROR: Either the key or the data are null");
      return;
    }

    /* Don't add duplicate keys */
    if (this.contains(key)) {
      return;
    }

    /* Find out where in our array should the item go */
    int position = this.hash(key);

    /* If nothing exists in the position, create a new linked list there */
    if (this.table[position] == null) {
      this.table[position] = new LinkedList<HashtableNode>();
    }

    /* Add to the linked list in the appropriate position*/
    ((LinkedList<HashtableNode>)this.table[position]).add(new HashtableNode(key, data));
    this.numElements++;
  }

  public void add(Object [] keys, Object [] inputData) {
    for (int i = 0; i < inputData.length; i++) {
      this.add(keys[i], inputData[i]);
    }
  }
  
  public void remove(Object key) {
    int hashVal = this.hash(key);

    if (this.table[hashVal] != null) {
      HashtableNode node = new HashtableNode();
      node.setKey(key);

      if (((LinkedList<HashtableNode>)this.table[hashVal]).indexOf(node) > -1) {
        ((LinkedList<HashtableNode>)this.table[hashVal]).remove(node);
        this.numElements--;
      }
    }
  }

  public void remove(Object [] keys) {
    for (int i = 0; i < keys.length; i++) {
      this.remove(keys[i]);
    }
  }
  
  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(System.getProperty("line.separator"));
    buffer.append("{");
    buffer.append(System.getProperty("line.separator"));

    for (int i = 0; i < this.table.length; i++) {
      if (this.table[i] != null) {
        buffer.append("\t"+(LinkedList<HashtableNode>)this.table[i]);
        buffer.append(System.getProperty("line.separator"));
      }
    }

    buffer.append("}");

    return buffer.toString();
  }

  public int getNumElements() {
    return this.numElements;
  }

}
