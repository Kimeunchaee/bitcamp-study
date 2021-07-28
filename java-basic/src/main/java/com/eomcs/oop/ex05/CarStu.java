package com.eomcs.oop.ex05;

public class CarStu {
  public String model;
  public String maker;
  public int capacity;

  public CarStu() {}

  public CarStu(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}

//------------------------------------------------------
class Sedan extends CarStu {
  public boolean sunroof;
  public boolean auto;

  public Sedan(String model, String maker, int capacity,
      boolean sunroof, boolean auto) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
    this.sunroof = sunroof;
    this.auto = auto;
  }
}



//------------------------------------------------------

class Exam01 {
  void main(String[] args) {

    Sedan c1 = new Sedan("비트자동차", "소나타", 5, true, true);
  }
}



