package com.eomcs.pms.pms0717;

import com.eomcs.pms.pms0717.handler.BoardHandler;
import com.eomcs.pms.pms0717.handler.BoardHandler2;
import com.eomcs.pms.pms0717.handler.BoardHandler3;
import com.eomcs.pms.pms0717.handler.BoardHandler4;
import com.eomcs.pms.pms0717.handler.BoardHandler5;
import com.eomcs.pms.pms0717.handler.MemberHandler;
import com.eomcs.pms.pms0717.handler.ProjectHandler;
import com.eomcs.pms.pms0717.handler.TaskHandler;
import com.eomcs.pms.pms0717.util.Prompt;


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

      } else if (str.equals("/board/add")) {
        BoardHandler.add();

      } else if (str.equals("/board/list")) {
        BoardHandler.list();


      } else if (str.equals("/board2/add")) {
        BoardHandler2.add();
      } else if (str.equals("/board2/list")) {
        BoardHandler2.list();

      } else if (str.equals("/board3/add")) {
        BoardHandler3.add();
      } else if (str.equals("/board3/list")) {
        BoardHandler3.list();

      } else if (str.equals("/board4/add")) {
        BoardHandler4.add();
      } else if (str.equals("/board4/list")) {
        BoardHandler4.list();

      } else if (str.equals("/board5/add")) {
        BoardHandler5.add();

      } else if (str.equals("/board5/list")) {
        BoardHandler5.list();


      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    Prompt.keyboardScan.close();
  }
}
