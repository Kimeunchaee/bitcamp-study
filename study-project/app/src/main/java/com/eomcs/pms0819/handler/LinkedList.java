package com.eomcs.pms0819.handler;

// public class LinkedList implements List {
public class LinkedList extends AbstractList {
  static class Node {
    Object item;
    Node next;

    public Node(Object item) {
      this.item = item;
    }
  }

  Node head;
  Node tail;
  //int size;

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

  // 추가
  //  @Override
  //  public int size() {
  //    return this.size;
  //  }

  //추가
  @Override
  public Object get (int index) {
    if (index < 0 || index >= this.size) {  //유효하지 않은 인덱스인 경우
      return null;
    }
    Node node = this.head;

    for (int i = 0; i < this.size; i++) {
      if(i == index) {
        return node.item;
      }
      node = node.next;
    }
    return null;
  }



  @Override
  public Object remove(int index) {
    if (index < 0 || index >= this.size) {  //인덱스가 무효하다면
      return null;                         
    }

    Node node = head;
    Node prev = null;
    Object deleted = null;

    for (int i = 0; i <this.size; i++) {

      if (i == index ) {        //삭제할 위치를 찾았다면
        deleted = node.item;      // 삭제할 위치에 이쓴 값을 보관한다

        if (node == head) {     //삭제할 노드가 첫번째면
          head = node.next;     //head가 두번째노드를 가리키게 하고
        } else {            // 삭제할 노드가 첫번쨰가 아니면
          prev.next = node.next;    // 이전 노드를 다음 노드와 연결한다
        }


        // 가비지 관리를 위해
        node.next = null;   // 삭제할 노드가 더이상 다음 노드를 가리키지 않으면 삭제한다. 
        node.item = null;   


        if (node == tail) { // 삭제할 노트가 마지막이라면   
          tail = prev; // tail이 이전 노드를 가리키게 한다
        }
        size--;
        return deleted;

      } else {
        prev = node; 
        node = node.next;    
      }

    }


  }

}







