package com.eomcs.oop.ex00.util;

public class Calculate {
  int result = 0;


  public void plus(int value) { 

    this.result += value;
  }

  public void minus(int value) { 
    this.result -= value;
  }

  public void multiple(int value) {  
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }


  //절댓값 추가
  public static int abs(int value) {  // 이 메소드가 인스턴스 변수나 인스턴스 메소드를 사용하지 않으면 (클래스변수이면) static을 붙혀준다
    return value > 0 ? value : -value;
  }
}
