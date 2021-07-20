package com.eomcs.oop.ex00;

public class Exam0502 {

  // Calculate 를 다른 파일에서도 사용하고싶을때
  // Calculate 클래스파일을 따로 생성
  // 계산기에 관련된 기능은 Calculate파일에 모아서 사용해야
  // 유지보수가 쉽다
  // 인스턴스 변수나 인스턴스 메소드를 사용하지 않으면 static을 붙혀준다
  // 패키지를 새로 만들어 (util) 적절한 이름으로 클래스파일을 보관해주면
  // 나중에도 사용할수 있고 유지보수가 쉽다



  static class Calculate {

    int result = 0;  //static을 붙히지 않으면 다른 메소드에서 불러다 사용할수있다 ?????????


    void plus(int value) { //int a, int b
      //return a + b;
      this.result += value;
    }

    void minus(int value) {  //메소드가 호출될때 minus변수에 저장된 인스턴스 주소를 받기위해 that을 붙혀줌
      //return a - b;
      this.result -= value;
    }

    void multiple(int value) {  //인스턴스 메소드를 사용하기 위해서는 static을 뗴어줌
      //return a * b;
      this.result *= value;
    }

    void divide(int value) {
      //return a / b;
      this.result /= value;
    }
  }





  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?
    Calculate c1 = new Calculate(); // Calculator 클래스에 static이 붙지 않은 변수를 가지고 옴
    Calculate c2 = new Calculate();


    c1.plus(2); // 앞에서 인스턴스주소를 받는 방법 : 더 간단하게 직관적으로 작성할수있다
    // 이방법은 Calculate that 파라미터가 필요없고
    // this를 사용해야한다.

    c1.multiple(7);
    c1.plus(2);


    //    Calculate.plus(c1,2);
    //    Calculate.plus(c2,3);   // 이방법은 that을 사용해야한다
    //
    //    Calculate.plus(c1,3);
    //    Calculate.multiple(c2,7);
    //
    //    Calculate.minus(c1,1);
    //    Calculate.plus(c2,7);
    //
    //    Calculate.multiple(c1,7);
    //    Calculate.divide(c2,4);
    //
    //    Calculate.divide(c1,3);
    //    Calculate.minus(c2,5);

    System.out.printf("result = %d\n", c1.result);

  }
}

