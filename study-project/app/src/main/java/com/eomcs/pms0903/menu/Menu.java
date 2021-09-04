package com.eomcs.pms0903.menu;

public abstract class Menu {
  //-----------------------------------------------------------------------------------------
  // 기존
  //  public static final int ENABLE_ALL = 0;
  //  public static final int ENABLE_LOGOUT = 1;
  //  public static final int ENABLE_LOGIN = 2;

  // 변경
  public static final int ACCESS_LOGOUT = 0x01; //로그아웃
  public static final int ACCESS_GENERAL = 0x01; //일반
  public static final int ACCESS_ADMIN = 0x01; //관리자


  //-----------------------------------------------------------------------------------------

  String title;         // 제목
  int enableState;      // 어느 상태에서 활성화 시킬건지(ENABLE 였을때 사용했음)
  int accessScope;      // 접근범위 //만약 아무것도 하지 않았다면 기본적으로 값이 0

  //-----------------------------------------------------------------------------------------

  public Menu(String title) {
    // 기존
    //this.title = title;
    // 추가
    this(title, ACCESS_LOGOUT | ACCESS_GENERAL | ACCESS_ADMIN);
    // 모든사람이 접근 가능한 메뉴
  }

  //-----------------------------------------------------------------------------------------

  //  public Menu(String title, int enableState) {
  //    this(title); // 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
  //    this.enableState = enableState;
  //  }

  //-----------------------------------------------------------------------------------------

  // 생성자 추가
  // 기존 생성자를 손대면 이 생성자를 사용한 데이터도 날아감
  // 새로 추가해준다
  public Menu(String title, int accessScope) {
    // 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
    //this(title); 
    this.title = title;     // 이 생성자가 기본 생성자가 된다
    this.accessScope = accessScope;
  }

  //-----------------------------------------------------------------------------------------

  public abstract void execute();
}
