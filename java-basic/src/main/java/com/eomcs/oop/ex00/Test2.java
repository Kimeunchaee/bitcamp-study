package com.eomcs.oop.ex00;


public class Test2 {
  static int a ;
  int b;


  //스태ㅣ틱 메서드

  static void x1() {
    System.out.println("x1() 호출됨");
    a=100;
    x2();
  }


  static void x2() {
    System.out.println("x2() 호출됨");
  }

  void y1 () {
    System.out.println("y1() 호출됨");
  }
}
