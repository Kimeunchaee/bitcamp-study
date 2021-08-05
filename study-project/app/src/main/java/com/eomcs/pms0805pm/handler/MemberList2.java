package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Member;

public class MemberList2 {

  static class Node {
    Member member;
    Node next;
    public Node(Member member) {
      this.member = member;
    }
  }


  int size = 0;
  Node head;
  Node tail;



  public void add(Member member) {

    // 배열크기 자동으로 늘리는 코드 추가 (Node사용)
    Node node = new Node(member);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }

  public Member[] toArray() {
    Member[] arr = new Member[this.size]; 
    Node node = head;
    for(int i = 0; i <this.size; i++) {
      arr[i] = node.member;
      node = node.next;
    }
    return arr;
  }

  public Member findByNo(int no) {
    Node node = head;
    while (node != null) {
      if(node.member.no == no) { 
        return node.member;
      }
      node = node.next; 
    } 
    return null;
  }

  public boolean remove(Member member) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if(node.member == member) {
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

  //  private int indexOf(Member member) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.members[i] == member) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }

  public boolean exist(String name) {
    Node node = head;

    while (node != null) {
      if(node.member.name.equals(name)) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

}








