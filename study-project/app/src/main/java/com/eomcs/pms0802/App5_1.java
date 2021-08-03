package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.util.Prompt;

public class App5_1 {

  // main()과 doBoardMenu()에서 사용할 수 있도록 main()밖으로 옮기고
  // 여러개의 메서드에서 공유하기 위해 static으로 변경
  static BoardHandler boardHandler = new BoardHandler();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
    // 5) 각각의 메인메뉴를 다루는 코드를 별도의 메서드로 추출한다
    // 각 명령을 처리하는 코드를 메서드로 분리한다
    // doBoardMenu() 분리하는 방법

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
        input = "quit";

      } else if (menuNo == 1) { 
        // 메소드 만든걸 추가
        doBoardMenu();




      } else if (menuNo == 2) { 
        while(true) {   
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
        continue; 
      }

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;


      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println();
    }

    Prompt.close();
  }



  // 메서드 추가
  static void doBoardMenu() {
    //1. 메인메서드에 있는 boardHandler 변수를
    //    doBoardMenu 메서드에서도 사용할 수 있도록
    //    static 변수로 변경해주기

    while(true) {   
      System.out.println("[메인/게시판]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세 보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      //int타입 선언해주기
      int menuNo = Prompt.inputInt("게시판> ");

      switch (menuNo) { 
        case 1 : boardHandler.add(); break;
        case 2 : boardHandler.list(); break;
        case 3 : boardHandler.detail(); break;
        case 4 : boardHandler.update(); break;
        case 5 : boardHandler.delete(); break; 
        //case 0 : continue MAIN_LOOP; // while문을 메서드로 따로 뺐기떄문에
        // Mainloop로 돌아가는 반복이 필요없음 아래처럼 수정
        case 0 : return;
        default : System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }
}












