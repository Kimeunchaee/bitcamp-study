package com.eomcs.oop.ex00;

// 5. this 사용
public class Exam0216 {

  static class Calculate {

    // 15. 인스턴스 주소를 앞에서 받을때는 파라미터(=변수명(주소))에 this를 사용한다
    // 16. 인스턴스 메소드를 사용하기 위해서는 static을 뗴어준다
    int result = 0;  

    void plus(Calculate this, int value) {   
      result += value;
    }

    void minus(Calculate this, int value) {
      result -= value;
    }

    void multiple(Calculate this, int value) {
      result *= value;
    }

    void divide(Calculate this, int value) {
      result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    Calculate c1 = new Calculate();
    Calculate c2 = new Calculate();


    // 14. 인스턴스 주소를 앞에서 받도록 작성해준다(더 간단하고 직관적이기때문)
    // Calculate.plus(c1, 2); > c1.plus(2);
    c1.plus(2);
    c2.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n", c1.result);
  }
}

