package com.eomcs.pms0820.util;


// ----기존
//public interface List  {
//  void add(Object item);
//  Object[] toArray();
//  boolean remove(Object obj);
//  int size();
//  Object get(int index);
//  Object remove(int index);
//}


// ----제네릭적용
// 인터페이스에 제네릭(generic)의 타입 파라미터를 적용하면
// 그 타입의 최종적인 이름은 이 인터페이스를 구현하는 클래스에서 결정해서 전달받는다.
public interface List<E>  {

  void add(E item);
  Object[] toArray();
  // 파라미터 없이 메서드 호출 (기본메서드)
  boolean remove(E obj);

  int size();
  E get(int index);
  E remove(int index);


  // toArray는 배열[]에서도 사용할수 있는 메서드이고, <>특정타입을 받아서 사용할 수 도 있는 메서드이다.
  // 추가

  E[] toArray(E[] arr); //맨앞에 <T>를 붙히면 : 메서드를 호출해서 사용할때 메서드타입이 정해져있다
  // 바깥에서 해당타입의 파라미터(E[] arr)를 받아서 메서드를 호출
}








