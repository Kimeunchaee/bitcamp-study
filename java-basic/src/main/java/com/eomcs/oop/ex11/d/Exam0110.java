// local class : 클래스 정의와 인스턴스 생성
package com.eomcs.oop.ex11.d;

class A {
  void m1() {
    // 메서드 안에 정의하는 클래스를 "local class"라 한다.
    // - 특정 메서드 안에서만 사용되는 경우 로컬 클래스로 정의한다.
    // - 쓸데없이 외부로 노출하지 않기 위함.
    // - 노출을 줄이면 유지보수에 좋다.
    // - 로컬 클래스에서 로컬 이라는 말은 '이 메서드 안에서만 사용할 수 있다'는 뜻이다.
    // - 그냥 사용 범위에 대한 제한을 가리키는 말이다.
    // - 메서드를 호출할 때 클래스가 정의된다는  뜻이 아니다.
    class X {

    }
    //컴파일이 할때 메서드안에 선언된 클래스가 없어지고(바깥으로 나가짐)
    // 별도의 .class 파일로 생성된다 (딱 한번만 로딩됨)
    // 컴파일이 끝나면 메서드안에 클래스는 없다!
    // 다만 파일자체에 제약조건이 붙어서 사용범위가 메서드안에서로 제한된다
    X obj = new X();
  }

  static void m2() {
    // 메서드 안에 정의하는 클래스를 "local class"라 한다.
    class X {

    }
    X obj = new X();
  }
}

public class Exam0110 {

  public static void main(String[] args) {
    A outer = new A();
    outer.m1();
  }

}
