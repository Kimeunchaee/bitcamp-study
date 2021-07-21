package com.eomcs.pms.pms0721;

import com.eomcs.pms.pms0721.handler.BoardHandler;
import com.eomcs.pms.pms0721.handler.MemberHandler;
import com.eomcs.pms.pms0721.handler.ProjectHandler;
import com.eomcs.pms.pms0721.handler.TaskHandler;
import com.eomcs.pms.pms0721.util.Prompt;


public class App1 {

  public static void main(String[] args) {

    // 각 게시판에 게시글을 담을 메모리(bosrds레퍼런스배열과 size)를 준비한다
    BoardHandler boardHandler = new BoardHandler();
    BoardHandler boardHandler2 = new BoardHandler();
    BoardHandler boardHandler3 = new BoardHandler();
    BoardHandler boardHandler4 = new BoardHandler();
    BoardHandler boardHandler5 = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();  // memberHandler 인스턴스 주소명
    ProjectHandler projectHandler = new ProjectHandler();
    TaskHandler taskHandler = new TaskHandler();


    while(true) {
      String str = Prompt.inputString("명령 > ");

      if (str.equals("exit") || str.equals("quit")) {
        break;

      } else if (str.equals("/member/add")) {
        memberHandler.add();

      } else if(str.equals("/member/list")) {
        memberHandler.list();

        // app1 에서 MemberHandler클래스메소드의 내용을 받아와서
        // new로 새로운 인스턴스를 생성함 (인스턴스 이름 : memberHandler)
        // 인스턴스변수명을 add()에 넣어줌
      } else if(str.equals("/project/add")) { 
        projectHandler.add(memberHandler); 

      } else if (str.equals("/project/list")) {
        projectHandler.list();

      } else if (str.equals("/task/add")) {
        taskHandler.add(memberHandler);

      } else if (str.equals("/task/list")) {
        taskHandler.list();



      } else if (str.equals("/board/add")) {
        //BoardHandler.add(boardHandler);
        boardHandler.add();
      } else if (str.equals("/board/list")) {
        boardHandler.list();

      } else if (str.equals("/board2/add")) {
        boardHandler2.add();
      } else if (str.equals("/board2/list")) {
        boardHandler2.list();

      } else if (str.equals("/board3/add")) {
        boardHandler3.add();
      } else if (str.equals("/board3/list")) {
        boardHandler3.list();

      } else if (str.equals("/board4/add")) {
        boardHandler4.add();
      } else if (str.equals("/board4/list")) {
        boardHandler4.list();

      } else if (str.equals("/board5/add")) {
        boardHandler5.add();
      } else if (str.equals("/board5/list")) {
        boardHandler5.list();


      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    Prompt.keyboardScan.close();
  }
}
