package com.eomcs.oop.ex00;

// 4. instant 변수 선언
// new명령어로 생성된다. 데이터를 개별적으로 다룰수 있다

public class Exam0214 {

  static class Calculate {

    // 두가지 식을 동시에 가져오기 위해서는 계산값을 각각 관리해주어야한다.
    // static변수를 인스턴스 변수로 변경해서 두가지 식을 관리해 준다.
    // 13. 인스턴스 메소드를 사용하기 위해서는 static을 뗴어준다
    int result = 0;  

    // 인스턴스 변수(c1,c2)를 사용하기 위해 인스턴스주소값 이름을 Calculate 를 선언해준다.
    // 11. (객체 주소(를 담는 변수명), 숫자값(을 담는 변수명) 으로 수정해준다
    void plus(Calculate obj, int value) {   
      obj.result += value; //반환하는 값이 obj인지 value인지 알려주기
    }

    void minus(Calculate obj, int value) {
      obj.result -= value;
    }

    void multiple(Calculate obj, int value) {
      obj.result *= value;
    }

    void divide(Calculate obj, int value) {
      obj.result /= value;
    }
  }


  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = ?

    // 10. instant 변수를 선언해준다 (두가지 식)
    // static이 붙지 않은 변수만 만들어진다
    Calculate c1 = new Calculate();
    Calculate c2 = new Calculate();


    // 12. 변수 선언대로 instant 변수명을 c1으로 변경해주고
    //     객체명, 숫자값으로 수정해준다  
    // Calculate.plus(2); > c1.plus(c1, 2);

    c1.plus(c1, 2);
    c2.plus(c1, 3);
    c2.minus(c1, 1);
    c1.multiple(c1, 7);
    c1.divide(c1,3);
    System.out.printf("result = %d\n", c1.result);
  }





}

