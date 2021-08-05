package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Project;

public class ProjectList2 {

  static class Node {
    Project project;
    Node next;
    public Node(Project project) {
      this.project = project;
    }
  }

  int size = 0;
  Node head;
  Node tail;



  public void add(Project project) {

    // 배열크기 자동으로 늘리는 코드 추가 (Node사용)
    Node node = new Node(project);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }


  public Project[] toArray() {
    Project[] arr = new Project[this.size];
    Node node = head;
    for(int i = 0; i <this.size; i++) {
      arr[i] = node.project;
      node = node.next;
    }
    return arr;
  }

  public Project findByNo(int no) {
    Node node = head;
    while (node != null) {
      if(node.project.no == no) { 
        return node.project;
      }
      node = node.next; 
    } 
    return null;
  }

  public boolean remove(Project project) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if(node.project == project) {
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

  //  private int indexOf(Project project) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.projects[i] == project) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }


}








