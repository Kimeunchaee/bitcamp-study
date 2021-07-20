package com.eomcs.oop.ex00;

// result 재정의

public class Exam213 {

  static class Calculate {

    int result = 0;

    void plus(Calculate obj, int value) {      // 1. 결과값을 저장하는 변수와 입력값인 value를 함께 선언해준다
      result += value;               
    }

    void minus(Calculate obj,int value) {      // 2. int 를 void로 변경
      result -= value;
    }

    void multiple(Calculate obj,int value) {
      result *= value;
    }

    void divide(Calculate obj,int value) {
      result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?


    Calculate c1 = new Calculate(); // Calculator 클래스에 static이 붙지 않은 변수를 가지고 옴


    Calculate.plus(2, 3);              //3.
    Calculate.minus(result, 1);
    Calculate.multiple(result, 7);
    Calculate.divide(result, 3);

    System.out.printf("result = %d\n", Calculate.result);
  }



}

