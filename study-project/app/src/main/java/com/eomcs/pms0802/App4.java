package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.util.Prompt;

public class App4 {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();
    ProjectHandler projectHandler = new ProjectHandler(memberHandler);
    TaskHandler taskHandler = new TaskHandler(memberHandler);

    // 4) 메뉴 번호를 입력했을때 해당 기능을 바로 실행하도록 한다
    // 번호를 입력하면 해당 번호의 명령을 바로 처리한다
    
    MAIN_LOOP : while (true) {
      String input  = null; 
      System.out.println();
      System.out.println("[메인]");
      System.out.println("1. 게시판");
      System.out.println("2. 회원");
      System.out.println("3. 프로젝트");
      System.out.println("4. 작업");
      System.out.println("0. 종료");
      int menuNo = Prompt.inputInt("메인> ");
      System.out.println();

      if(menuNo == 0) {
        // 0번이면 메인루프가 종료되도록
        // break를 넣어줌 ( if문안에서 직접실행하도록
        input = "quit";

      } else if (menuNo == 1) { 
        // 루프 삭제, boardHandler.add()로 수정
        while(true) {   
          System.out.println("[메인/게시판]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("게시판> ");

          switch (menuNo) { 
            // input 하지 않고 boardHandler.add() 메서드를 바로 실행하도록 수정함
            // 기존코드 case 1 : input = "/board/add"; break LOOP;
            // LOOP 부분으로 돌아갈 필요없으므로 LOOP삭제
            case 1 : boardHandler.add(); break;
            case 2 : boardHandler.list(); break;
            case 3 : boardHandler.detail(); break;
            case 4 : boardHandler.update(); break;
            case 5 : boardHandler.delete(); break; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
      } else if (menuNo == 2) { 
        while(true) {   
          // 루프 삭제, memberHandler.add()로 수정
          System.out.println("[메인/회원]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("회원> ");
          switch (menuNo) { 
            case 1 : memberHandler.add(); break;
            case 2 : memberHandler.list(); break;
            case 3 : memberHandler.detail(); break;
            case 4 : memberHandler.update(); break;
            case 5 : memberHandler.delete(); break; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
      } else if (menuNo == 3) { 
        // 루프 삭제, projectHandler.add()로 수정
        while(true) {   
          System.out.println("[메인/프로젝트]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("프로젝트> ");
          switch (menuNo) { 
            case 1 : projectHandler.add(); break;
            case 2 : projectHandler.list(); break;
            case 3 : projectHandler.detail(); break;
            case 4 : projectHandler.update(); break;
            case 5 : projectHandler.delete(); break; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }
      } else if (menuNo == 4) { 
        // 루프 삭제, taskHandler.add()로 수정
        while(true) {   
          System.out.println("[메인/작업]");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 상세 보기");
          System.out.println("4. 변경");
          System.out.println("5. 삭제");
          System.out.println("0. 이전메뉴");

          menuNo = Prompt.inputInt("작업> ");
          switch (menuNo) { 
            case 1 : taskHandler.add(); break;
            case 2 : taskHandler.list(); break;
            case 3 : taskHandler.detail(); break;
            case 4 : taskHandler.update(); break;
            case 5 : taskHandler.delete(); break; 
            case 0 : continue MAIN_LOOP;
            default : System.out.println("무효한 메뉴 번호입니다.");
          }
          System.out.println();
        }

      } else {  
        continue; // 옳지 않은 번호를 입력한 경우에는 다시 메뉴를 출력한다
      }

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;

        // 위에 코드에 직접 실행하도록 넣어줬기때문에 필요없음
        //      } else if (input.equals("/member/add")) {
        //        memberHandler.add();
        //
        //      } else if (input.equals("/member/list")) {
        //        memberHandler.list();
        //
        //      } else if (input.equals("/member/detail")) {
        //        memberHandler.detail();
        //
        //      } else if (input.equals("/member/update")) {
        //        memberHandler.update();
        //
        //      } else if (input.equals("/member/delete")) {
        //        memberHandler.delete();
        //
        //      }  else if (input.equals("/project/add")) {
        //        projectHandler.add();
        //
        //      }  else if (input.equals("/project/list")) {
        //        projectHandler.list();
        //
        //      }  else if (input.equals("/project/detail")) {
        //        projectHandler.detail();
        //
        //      }  else if (input.equals("/project/update")) {
        //
        //        projectHandler.update();
        //
        //      }  else if (input.equals("/project/delete")) {
        //        projectHandler.delete();
        //
        //      }  else if (input.equals("/task/add")) {
        //
        //        taskHandler.add();
        //
        //      }  else if (input.equals("/task/list")) {
        //        taskHandler.list();
        //
        //      }  else if (input.equals("/task/detail")) {
        //        taskHandler.detail();
        //
        //      }  else if (input.equals("/task/update")) {
        //
        //        taskHandler.update();
        //
        //      }  else if (input.equals("/task/delete")) {
        //        taskHandler.delete();
        //
        //      }  else if (input.equals("/board/add")) {
        //        boardHandler.add();
        //
        //      }  else if (input.equals("/board/list")) {
        //        boardHandler.list();
        //
        //      }  else if (input.equals("/board/detail")) {
        //        boardHandler.detail();
        //
        //      }  else if (input.equals("/board/update")) {
        //        boardHandler.update();
        //
        //      }  else if (input.equals("/board/delete")) {
        //        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();
    }

    Prompt.close();
  }
}












