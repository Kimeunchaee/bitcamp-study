package com.eomcs.pms.pms0719;

import com.eomcs.pms.pms0719.handler.BoardHandler;
import com.eomcs.pms.pms0719.handler.MemberHandler;
import com.eomcs.pms.pms0719.handler.ProjectHandler;
import com.eomcs.pms.pms0719.handler.TaskHandler;
import com.eomcs.pms.pms0719.util.Prompt;


public class App0 {

  public static void main(String[] args) {

    // 각 게시판에 게시글을 담을 메모리(bosrds레퍼런스배열과 size)를 준비한다
    BoardHandler boardHandler = new BoardHandler();
    BoardHandler boardHandler2 = new BoardHandler();
    BoardHandler boardHandler3 = new BoardHandler();
    BoardHandler boardHandler4 = new BoardHandler();
    BoardHandler boardHandler5 = new BoardHandler();

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
        BoardHandler.add(boardHandler);

      } else if (str.equals("/board/list")) {
        BoardHandler.list(boardHandler);


      } else if (str.equals("/board2/add")) {
        BoardHandler.add(boardHandler);
      } else if (str.equals("/board2/list")) {
        BoardHandler.list(boardHandler);

      } else if (str.equals("/board3/add")) {
        BoardHandler.add(boardHandler);
      } else if (str.equals("/board3/list")) {
        BoardHandler.list(boardHandler);

      } else if (str.equals("/board4/add")) {
        BoardHandler.add(boardHandler);
      } else if (str.equals("/board4/list")) {
        BoardHandler.list(boardHandler);

      } else if (str.equals("/board5/add")) {
        BoardHandler.add(boardHandler);

      } else if (str.equals("/board5/list")) {
        BoardHandler.list(boardHandler);


      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    Prompt.keyboardScan.close();
  }
}
