// 캡슐화(encapsulation) - 접근 범위 테스트
package com.eomcs.oop.ex08.b;


// A와 Exam0210은 같은 패키지
class A {
  private int privateVar;
  int defaultVar;
  protected int protectedVar;
  public int publicVar;
}

public class Exam0210 extends com.eomcs.oop.ex08.b.sub.C {

  public static void main(String[] args) {
    A obj1 = new A();

    //obj1.privateVar = 100; // 접근 불가! 오직 그 클래스 안에서만 사용가능. //A에서만 사용할수 있다 , Exam0210에서는 X
    obj1.defaultVar = 100; // OK! 이 클래스는 A 클래스와 같은 패키지에 소속되어 있다.
    // *defaul는 A클래스와 exam0210클래스는 클래스는 다르지만 같은 패키지임으로 접근할수있다
    obj1.protectedVar = 100; // OK! 비록 이 클래스가 자식클래스는 아니지만
    // 같은 패키지에 소속되어 있다.
    //  *A클래스와 exam0210클래스는 클래스는 다르지만 같은 패키지이기때문에 접근할수있다
    obj1.publicVar = 100; // OK! 모두 다 접근 가능!
    // *무조건 접근가능



    // exam0210안에 main에서 B클래스
    com.eomcs.oop.ex08.b.sub.B obj2 = new com.eomcs.oop.ex08.b.sub.B();

    //obj2.privateVar = 100; // 접근 불가! 오직 그 클래스 안에서만 사용 가능.
    // *같은 클래스만 가능함
    //obj2.defaultVar = 100; // 접근 불가! 같은 패키지까지만 접근 가능.
    // *같은 클래스도 아니고 같은 패키지도 아님 (exam0210에서 접근중)
    //obj2.protectedVar = 100; // 접근 불가! 같은 패키지 또는 자식 클래스 접근 가능
    // *같은 클래스도 아니고 같은 패키지도 아니고 자식클래스도 아님
    obj2.publicVar = 100; // OK! 모두 다 접근 가능.


    com.eomcs.oop.ex08.b.sub.C obj3 = new com.eomcs.oop.ex08.b.sub.C();

    //obj3.privateVar = 100; // 접근 불가! 오직 그 클래스 안에서만 사용 가능.
    // *같은 클래스만 가능함

    //obj3.defaultVar = 100; // 접근 불가! 같은 패키지까지만 접근 가능.
    // *같은 클래스도 아니고 같은 패키지도 아님 ((exam0210에서 접근중, C와 다른패키지 소속임)

    //obj3.protectedVar = 100; // 접근 불가! 같은 패키지 또는 자식 클래스 접근 가능
    // 자식 클래스인데 접근 불가? (Exam0210 extends com.eomcs.oop.ex08.b.sub.C ) - Exam0210은 C와 같은 클래스임x , 같은 패키지임 x, 서브클래스임o
    // 이유 => 자기의 인스턴스 변수가 아니다. // *obj3는 C를 받는 레퍼런스다. Exam0210을 받지 않았는데 .protectedVar은 exam0210의 것이기때문에 자기변수가 아님
    // *new로 생성했을때 자기변수가 된다

    obj3.publicVar = 100; // OK! 모두 다 접근 가능.
    // *무조건 가능


    Exam0210 obj4 = new Exam0210(); // exam0210 을 상속받은 C에서 new Exam0210();을 만들었다
    //obj4.privateVar = 100; // 접근 불가! C 클래스에서만 접근 가능
    //obj4.defaultVar = 100; // 접근 불가! C 클래스와 같은 패키지가 아니다.
    obj4.protectedVar = 100; // OK! Exam0210은 C의 자식 클래스이며,
    // 또한 C로부터 상속 받아서 만든 자기 변수이다. (C를상속받아서 만든 Exam0210 소속 변수이다)
    obj4.publicVar = 100;
  }


  com.eomcs.oop.ex08.b.sub.C obj5 = new Exam0210();{
    // obj5.privateVar = 100;
    //obj5.defaultVar = 100; 
    //obj5.protectedVar = 100;
    obj5.publicVar = 100;
  }



  // new C 와 new Exam0210 비교하기








  void m1(com.eomcs.oop.ex08.b.sub.C obj) {
    //obj.privateVar = 100;
    //obj.defaultVar = 100;
    //obj.protectedVar = 100;
    obj.publicVar = 100;
  }

  void m2(Exam0210 obj) {
    //obj.privateVar = 100;
    //obj.defaultVar = 100;
    obj.protectedVar = 100;
    obj.publicVar = 100;
  }

  void m3() {
    //this.privateVar = 100;  //.privateVar는 C꺼여서 안된다??!!!!!!
    //this.defaultVar = 100;
    this.protectedVar = 100;
    this.publicVar = 100;
  }


}

// private      : 클래스 안에서만 접근 가능
// (default)    : private + 같은 패키지 소속
// protected    : (default) + 서브 클래스로 만든 변수인 경우 서브 클래스에서 접근 가능
// public       : 모두 접근 가능
//
// 실무
// => 인스턴스 변수는 보통 private으로 접근을 제한한다.
// => 겟터,셋터는 public으로 접근을 모두에게 공개한다.
// => 일반 메서드도 public으로 접근을 모두에게 공개한다.
// => 그 클래스 내부에서만 사용되는 메서드는 private으로 접근을 제한한다.
// => 자식 클래스의 접근을 허용할 필요가 있을 경우에만 protected로 만든다.
// => 다른 개발자가 사용할 클래스 모음을 만들 때
//    그 모음집 내에서만 사용될 변수나 메서드인 경우 (default)로 접근을 제한한다.
//    즉 라이브러리를 만드는 개발자인 경우 (default)를 사용하는 경우가 있다.






