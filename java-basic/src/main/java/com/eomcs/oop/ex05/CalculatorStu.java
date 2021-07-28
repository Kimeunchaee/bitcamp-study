package com.eomcs.oop.ex05;

public class CalculatorStu {

  public int result;

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }


}

//------------------------------------------------------

class CalculatorStu2 extends CalculatorStu {
  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

}

//------------------------------------------------------
class Exam02 {
  public static void main(String[] args) {
    CalculatorStu2 c1 = new CalculatorStu2();
    c1.plus(5);
    c1.multiple(2);
    c1.minus(2);
    c1.divide(4);
    System.out.println(c1.result);
  }
}