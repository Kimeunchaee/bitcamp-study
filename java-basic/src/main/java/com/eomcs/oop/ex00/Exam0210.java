package com.eomcs.oop.ex00;


// static 메서드에서 시작

public class Exam0210 {

  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    // 계산 결과를 담을 변수
    int result = 0;

    // 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수(result)에 저장
    result = plus(2, 3);
    result = minus(result, 1);
    result = multiple(result, 7);
    result = divide(result, 3);

    System.out.printf("result = %d\n", result);
  }

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }
}

