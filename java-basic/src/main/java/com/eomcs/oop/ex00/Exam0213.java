package com.eomcs.oop.ex00;

// 3. instant 변수 선언
public class Exam0213 {

  static class Calculate {

    static int result = 0;  

    static void plus(int value) {   // 8. plus, minus ..메소드 모두 main에서 사용하기 위해 static을 붙혀준다
      result += value;
    }

    static void minus(int value) {
      result -= value;
    }

    static void multiple(int value) {
      result *= value;
    }

    static void divide(int value) {
      result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?


    // 9. 변수선언 타입에 맞게 수정 후 순서대로 작성해준다
    // Calculate.plus(2), Calculate.plus(3), Calculate.minus(1) ...

    Calculate.plus(2);
    Calculate.plus(3);
    Calculate.minus(1);
    Calculate.multiple(7);
    Calculate.divide(3);

    System.out.printf("result = %d\n", Calculate.result);
  }





}

