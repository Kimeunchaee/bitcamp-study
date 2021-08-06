package com.eomcs.pms0806.handler;

public class LinkedList extends List {

  //ArrayList와 LinkedList의  Generalization 수행
  //공통점 추출해서 수퍼클래스List 만들기


  // 1. List 클래스를 만든다
  // 2. 각각의 클래스에 extendx List 상속시킨다


  static class Node {
    //------------------------------------
    // 필드에는 공통점이없다
    Object item;
    Node next;

    public Node(Object item) {
      this.item = item;
    }
  }

  Node head;
  Node tail;
  int size;



  //------------------------------------
  //add메서드가 겹치므로 수퍼클래스로 옮긴다
  @Override
  public void add(Object item) {
    Node node = new Node(item);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;

      tail = node;
    }

    size++;
  }


  //------------------------------------
  // toArray메서드가 겹치므로 수퍼클래스로 옮긴다
  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; 

    Node node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.item;
      node = node.next;
    }

    return arr;
  }


  //------------------------------------
  // remove메서드가 겹치므로 수퍼클래스로 옮긴다
  @Override
  public boolean remove(Object item) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.item == item) { 
        if (node == head) {
          head = node.next; 
        } else { 
          prev.next = node.next;
        }

        node.next = null; 

        if (node == tail) { 
          tail = prev; 
        }
        size--;
        return true;
      }


      prev = node; 
      node = node.next; 
    }

    return false;
  }
}







