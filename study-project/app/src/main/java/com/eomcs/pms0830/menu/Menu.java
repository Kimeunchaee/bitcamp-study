package com.eomcs.pms0830.menu;

public abstract class Menu {

  // 상수 추가
  public static final int ENABLE_ALL = 0;           // 로그인 유무 상관 없음
  public static final int ENABLE_LOGOUT = 1;        //로그아웃상태
  public static final int ENABLE_LOGIN = 2;         //로그인상태

  String title;

  // 필드 추가
  // 0 : 로그인 유무 상관없음
  // 1 : 로그인 했을때
  // 2 : 로그인 안했을때
  // 숫자로 값을 다루면 나중에 숫자가 무엇을 의미하는지 알기 힘드므로
  // 상수로 선언해주고 변수명을 사용한다

  int enableState;


  public Menu(String title) {
    this.title = title;
  }

  // 생성자 추가
  public Menu(String title, int enableState) {
    //this.title = title;
    this(title); // 메뉴 이름 설정은 기존 생성자의 title를 통해 처리한다
    this.enableState = enableState;
  }

  public abstract void execute();


}
