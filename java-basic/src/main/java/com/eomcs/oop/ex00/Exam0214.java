package com.eomcs.oop.ex00;

// 4. instant 메소드 선언
public class Exam0214 {

  static class Calculate {

    static int result = 0;  

    // 11. (객체 주소(를 담는 변수명), 숫자값(을 담는 변수명) 으로 수정해준다
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

    // 10. instant 메소드를 선언해준다
    Calculate c1 = new Calculate();
    Calculate c2 = new Calculate();


    // 12. 메소드선언대로 객체명, 숫자값으로 수정해준다  
    Calculate.plus(c1, 2);
    Calculate.plus(c2, 3);
    Calculate.minus(c1, 1);
    Calculate.multiple(c1, 7);
    Calculate.divide(c1,3);

    System.out.printf("result = %d\n", Calculate.result);
  }





}

