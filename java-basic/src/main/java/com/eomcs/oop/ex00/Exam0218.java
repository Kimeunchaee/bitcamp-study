package com.eomcs.oop.ex00;

// 8. 클래스를 분리하면 언제든지 원하는 기능을 추가하거나 유지보수가 쉽다
// ex)절댓값 계산 추가...

// 9. 패키지 분리
// 클래스 분리 후 패키지까지 분리해서 선언해주면
// 언제든지 이 클래스를 필요로 하는 곳에 가져다 사용할 수 있다
// 이때 패키지명은 알아볼수있는 이름으로 지정한다 
// ex) util ...

public class Exam0218 {


  // package com.eomcs.oop.ex00.util;
  // public class Calculate {}

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
  public static int abs(int value) {
    // 이 메소드가 인스턴스 변수나 인스턴스 메소드를 사용하지 않으면 (클래스변수이면) static을 붙혀준다
    return value > 0 ? value : -value;
  }
}


