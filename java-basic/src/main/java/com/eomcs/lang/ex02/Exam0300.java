// 주석 종류중에 하나 : 애노테이션(annotation)



package com.eomcs.lang.ex02;

public class Exam0300 {
  public static void main(String[] args) {
    System.out.println("애노테이션");
  }
  
  //## @Override 
  //- 수퍼 클래스에서 상속 받은 멤버를 재정의 한다는 것을 컴파일러에게 알린다.
  //- 컴파일러는 오버라이딩 규칙을 준수하는지 검사한다.
  //- 만약 오버라이딩 규칙을 따르지 않는다면 컴파일 오류를 발생시킬 것이다.
  //
  @Override
  public String toString() {
    return "Exam12";
  }
}