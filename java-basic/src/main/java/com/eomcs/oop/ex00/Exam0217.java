package com.eomcs.oop.ex00;

// 7. 클래스 분리
// : static class Calculate {} 를 별도의 클래스파일로 분리한다 (유지보수를 쉽게 하기 위해)

public class Exam0217 {

  // public class Calculate {}

  int result = 0;

  // 16. 별도의 Calculate 클래스 파일로 분리 후 메소드에 public를 붙혀준다
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
}


