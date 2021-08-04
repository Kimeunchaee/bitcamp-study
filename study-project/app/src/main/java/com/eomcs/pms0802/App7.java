package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler1;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.menu.BoardDeleteMenu;
import com.eomcs.pms0802.menu.BoardDetailMenu;
import com.eomcs.pms0802.menu.BoardListMenu;
import com.eomcs.pms0802.menu.BoardUpdateMenu;
import com.eomcs.pms0802.menu.MemberAddMenu;
import com.eomcs.pms0802.menu.MemberDeleteMenu;
import com.eomcs.pms0802.menu.MemberDetailMenu;
import com.eomcs.pms0802.menu.MemberListMenu;
import com.eomcs.pms0802.menu.MemberUpdateMenu;
import com.eomcs.pms0802.menu.Menu;
import com.eomcs.pms0802.menu.MenuGroup;
import com.eomcs.pms0802.menu.ProjectAddMenu;
import com.eomcs.pms0802.menu.ProjectDeleteMenu;
import com.eomcs.pms0802.menu.ProjectDetailMenu;
import com.eomcs.pms0802.menu.ProjectListMenu;
import com.eomcs.pms0802.menu.ProjectUpdateMenu;
import com.eomcs.pms0802.menu.TaskAddMenu;
import com.eomcs.pms0802.menu.TaskDeleteMenu;
import com.eomcs.pms0802.menu.TaskDetailMenu;
import com.eomcs.pms0802.menu.TaskListMenu;
import com.eomcs.pms0802.menu.TaskUpdateMenu;
import com.eomcs.pms0802.util.Prompt;

public class App7 {

  // 7) Menu 기능을 추가함


  static BoardHandler1 boardHandler = new BoardHandler1();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {

    // createMenu() 메서드 추가 (아래에)
    Menu mainMenu = createMenu();

    // execute() 추가
    mainMenu.execute();

    // while문 필요없음
    //    while(true) {
    //      int menuNo = doMainMenu();
    //      if(menuNo == 0) {
    //        break;
    //      } else if(menuNo == 1){
    //        doBoardMenu();
    //      } else if(menuNo == 2){
    //        doMemberMenu();
    //      } else if(menuNo == 3){
    //        doProjectMenu();
    //      } else if(menuNo == 4){
    //        doTaskMenu();
    //      }  else {
    //        System.out.println("메뉴번호가 유효하지 않습니다");
    //      }
    //      System.out.println();
    //    }

    Prompt.close();
  }




  // 메서드 추가
  static Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    //-----게시판
    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    //메뉴항목 집어넣기
    //boardMenu.add(new BoardAddMenu(boardHandler));
    boardMenu.add(new BoardListMenu(boardHandler));
    boardMenu.add(new BoardDetailMenu(boardHandler));
    boardMenu.add(new BoardUpdateMenu(boardHandler));
    boardMenu.add(new BoardDeleteMenu(boardHandler));


    //-----회원
    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    //메뉴항목 집어넣기
    memberMenu.add(new MemberAddMenu(memberHandler));
    memberMenu.add(new MemberListMenu(memberHandler));
    memberMenu.add(new MemberDetailMenu(memberHandler));
    memberMenu.add(new MemberUpdateMenu(memberHandler));
    memberMenu.add(new MemberDeleteMenu(memberHandler));

    //-----프로젝트
    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    //메뉴항목 집어넣기
    projectMenu.add(new ProjectAddMenu(projectHandler));
    projectMenu.add(new ProjectListMenu(projectHandler));
    projectMenu.add(new ProjectDetailMenu(projectHandler));
    projectMenu.add(new ProjectUpdateMenu(projectHandler));
    projectMenu.add(new ProjectDeleteMenu(projectHandler));


    //-----작업
    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    //메뉴항목 집어넣기
    taskMenu.add(new TaskAddMenu(taskHandler));
    taskMenu.add(new TaskListMenu(taskHandler));
    taskMenu.add(new TaskDetailMenu(taskHandler));
    taskMenu.add(new TaskUpdateMenu(taskHandler));
    taskMenu.add(new TaskDeleteMenu(taskHandler));











    return mainMenuGroup;   //상위클래스를 리턴할수있음
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













