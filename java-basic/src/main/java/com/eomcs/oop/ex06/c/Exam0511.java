// 오버라이딩(overriding) - 레퍼런스가 가리키는 메서드
package com.eomcs.oop.ex06.c;

public class Exam0511 {

  //인스턴스필드와 다르게 메서드필드는
  // 실제 레퍼런스가 가리키는 클래스의 메서드부터 찾아서 올라감
  static class X {
    void m1() {
      System.out.println("X의 m1()");
    }
    void m2() {
      System.out.println("X의 m2()");
    }
  }


  static class X2 extends X {
    @Override
    void m1() {
      System.out.println("X2의 m1()");
    }
  }


  static class X3 extends X2 {
    @Override
    void m2() {
      System.out.println("X3의 m2()");
    }
  }


  static class X4 extends X3 {
    @Override
    void m1() {
      System.out.println("X4의 m1()");
    }
  }

  public static void main(String[] args) {
    X4 x4 = new X4();
    x4.m1();

    // 인스턴스 필드와 달리 메서드의 경우는
    // 레퍼런스에 대한 형변환에 상관없이
    // 실제 레퍼런스가 가리키는 클래스에서 메서드를 찾아 올라간다.
    //
    ((X3)x4).m1(); //X4의 메서드를 가리킴
    ((X2)x4).m1();  //X4의 메서드를 가리킴
    ((X)x4).m1();   //X4의 메서드를 가리킴
  }
}








