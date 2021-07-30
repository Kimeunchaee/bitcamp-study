// 오버라이딩(overriding) - 리턴 타입
package com.eomcs.oop.ex06.c;

public class Exam0610 {

  static class Car {}
  static class Sedan extends Car {}
  static class Tico extends Sedan {}

  static class CarFactory {
    Car create() {
      return new Car();
    }
  }

  static class SedanFactory extends CarFactory {
    // 오버라이딩 메서드의 리턴 타입은 
    // 서브 클래스도 가능하다.
    @Override
    Sedan create() {               
      return new Sedan();           
      // Sedan은 Car를 상속받고있는 서브클래스이기때문에
      //Car메서드(create)의 리턴타입으로 서브클래스인 Sedan이 사용가능하다  
    }
  }

  static class TicoFactory extends SedanFactory {
    // 오버라이딩 메서드의 리턴 타입은 
    // 서브 클래스도 가능하다.
    @Override
    Tico create() {
      return new Tico();
    }
  }


  public static void main(String[] args) {
    new CarFactory().makeCar().run();
    new SedanFactory().makeCar().run();
    new TruckFactory().makeCar().run();
    new DumpTruckFactory().makeCar().run();
    new DumpTruckFactory2().makeCar().run();
  }
}








