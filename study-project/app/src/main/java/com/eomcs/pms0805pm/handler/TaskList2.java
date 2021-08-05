package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Task;

public class TaskList2 {

  static class Node {
    Task task;
    Node next;
    public Node(Task task) {
      this.task = task;
    }
  }

  int size = 0;
  Node head;
  Node tail;


  public void add(Task task) {

    // 배열크기 자동으로 늘리는 코드 추가 (Node사용)
    Node node = new Node(task);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }

  public Task[] toArray() {
    Task[] arr = new Task[this.size];
    Node node = head;
    for(int i = 0; i <this.size; i++) {
      arr[i] = node.task;
      node = node.next;
    }
    return arr;
  }

  public Task findByNo(int no) {
    Node node = head;
    while (node != null) {
      if(node.task.no == no) { 
        return node.task;
      }
      node = node.next; 
    } 
    return null;
  }

  public boolean remove(Task task) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if(node.task == task) {
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

  //  private int indexOf(Task task) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.tasks[i] == task) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }
}








