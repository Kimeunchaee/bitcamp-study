package com.eomcs.oop.ex00;

// 3. instant 변수 선언
public class Exam0214 {

  static class Calculate {

    static int result = 0;  

    // (객체 주소(를 담는 변수명), 숫자값(을 담는 변수명) 으로 수정해준다
    static void plus(Calculate obj, int value) {   
      result += value;
    }

    static void minus(Calculate obj, int value) {
      result -= value;
    }

    static void multiple(Calculate obj, int value) {
      result *= value;
    }

    static void divide(Calculate obj, int value) {
      result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?


    // 객체명, 숫자값으로 수정해준다  
    Calculate.plus(2);
    Calculate.plus(3);
    Calculate.minus(1);
    Calculate.multiple(7);
    Calculate.divide(3);

    System.out.printf("result = %d\n", Calculate.result);
  }





}

