package com.eomcs.oop.ex00;
//p1 은 메소드 분류(calculator를 별도의 클래스로 옮겨주기)
//
//p2 결과값 클래스에서 관리하기
//calculator 클래스 내에서 결과값을 관리하도록 한다
//
//p3 result 결과값이 static이면 한번만 사용 가능하기때문에 인스턴스 변수로 바꿔준다 (여러번 사용하도록)
//(인스턴스 변수는 주소값을 받을 파라미터가 꼭 필요하다!)
//
//p4 인스턴스 변수를 더 편하게 사용하기 위해
//static메소드들을 인스턴스 메소드로 바꿔서 사용해준다(인스턴스 메소드는 따로 파라미터를 받을 필요없고 내장된 변수 this를 사용) 
//인스턴스 메소드는 호출이 쉽고 간결하다
public class Calculator {

  static int plus(int result, int value) {
    return result + value;
  }

  static int minus(int result, int value) {
    return result - value;
  }

  static int multiple(int result, int value) {
    return result * value;
  }
}








//
//p1 은 메소드 분류(calculator를 별도의 클래스로 옮겨주기)
//
//p2 결과값 클래스에서 관리하기
//calculator 클래스 내에서 결과값을 관리하도록 한다
//
//p3 result 결과값이 static이면 한번만 사용 가능하기때문에 인스턴스 변수로 바꿔준다 (여러번 사용하도록)
//(인스턴스 변수는 주소값을 받을 파라미터가 꼭 필요하다!)
//
//p4 인스턴스 변수를 더 편하게 사용하기 위해
//static메소드들을 인스턴스 메소드로 바꿔서 사용해준다(인스턴스 메소드는 따로 파라미터를 받을 필요없고 내장된 변수 this를 사용) 
//인스턴스 메소드는 호출이 쉽고 간결하다