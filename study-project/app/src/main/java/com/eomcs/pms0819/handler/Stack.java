package com.eomcs.pms0819.handler;

public class Stack extends ArrayList {
  // stack의 자료구조를 직접 구현해보기

  // list클래스를 상속받아 정의하고
  // push(), pop() 메서드 추가

  //push메서드 : 값을 넣음
  public void push(Object item) {
    this.add(item);     // 맨끝에 추가하기 때문에 기존의 add() 메서드로 처리한다.
  }

  // pop메서드 : 값이 사라지게함
  public Object pop() {
    return this.remove(this.size() - 1);
  }

}
