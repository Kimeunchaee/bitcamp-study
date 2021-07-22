package com.eomcs.oop.ex00.p4;

public class Calculator {

  int result;


  // Calculator that 을 빼주고
  // this 넣어주기
  // Test4 로 이동
  void plus(int value) {
    this.result += value;
  }

  void minus(int value) {
    this.result -= value;
  }

  void multiple(int value) {
    this.result *= value;
  }
}
