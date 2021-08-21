package com.eomcs.pms0820.util;

import java.lang.reflect.Array;

//----기존
//public class LinkedList extends AbstractList {

public class LinkedList<E> extends AbstractList<E> {

  // ----기존
  //  static class Node {
  //    Object item;
  //    Node next;
  //
  //    public Node(Object item) {
  //      this.item = item;
  //    }
  //  }
  //
  //  Node head;
  //  Node tail;


  // ---- 제네릭 변경
  static class Node<E> {
    E item;
    Node<E> next;

    public Node(E item) {
      this.item = item;
    }
  }

  Node<E> head;
  Node<E> tail;




  @Override
  //public void add(Object item) {
  public void add(E item) {

    //Node node = new Node(item);
    //Node<E> node = new Node<E>(item);  // new Node<E> 에서 E는 생략가능
    Node<E> node = new Node<>(item);

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

    //Node node = head;
    Node<E> node = head;

    for (int i = 0; i < this.size; i++) {
      arr[i] = node.item;
      node = node.next;
    }

    return arr;
  }




  @Override
  //public boolean remove(Object item) {
  public boolean remove(E item) {
    //    Node node = head;
    //    Node prev = null;
    Node<E> node = head;
    Node<E> prev = null;

    while (node != null) {
      if (node.item == item) { // 노드에 들어 있는 객체와 같다면
        if (node == head) { // 삭제할 노드가 하필이면 첫 번째 노드라면, 
          head = node.next; // head가 두 번째 노드를 가리키게 한다.
        } else { // 삭제할 노드가 첫 번째 노드가 아니라면
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        node.next = null; // 삭제할 노드가 더이상 다음 노드를 가리키지 않게 한다.

        if (node == tail) { // 삭제할 노드가 마지막 노드라면
          tail = prev; // tail이 이전 노드를 가리키게 한다.
        }
        size--;
        return true;
      }

      // 현재 노드가 아니라면,
      prev = node; // 현재 노드를 prev 에 저장하고,
      node = node.next; // node 는 다음 노드를 가리킨다.
    }

    return false;
  }




  @Override
  //public Object get(int index) {
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    //Node node = this.head;
    Node<E> node = this.head;

    for (int i = 0; i < this.size; i++) {
      if (i == index) {
        return node.item;
      }
      node = node.next;
    }
    return null;
  }

  @Override
  //public Object remove(int index) {
  public E remove(int index) {
    if (index < 0 || index >= this.size) { // 무효한 인덱스라면
      return null;
    }

    //    Node node = head;
    //    Node prev = null; 
    Node<E> node = head;
    Node<E> prev = null;

    for (int i = 0; i < this.size; i++) {

      if (i == index) { // 삭제할 위치를 찾았다면


        //Object deleted = node.item; // 삭제할 위치에 있는 값을 보관한다.
        E deleted = node.item;


        if (node == head) { // 삭제할 노드가 하필이면 첫 번째 노드라면, 
          head = node.next; // head가 두 번째 노드를 가리키게 한다.
        } else { // 삭제할 노드가 첫 번째 노드가 아니라면
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        // 가비지 관리를 위해 삭제할 노드의 인스턴스 필드를 null 로 초기화 한다.
        node.item = null;
        node.next = null; 

        if (node == tail) { // 삭제할 노드가 마지막 노드라면
          tail = prev; // tail이 이전 노드를 가리키게 한다.
        }
        size--;
        return deleted;

      } else { // 삭제할 노드가 아니라면
        prev = node; // 현재 노드를 prev 에 저장하고,
        node = node.next; // node 는 다음 노드를 가리킨다.
      }
    }

    return null;
  }


  //추가
  @Override
  public E[] toArray(E[] arr) {

    // 방법1
    //원본이 배열이 아니라 노드다 > 우선 노드를 배열에 담아준다 
    E[] temp = null;

    // 파라미터로 받은 배열의 크기(arr.length)가 현재들어있는 항목의 갯수(this.size)를 담을만큼 충분히 크다면
    if(arr.length >= this.size) {
      temp = arr;
    } else {
      // getClass() : arr배열의 타입 , getComponentType() : arr배열의 객체 타입
      temp = (E[])Array.newInstance(arr.getClass().getComponentType(), this.size);
    }       

    // 배열에 담긴 노드를 다뤄준다
    Node<E> node = head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = node.item;
      node = node.next;
    }
    return arr;

  }
}







