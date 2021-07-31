// 다형적 변수와 오버라이딩 - 레퍼런스와 메서드 호출
package com.eomcs.oop.ex06.d;


abstract class Car {            //추상클래스 (인스턴스 만들수없음)
  public abstract void run();  // {}메서드바디가 없이 선언만 되어있음
  public void m() {}        //선언,정의 둘다 되어있음
}

class Sedan extends Car {
  @Override
  public void run() {
    System.out.println("Sedan.run() 호출됨!");
  }
}

public class Exam0210 {
  public static void main(String[] args) {
    // 1) 다형적 변수의 사용법에 따라,
    //    - super 클래스 레퍼런스로 하위 클래스의 인스턴스를 가리킨다.
    Car car = new Sedan();

    // 2) 오버라이딩 메서드 호출 규칙에 따라,
    //    - 레퍼런스가 실제 가리키는 객체의 클래스부터 메서드를 찾아 올라간다.
    car.run();
    //car레퍼런스에서 run메서드를 호출함 > car레퍼런스가 new sedan을 가리키고 있기때문에 세단에서부터 찾아서 실행됨
  }
}








