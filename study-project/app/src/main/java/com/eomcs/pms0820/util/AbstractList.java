package com.eomcs.pms0820.util;


// ----기존
//public abstract class AbstractList implements List {
//  protected int size;
//
//  @Override
//  public int size() {
//    return this.size;
//  }
//}


// ----인터페이스를 구현한 클래스에서 List<>를 정의한다.
// 추상클래스에서 List에 적용할 타입이름을 E 변수에 받는다.
// 그 변수의 값을 List 인터페이스에 적용한다.
// 이때 추상 클래스에 최종적인 타입 이름은
// 서브 클래스에서 결정해서 전달받는다
public abstract class AbstractList<E> implements List<E> {

  //  AbstractList<E> : 추상클래스에서 적용된 타입의 값이
  // List<E> : 그대로 List에ㅓ 같은 타입의 값으로 적용됨

  protected int size;

  @Override
  public int size() {
    return this.size;
  }
}