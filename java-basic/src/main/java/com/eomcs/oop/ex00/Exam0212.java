package com.eomcs.oop.ex00;

//2. static 변수


public class Exam0212 {

  static class Calculate {

    static int result = 0;   //2. main()메서드에서 사용하기 위해 static을 붙혀줌 

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

    // 1. result변수의 메소드를 호출하기 위해 Calculate에서 불러왔다고 정의해준다
    Calculate.result = Calculate.plus(2, 3); 
    Calculate.result = minus(Calculate.result, 1);
    Calculate.result = multiple(Calculate.result, 7);
    Calculate.result = divide(Calculate.result, 3);

    System.out.printf("result = %d\n", Calculate.result);
  }





}

