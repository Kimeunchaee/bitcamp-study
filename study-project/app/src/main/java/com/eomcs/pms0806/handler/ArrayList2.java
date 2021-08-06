package com.eomcs.pms0806.handler;

// 인터페이스 적용

// List가 인터페이스이기 때문에 상속이 아닌 구현으로 변경한다.
// 기존 public class ArrayList3 extends List{
public class ArrayList2 implements List3{

  static final int MAX_LENGTH = 5;
  Object[] list = new Object[MAX_LENGTH];
  int size = 0;

  @Override
  public void add(Object obj) {
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < size; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    this.list[this.size++] = obj;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; 
    for (int i = 0; i < this.size; i++) { 
      arr[i] = list[i];
    }
    return arr;
  }

  @Override
  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.size] = null;

    return true;
  }

  private int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i] == obj) {
        return i;
      }
    }
    return -1;
  }

}
