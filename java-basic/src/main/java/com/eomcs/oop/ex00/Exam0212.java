package com.eomcs.oop.ex00;

//2. static 변수(클래스 메서드)


public class Exam0212 {

  static class Calculate {

    static int result = 0;   //2. main()메서드에서 사용하기 위해 static을 붙혀줌 
    // 특정 인스턴스가 아닌 모든 인스턴스에 대해 작업을 수행함

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




  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    // 1. result를 호출하기 위해 경로 Calculate를 지정해준다 
    // plus의 경로가 Calculate 임을 지정해준다
    Calculate.result = Calculate.plus(2, 3); 
    Calculate.result = Calculate.minus(Calculate.result, 1);
    Calculate.result = Calculate.multiple(Calculate.result, 7);
    Calculate.result = Calculate.divide(Calculate.result, 3);

    System.out.printf("result = %d\n", Calculate.result);
  }





}

