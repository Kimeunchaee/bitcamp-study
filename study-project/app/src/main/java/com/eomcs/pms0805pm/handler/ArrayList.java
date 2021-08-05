package com.eomcs.pms0805pm.handler;

public class ArrayList {

  static final int MAX_LENGTH = 5;
  // 한 객체에 여러 인스턴스를 저장하고싶을때
  // a = new Tico(); , a = new Truck(); a = new Sedan(); ....여러개
  // 하위 클래스의 공통분모인 슈퍼클래스로 타입을 정의한다
  // Car a = new Tico(),new Truck(),new Sedan()
  // a의 변수타입은 Car!

  // Board, Member, Project, Task 를 한객체에 저장하고 싶을때
  // 이 클래스들은 수퍼클래스를 정의해주지 않았다
  // 이때 수퍼클래스는 기본으로 Object이므로
  // 객체의 타입을 Object로 선언해준다
  // 이때 변수명은 다양한 타입이 들어갈수있다는 의미로 values로 한다
  // (여기서는 공통클래스명이 list이므로 list로 한다)
  // !자바에서 Object는 모든 객체를 저장할수있다 (정해져있음) 

  //Board[] boards = new Board[MAX_LENGTH];
  Object[] list = new Object[MAX_LENGTH];
  int size = 0;



  // 보드리스트에서 복사해온 메서드의 변수명들
  // Object[] list에 맞게 수정해주기~~
  public void add(Object obj) {
    if(size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];
      for(int i = 0; i <size; i++) {
        arr[i] = list[i];
      }
      list = arr;
    }
    this.list[this.size++] = obj; 
  }


  public Object[] toArray() {           //toArray()메서드를 사용하면 Object[]의 arr배열을 리턴한다
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) { 
      arr[i] = list[i];
    }
    return arr;
  }

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
