// static nested class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.b;

class A {
  static class X {

  }
}

public class Exam0110 {

  public static void main(String[] args) {
    // 레퍼런스 선언하는 방법
    A.X obj;
    // A는 바깥클래스
    // X는 중첩클래래스


    // 인스턴스 생성하는 방법
    obj = new A.X();  //A는 바깥클래스, X는 중첩클래스 (스태틱클래스명.스태틱메서드 와 문법이 같음)
  }

}
