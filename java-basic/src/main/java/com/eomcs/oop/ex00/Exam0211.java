package com.eomcs.oop.ex00;

//1. 클래스 문법으로 분류

public class Exam0211 {



  // 1.Calculate 클래스를 생성한다
  static class Calculate {

    int result = 0;  // 2.main()에 있던 result 변수 선언을 가지고온다 (main에서 지우기)

    int plus(int a, int b) {  // 3. 내용을 가지고온다 
      return a + b;
    }

    int minus(int a, int b) {
      return a - b;
    }

    int multiple(int a, int b) {
      return a * b;
    }

    int divide(int a, int b) {
      return a / b;
    }
  }




  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    // int result = 0;
    // 계산결과값을 저장하는 result는  Calculate 메소드가 한번에 관리하도록 한다

    result = plus(2, 3);
    result = minus(result, 1);
    result = multiple(result, 7);
    result = divide(result, 3);

    System.out.printf("result = %d\n", result);
  }





}

