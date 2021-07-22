package com.eomcs.oop.ex00;

// 6. instant 메서드 사용 (this 사용)
public class Exam0216 {

  static class Calculate {


    int result = 0; 

    // 인스턴스 변수(c1,c2...)를 쉽게 다루기 위해(쉽게 다룬다 = 앞에 작성/앞에 써주면 가독성이 좋고
    // 유지보수가 쉬움) 인스턴스 메서드를 사용해준다
    // 인스턴스 주소를 받을때는 파라미터 이름인 변수명(주소) 대신에 this를 사용한다
    // 이때 this 변수는 객체, 자기 자신을 기리키는 명령어로 정해져 있는 변수이며,
    // 인스턴스 메서드안제 내장되어 있기때문에 다른 메서드에서는 사용할 수 없으므로 static을 지워준다.
    // 15. that > this 로 변경

    // that을 this로 바꿔준다. 자기자신을 가리키고 있기때문에
    // 따로 선언을 해 줄 필요도 없다(Calculate this, int value) > (int value) 로 변경

    void plus(int value) {  
      this.result += value;     //that을 this로 변경
    }

    void minus(int value) {
      this.result -= value;
    }

    void multiple(int value) {
      this.result *= value;
    }

    void divide(int value) {
      this.result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    Calculate c1 = new Calculate();
    Calculate c2 = new Calculate();


    // 14. 인스턴스 주소를 앞에서 받도록 작성해준다(더 간단하고 직관적이기때문)
    // c1.plus(c1, 2); > c1.plus(2);
    c1.plus(2);
    c2.plus(3);
    c2.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n", c1.result);
  }
}

