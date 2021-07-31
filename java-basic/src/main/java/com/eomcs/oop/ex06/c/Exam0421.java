// 오버라이딩(overriding) - this/super의 사용
package com.eomcs.oop.ex06.c;

// this.메서드() 호출?
// => 현재 클래스부터 호출할 메서드를 찾아 올라 간다.
//
// super.메서드() 호출?
// => 부모 클래스부터 호출할 메서드를 찾아 올라 간다.
//

public class Exam0421 {
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

    void test() {
      this.m1();  //test가 호출된 클래스부터 실행됨
      super.m1();  //test가 소속된 클래스부터 실행됨

      this.m2(); 
      super.m2();
    }

  }

  static class X5 extends X4 {
    @Override
    void m1() {
      System.out.println("X5의 m1()");
    }
    @Override
    void m2() {
      System.out.println("X5의 m2()");
    }

    //오버라이딩한 test()가 없기때문에 X4에서 실행

  }


  public static void main(String[] args) {
    X5 obj = new X5();
    obj.test();   //test() 메서드가 실행됨

  }
}


//// 실행결과
//X5의 m1()
//X2의 m1()    // test()메서드가 소속된 클래스의 관점에서 super클래스를 가리킨다
//X5의 m2()
//X3의 m2()










