package com.eomcs.pms0802.Menu;


// 2) 서브클래스인 MenuGroup클래스를 만들고
// execute() 메서드를 오버라이딩한다
public abstract class Menu6_2 {

  // *메뉴메서드를 사용하려면 무조건 타이틀을 사용하도록 파라미터를 받는 생성자로 만든다

  // 기본생성자를 정의하지않는다(메뉴이름없이는 인스턴스를 생성할수 없도록)
  // 대신 인스턴스를 만들때 반드시 메뉴이름을 입력하도록 강요하기 위해 다음과 같이
  // String을 파라미터로 받는 생성자를 정의한다
  String title;
  public Menu6_2(String title) {
    this.title = title;
  }

  public abstract void execute();

}
