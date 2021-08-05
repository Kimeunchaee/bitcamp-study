package com.eomcs.pms0805pm.handler;

// BoardList4 에서 공통된 메서드들 추출해오기
public class LinkedList4 {


  //--------------------------------
  static class Node {
    // 기존 Board board;
    // 여러개의 객체를 담을수 있는 클래스(Object)의 변수로 변경
    Object item;
    Node next;

    public Node(Object obj) {
      this.item = obj;
    }
  }

  //--------------------------------
  int size;
  Node head;
  Node tail;


  //--------------------------------
  // 메서드의 타입과 변수명을 Object obj에 맞게 바꿔줌
  public void add(Object obj) {

    Node node = new Node(obj);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }



  //--------------------------------
  // 메서드의 타입과 변수명을 Object obj에 맞게 바꿔줌
  public Object[] toArray() {

    Object[] arr = new Object[this.size];

    Node node = head;
    for(int i = 0; i <this.size; i++) {
      arr[i] = node.item;
      node = node.next;
    }
    return arr;
  }



  //--------------------------------
  // 메서드의 타입과 변수명을 Object obj에 맞게 바꿔줌
  public boolean remove(Object obj) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if(node.item == obj) { 
        if(node == head) {     
          head = node.next;    
        } else {           
          prev.next = node.next;  
        }
        node.next = null; 
        if(node == tail){ 
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
