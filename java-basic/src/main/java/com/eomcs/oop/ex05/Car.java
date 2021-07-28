package com.eomcs.oop.ex05;

public class Car {

  //인스턴스 변수 3개
  public String model;
  public String maker;
  public int capacity;

  // 인스턴스메서드
  public Car() {}

  // 생성자 호출
  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  //인스턴스 메서드
  public void run() {
    System.out.println("달린다!");
  }
}


