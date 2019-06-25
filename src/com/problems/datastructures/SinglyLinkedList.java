package com.problems.datastructures;

public class SinglyLinkedList<T> {

  private SinglyLinkedList<T> nextNode;
  private String value;
  
  public SinglyLinkedList() {
    
  }
  
  public boolean add(String value) {
    return true;
  }
  
  /**
   * Not implemented properly.
   * @param value
   * @return String
   */
  public String remove(String value) {
    
    if (this.value.equals(value)) {
      return null;
    } else {
      return remove(this.nextNode.value);
    }
  }
  public SinglyLinkedList getNextNode() {
    return nextNode;
  }

  public String getValue() {
    return value;
  }
}
