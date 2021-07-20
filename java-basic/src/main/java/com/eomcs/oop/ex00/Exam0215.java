package com.eomcs.oop.ex00;

// 5. that 사용
public class Exam0215 {

  static class Calculate {


    int result = 0;  

    // 14. 파라미터 이름 : obj 변수명 대신 taht 변수명을 사용해준다
    // 의미 없음 (obj와 that 둘다 단순히 변수명임) 예제 연습일뿐
    void plus(Calculate taht, int value) {   
      taht.result += value;  //obj를 that으로 수정
    }

    void minus(Calculate taht, int value) {
      taht.result -= value;
    }

    void multiple(Calculate taht, int value) {
      taht.result *= value;
    }

    void divide(Calculate taht, int value) {
      taht.result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    Calculate c1 = new Calculate();
    Calculate c2 = new Calculate();

    c1.plus(c1, 2);
    c2.plus(c2, 3);
    c2.minus(c1, 1);
    c1.multiple(c1, 7);
    c1.divide(c1,3);

    System.out.printf("result = %d\n", c1.result);
  }
}

