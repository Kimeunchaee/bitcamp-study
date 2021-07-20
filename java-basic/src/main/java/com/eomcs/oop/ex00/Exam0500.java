package com.eomcs.oop.ex00;

public class Exam0500 {

  static class Calculate {
    static int result = 0;  //클래스로 옮겼으니 static을 붙혀서 클래스변수로 변경해준다


    static void plus (int value) { //int a, int b
      //return a + b;
      result += value;
    }

    static void minus(int value) {
      //return a - b;
      result -= value;
    }

    static void multiple(int value) {
      //return a * b;
      result *= value;
    }

    static void divide(int value) {
      //return a / b;
      result /= value;
    }
  }





  public static void main(String[] args) {

    Calculate.plus(2);
    Calculate.plus(3);  // result = 결과를 main에서 정의할 필요없으므로 지워줌 (클래스에서 result 관리중)
    Calculate.minus(2);
    Calculate.multiple(7);
    Calculate.divide(3);

    System.out.printf("result = %d\n", Calculate.result);

  }
}

