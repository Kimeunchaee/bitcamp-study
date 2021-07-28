package com.eomcs.oop.ex05.a;

public class Car {

  public String model;
  public String maker;
  public int capacity;


  //Calculator와 Score는 원시타입을 사용해서 생성자가 자동으로 생성되어 호출이 필요없지만
  // Car은 사용자 정의 타입이므로 생성자를 호출해줌



  // 기본생성자 (아무 값이 없음) , 생성자를 만들지 않았을때 자동으로 생성자가 호출됨
  // 생성자를 아래처럼 한개라도 만든경우 직접 기본생성자를 작성해주어야함

  // 매개변수가 있는 생성자가 있을때는 자동으로 기본생성자를 만들어주지 않는다
  //  따라서 기본생성자를 작성하지 않으면 존재하지 않은 생성자를 호출하고 있는상태이기때문에
  //  기본생성자 호출을 먼저 해준다 
  public Car(String string, String string2, int i, boolean b, boolean c) {}


  // 사용자가 지정한 생성자 (파라미터로 받은 값으로 인스턴스를 초기화시켜줌)
  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


