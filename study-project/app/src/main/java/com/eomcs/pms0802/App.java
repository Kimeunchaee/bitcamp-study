package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();
    ProjectHandler projectHandler = new ProjectHandler(memberHandler);
    TaskHandler taskHandler = new TaskHandler(memberHandler);

    MAIN_LOOP : while (true) {

      String input  = null; 
      System.out.println("[메인]");
      System.out.println("1. 게시판");
      System.out.println("2. 회원");
      System.out.println("3. 프로젝트");
      System.out.println("4. 작업");
      System.out.println("0. 종료");
      int menuNo = Prompt.inputInt("메인> ");

      if(menuNo == 0) {
        input = "quit";
        // 2. 1번을 누르면 메인/게시판 메뉴를 출력함

      } else if (menuNo == 1) {
        LOOP : while(true) {    //break를 사용하면
          //스위치문을 나가게되는게 우리는 while문을
          //나가게 하고 싶으므로 while문에 loop를 사용해주고
          //break loop를 사용해 while문을 나가도록 함 
          System.out.println("[메인/게시판]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");
          menuNo = Prompt.inputInt("게시판> ");

          //if문대신 switch문 사용
          switch (menuNo) {
            case 1 : input = "/board/add"; break LOOP;
            case 2 : input = "/board/list"; break LOOP;
            case 3 : input = "/board/detail"; break LOOP;
            case 4 : input = "/board/update"; break LOOP;
            case 5 : input = "/board/delete"; break LOOP; // 브레이크 = 해당 코드 실행을 멈추고 루프로 돌아감
            case 0 : continue MAIN_LOOP; // 컨티뉴 = 더이상 아래 코드를 실행하지 않고 메인루프로 돌아감
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
      } else {  
        continue; 
      }

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/member/detail")) {
        memberHandler.detail();

      } else if (input.equals("/member/update")) {
        memberHandler.update();

      } else if (input.equals("/member/delete")) {
        memberHandler.delete();

      }  else if (input.equals("/project/add")) {
        projectHandler.add();

      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/project/detail")) {
        projectHandler.detail();

      }  else if (input.equals("/project/update")) {

        projectHandler.update();

      }  else if (input.equals("/project/delete")) {
        projectHandler.delete();

      }  else if (input.equals("/task/add")) {

        taskHandler.add();

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      }  else if (input.equals("/task/detail")) {
        taskHandler.detail();

      }  else if (input.equals("/task/update")) {

        taskHandler.update();

      }  else if (input.equals("/task/delete")) {
        taskHandler.delete();

      }  else if (input.equals("/board/add")) {
        boardHandler.add();

      }  else if (input.equals("/board/list")) {
        boardHandler.list();

      }  else if (input.equals("/board/detail")) {
        boardHandler.detail();

      }  else if (input.equals("/board/update")) {
        boardHandler.update();

      }  else if (input.equals("/board/delete")) {
        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();
    }

    Prompt.close();
  }
}












