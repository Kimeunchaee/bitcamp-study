package com.eomcs.pms0819.handler;

public abstract class AbstractList implements List {
  // public abstract : 모디피어 (제한자,변경자)
  // abstract를 붙혀서 추상클래스로 만들어주면
  // 이 클래스는 인스턴스를 만들수 없다
  // 이 추상클래스를 arraylist와 linkedlist가 상속받아
  // 서브클래스에서 인스턴스를 만들어 사용해야한다

  //이 패키지 안에서만 사용
  protected int size;

  @Override
  public int size() {
    return this.size;
  }
}