// 클래스 변수의 응용 : 상수변수이용해서 import 하기

//
package com.eomcs.oop.ex03;

//여러 개를 한 번에 명시하고 싶다면 다음과 같이 wildcard(*)로 지정해도 된다.
//import static com.eomcs.oop.ex03.Member.*;


public class Exam0163 {

  public static void main(String[] args) {

    // Member와 관련된 상수라면 
    // Member 클래스에 선언하는 것이 유지보수에 더 낫다.

    Member m4 = new Member();
    m4.id = "aaa";
    m4.password = "1111";
    m4.type = Member.GUEST;
    // 스태틱 변수는 변수명 앞에 클래스명을 명시해야 한다.

    Member m5 = new Member();
    m5.id = "bbb";
    m5.password = "1111";
    m5.type = Member.MANAGER;

    Member m6 = new Member();
    m6.id = "ccc";
    m6.password = "1111";
    m6.type = Member.MEMBER;
  }
}








