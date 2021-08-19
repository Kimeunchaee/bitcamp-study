package com.eomcs.pms0819.handler;


public interface List {
  void add(Object item);
  Object[] toArray();
  boolean remove(Object obj);

  // 추가1
  //모든 리스트는 갯수를 저장하는 변수가 있어야한다
  //메서드 규칙추가
  int size();

  // 추가2
  Object get(int index);
  Object remove(int index);
}









