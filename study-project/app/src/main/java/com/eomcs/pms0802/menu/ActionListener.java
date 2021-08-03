package com.eomcs.pms0802.menu;


//MenuItem이 리스너 객체를 실행할때 호출할 메서드의 규칙을 정의하는 문법 (=인터페이스) 
public interface ActionListener {

  void doAction(); 
  // 인터페이스의 메서드는 규칙을 표현하는 것이다.
  // 그래서 추상 메서드이다.
  // 그리고 모두의 접근을 허락하는 public 이다. 
}