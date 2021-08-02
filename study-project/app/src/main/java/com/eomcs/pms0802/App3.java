package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.util.Prompt;

public class App3 {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();
    ProjectHandler projectHandler = new ProjectHandler(memberHandler);
    TaskHandler taskHandler = new TaskHandler(memberHandler);

    // 3) 회원/프로젝트/작업 메뉴를 출력하고 번호를 입력 받는다.
    //  - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.

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
      } else if (menuNo == 1) { 
        LOOP : while(true) {   
          System.out.println("[메인/게시판]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("게시판> ");
          switch (menuNo) { 
            case 1 : input = "/board/add"; break LOOP;
            case 2 : input = "/board/list"; break LOOP;
            case 3 : input = "/board/detail"; break LOOP;
            case 4 : input = "/board/update"; break LOOP;
            case 5 : input = "/board/delete"; break LOOP; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
        // 2번을 입력하면 메인/회원이 출력됨
      } else if (menuNo == 2) { 
        LOOP : while(true) {   
          System.out.println("[메인/회원]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("회원> ");
          switch (menuNo) { 
            case 1 : input = "/member/add"; break LOOP;
            case 2 : input = "/member/list"; break LOOP;
            case 3 : input = "/member/detail"; break LOOP;
            case 4 : input = "/member/update"; break LOOP;
            case 5 : input = "/member/delete"; break LOOP; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
        // 3번을 입력하면 메인/프로젝트 가 출력됨
      } else if (menuNo == 2) { 
        LOOP : while(true) {   
          System.out.println("[메인/프로젝트]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("프로젝트> ");
          switch (menuNo) { 
            case 1 : input = "/project/add"; break LOOP;
            case 2 : input = "/project/list"; break LOOP;
            case 3 : input = "/project/detail"; break LOOP;
            case 4 : input = "/project/update"; break LOOP;
            case 5 : input = "/project/delete"; break LOOP; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
        // 4번을 입력하면 메인/작업 이 출력됨
      } else if (menuNo == 4) { 
        LOOP : while(true) {   
          System.out.println("[메인/작업]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("작업> ");
          switch (menuNo) { 
            case 1 : input = "/task/add"; break LOOP;
            case 2 : input = "/task/list"; break LOOP;
            case 3 : input = "/task/detail"; break LOOP;
            case 4 : input = "/task/update"; break LOOP;
            case 5 : input = "/task/delete"; break LOOP; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
      } else {  
        continue;  // 옳지 않은 번호를 입력한 경우에는 다시 메뉴를 출력한다
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












