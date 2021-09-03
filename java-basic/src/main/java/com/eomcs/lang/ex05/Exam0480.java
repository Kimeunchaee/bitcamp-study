package com.eomcs.lang.ex05;

//# 비트 연산자 : 응용 III
//
public class Exam0480 {
  public static void main(String[] args) {
    // 1) 사용자 권한을 값으로 정의
    final int LOGOUT           = 0x01; // 0000 0001 - 로그아웃
    final int GENERAL        = 0x02; // 0000 0010   - 일반 로그인
    final int MANAGER       = 0x04; // 0000 0100    - 관리자 로그인

    // 2) 메뉴의 접근 범위 설정
    int menu1 = LOGOUT; // 로그아웃 상태에서만 접근 가능한 메뉴
    int menu2 = GENERAL;    // 일반으로 로그인 된 사용자만 접근 가능한 메뉴
    int menu3 = MANAGER; // 관리자로 로그인 된 사용자만 접근 가능한 메뉴
    int MENU4 = LOGOUT | GENERAL | MANAGER ; // 로그아웃 되었든, 일반으로 로그인되었든, 관리자로 로그인 되었든 모두 접근가능


    // 3) 접근 테스트
    System.out.println((menu1 & LOGOUT) > 0); // 0보다 크면 접근가능
    System.out.println((menu1 & GENERAL) > 0);
  }
}
