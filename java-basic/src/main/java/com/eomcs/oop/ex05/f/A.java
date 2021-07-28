package com.eomcs.oop.ex05.f;

public class A {
  int v1;

  static { 
    System.out.println("A클래스의 static{} 실행!");
  }
}

// 수퍼클래스를 적지 않으면 컴파일러가 자동으로 Object클래스를 추가함
// extends java.lang.Object (=루트클래스, 자바의 최상위클래스)
//      public Object(){ } 
// 최상위 클래스는 생략되어 있음

// oop.ex05.g 참고하기~
