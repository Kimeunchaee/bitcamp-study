package com.eomcs.pms.pms0719.handler;


public class Test {

  public static void main(String[] args) {

    while (true) {


      java.util.Scanner sc = new java.util.Scanner(System.in);
      static String input(String name) {
        return sc.nextLine();
      }

      if (name.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return;
      } else if (name.length() >= 0)) {
        System.out.println("회원을 등록합니다.");
        break;
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }

  }

}
