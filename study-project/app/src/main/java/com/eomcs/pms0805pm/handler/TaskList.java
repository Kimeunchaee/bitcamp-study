package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Task;

public class TaskList {

  static final int MAX_LENGTH = 5;
  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  public void add(Task task) {

    // 배열크기 자동으로 늘리는 코드 추가 (배열사용)
    if(size == tasks.length) {
      Task[] arr = new Task [tasks.length + (tasks.length >> 1)];
      for(int i = 0; i <size; i++) {
        arr[i] = tasks[i];
      }
      tasks = arr;
    }
    this.tasks[this.size++] = task; //기존코드
  }

  public Task[] toArray() {
    Task[] arr = new Task[this.size]; 
    for (int i = 0; i < this.size; i++) { 
      arr[i] = tasks[i];
    }
    return arr; 
  }

  public Task findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (tasks[i].no == no) {
        return tasks[i];
      }
    }
    return null;
  }

  public boolean remove(Task task) {
    int index = indexOf(task);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.tasks[i - 1] = this.tasks[i];
    }
    this.tasks[--this.size] = null;

    return true;
  }

  private int indexOf(Task task) {
    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i] == task) {
        return i;
      }
    }
    return -1;
  }
}








