package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler1;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.util.Prompt;

public class App5_2 {

  static BoardHandler1 boardHandler = new BoardHandler1();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
    // 5-2)  doMemberMenu(), doProjectMenu(), doTaskMenu();
    // 나머지 메서드들도 마찬가지로 분류하기
    // doMainMenu() 도 분류하기

    MAIN_LOOP : while (true) {
      //String input  = null; 삭제
      //doMainMenu() 이 메서드에 int menuNo 선언
      int menuNo = doMainMenu();

      if(menuNo == 0) {
        //input = "quit"; //아래코드로 수정
        break;

      } else if (menuNo == 1) { 
        doBoardMenu();

      } else if (menuNo == 2) { 
        doMemberMenu();

      } else if (menuNo == 3) { 
        doProjectMenu();

      } else if (menuNo == 4) { 
        doTaskMenu();

        // 삭제
        //      } else {  
        //        continue; 
        //      }
        //
        //      if (input.equals("exit") || input.equals("quit")) {
        //        System.out.println("안녕!");
        //        break;
      } else {
        //실행할 수 없는 명령입니다 대신 출력문 넣어주기
        System.out.println("메뉴 번호가 유효하지 않습니다");
      }

      System.out.println();
    }
    Prompt.close();
  }


  static void doBoardMenu() {
    while(true) {   
      System.out.println("[메인/게시판]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세 보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("게시판> ");
      switch (menuNo) { 
        case 1 : boardHandler.add(); break;
        case 2 : boardHandler.list(); break;
        case 3 : boardHandler.detail(); break;
        case 4 : boardHandler.update(); break;
        case 5 : boardHandler.delete(); break; 
        case 0 : return;
        default : System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }


  // 메서드 추가
  //int 타입 추가
  // 0번일때 return으로 수정
  static void doMemberMenu() {
    while(true) {   
      System.out.println("[메인/회원]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세 보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("회원> ");
      switch (menuNo) { 
        case 1 : memberHandler.add(); break;
        case 2 : memberHandler.list(); break;
        case 3 : memberHandler.detail(); break;
        case 4 : memberHandler.update(); break;
        case 5 : memberHandler.delete(); break; 
        case 0 : return;
        default : System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  // 메서드 추가
  //int 타입 추가
  // 0번일때 return으로 수정
  static void doProjectMenu() {
    while(true) {   
      System.out.println("[메인/프로젝트]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세 보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("프로젝트> ");
      switch (menuNo) { 
        case 1 : projectHandler.add(); break;
        case 2 : projectHandler.list(); break;
        case 3 : projectHandler.detail(); break;
        case 4 : projectHandler.update(); break;
        case 5 : projectHandler.delete(); break; 
        case 0 : return;
        default : System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }


  // 메서드 추가
  //int 타입 추가
  // 0번일때 return으로 수정
  static void doTaskMenu() {
    while(true) {   
      System.out.println("[메인/작업]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세 보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("작업> ");
      switch (menuNo) { 
        case 1 : taskHandler.add(); break;
        case 2 : taskHandler.list(); break;
        case 3 : taskHandler.detail(); break;
        case 4 : taskHandler.update(); break;
        case 5 : taskHandler.delete(); break; 
        case 0 : return;
        default : System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  // 메서드 추가
  static int doMainMenu() {
    //System.out.println(); 줄바꿈 필요없어서 지워줌
    System.out.println("[메인]");
    System.out.println("1. 게시판");
    System.out.println("2. 회원");
    System.out.println("3. 프로젝트");
    System.out.println("4. 작업");
    System.out.println("0. 종료");
    // int menuNo = Prompt.inputInt("메인> ");
    // System.out.println();
    // 지우고
    return Prompt.inputInt("메인>");
  }



}












