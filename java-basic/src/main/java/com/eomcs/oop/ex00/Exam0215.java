package com.eomcs.oop.ex00;

// 5. that 사용
public class Exam0215 {

  static class Calculate {


    static int result = 0;  

    // 13. obj 변수명 대신 taht을 사용해준다
    static void plus(Calculate taht, int value) {   
      result += value;
    }

    static void minus(Calculate taht, int value) {
      result -= value;
    }

    static void multiple(Calculate taht, int value) {
      result *= value;
    }

    static void divide(Calculate taht, int value) {
      result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    Calculate c1 = new Calculate();
    Calculate c2 = new Calculate();

    Calculate.plus(c1, 2);
    Calculate.plus(c2, 3);
    Calculate.minus(c1, 1);
    Calculate.multiple(c1, 7);
    Calculate.divide(c1,3);

    System.out.printf("result = %d\n", Calculate.result);
  }
}

