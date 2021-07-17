package com.eomcs.pms.pms0717;

public class App0 {

  public static void main(String[] args) {
    while(true) {
      String str = Prompt.inputString("명령 > ");

      if (str.equals("exit") || str.equals("quit")) {
        break;

      } else if (str.equals("/member/add")) {
        MemberHandler.add();

      } else if(str.equals("/member/list")) {
        MemberHandler.list();

      } else if(str.equals("/project/add")) { 
        ProjectHandler.add();

      } else if (str.equals("/project/list")) {
        ProjectHandler.list();

      } else if (str.equals("/task/add")) {
        TaskHandler.add();

      } else if (str.equals("/task/list")) {
        TaskHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    Prompt.keyboardScan.close();
  }
}
