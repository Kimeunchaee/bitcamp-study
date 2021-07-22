package com.eomcs.oop.ex00.p3;

public class Calculator {

  // 1. result에 static을 빼주기
  int result;

  // 2. Test3으로 이동
  // c1 = new 인스턴스 만들기

  // 3. 파라미터 Calculator that 작성
  // 4. 다시 Test3 로 와서 c1 넣어주는 형식으로 수정하기
  static void plus(Calculator that, int value) {
    that.result += value;
  }

  static void minus(Calculator that, int value) {
    that.result -= value;
  }

  static void multiple(Calculator that, int value) {
    that.result *= value;
  }
}
