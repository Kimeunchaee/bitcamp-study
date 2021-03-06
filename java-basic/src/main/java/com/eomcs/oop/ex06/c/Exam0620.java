// 오버라이딩(overriding) - 리턴 타입
package com.eomcs.oop.ex06.c;

class Car {
  String maker;
  String model;
  int cc;
  void run() {System.out.println("자동차가 달린다!");}
}

class Sedan extends Car {
  boolean sunroof;
  public void openSunroof() {sunroof = true;}
  public void closeSunroof() {sunroof = false;}
  @Override
  void run() {System.out.println("승용차가 달린다!");}
}

class Truck extends Car {
  int weight;
  public void dump() {weight = 0;}
  @Override
  void run() {System.out.println("트럭이 달린다!");}
}

class DumpTruck extends Truck {
  @Override
  public void dump() {weight = 0;}
  @Override
  void run() {System.out.println("덤프트럭이 달린다!");}
}

class CarFactory {
  Car makeCar() {
    return new Car();
  }
}

class SedanFactory extends CarFactory {
  // 메서드를 오버라이딩 할 때 리턴 타입으로 서브 클래스도 가능하다.
  @Override
  Sedan makeCar() {
    return new Sedan();
  };
}

class TruckFactory extends CarFactory {
  // 메서드를 오버라이딩 할 때 리턴 타입으로 서브 클래스도 가능하다.
  @Override
  Truck makeCar() {
    return new Truck();
  };
}

class DumpTruckFactory extends TruckFactory {
  // 메서드를 오버라이딩 할 때 리턴 타입으로 서브 클래스도 가능하다.
  @Override
  Sedan makeCar() {
    return new Sedan();
  };
}

class DumpTruckFactory2 extends TruckFactory {
  // 메서드를 오버라이딩 할 때 리턴 타입으로 수퍼 클래스는 불가능하다.
  // => 컴파일 오류!
  //
  //  @Override
  //  Car makeCar() {     
  //    return new Car();
  //  };

  // 상속받은 TurckFactory에서 리턴타입은 Truck이고 
  // TurckFactory가 상속받은 CarFactory에서 리턴타입은 Car이다 
  // 이때 수퍼클래스인 Car을 리턴타입으로 사용할 수 없다
  // CarFactory의 서브클래스인 TurckFactory의 Truck은 리턴타입으로 사용가능하다

}


public class Exam0620 {
  public static void main(String[] args) {
    new CarFactory().makeCar().run();
    new SedanFactory().makeCar().run();
    new TruckFactory().makeCar().run();
    new DumpTruckFactory().makeCar().run();
    new DumpTruckFactory2().makeCar().run();
  }
}








