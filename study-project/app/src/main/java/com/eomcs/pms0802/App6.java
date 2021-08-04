package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler1;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.util.Prompt;

public class App6 {

  // 클래스 관계  : 합성 (composition)

  // 6) 컴포지트 패턴 적용하기
  // 6-1) 컴포넌트 역할을 정의한다
  // 직접 사용할 Menu가 아니기때문에 따로 클래스로 만들어줌(추상클래스)

  // 다음단계부터는 pms0802.Menu 순서 참고
  static BoardHandler1 boardHandler = new BoardHandler1();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {

    while(true) {
      int menuNo = doMainMenu();

      if(menuNo == 0) {
        break;
      } else if(menuNo == 1){
        doBoardMenu();
      } else if(menuNo == 2){
        doMemberMenu();
      } else if(menuNo == 3){
        doProjectMenu();
      } else if(menuNo == 4){
        doTaskMenu();
      }  else {
        System.out.println("메뉴번호가 유효하지 않습니다");
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
      switch(menuNo) {
        case 1 : boardHandler.add(); break;
        case 2 : boardHandler.list(); break;
        case 3 : boardHandler.detail(); break;
        case 4 : boardHandler.update(); break;
        case 5 : boardHandler.delete(); break;
        case 0 : return ;
        default : System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }



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
      switch(menuNo) {
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
      switch(menuNo) {
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
      switch(menuNo) {
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

  static int doMainMenu () {
    System.out.println("[메인]");
    System.out.println("1. 게시판");
    System.out.println("2. 회원");
    System.out.println("3. 프로젝트");
    System.out.println("4. 작업");
    System.out.println("0. 종료");
    return Prompt.inputInt("메인> "); 
  }
}













