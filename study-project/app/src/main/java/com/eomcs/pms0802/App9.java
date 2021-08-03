package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.menu.Menu;
import com.eomcs.pms0802.menu.MenuGroup;
import com.eomcs.pms0802.util.Prompt;

public class App9 {

  // 9) 스태틱멤버를 인스턴스멤버로 변환
  // 우선 static을 빼주고
  // static Menu createMenu()메서드를 인스턴스메서드로 전환한다 (static빼주기)
  // service() 인스턴스 메서드를 추가해서 main()의 코드들(=APP에서 실행할 애들)을 옮겨준다
  // main() 메서드에서 App 클래스의 service() 를 호출한다.

  BoardHandler boardHandler = new BoardHandler();
  MemberHandler memberHandler = new MemberHandler();
  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {

    //  이 코드들을 service안에 넣어준다
    //    Menu mainMenu = createMenu();
    //    mainMenu.execute();
    //    Prompt.close();

    //추가
    App9 app = new App9();
    app.service();
  }

  void service() {
    //    Menu mainMenu = createMenu();
    //    mainMenu.execute();
    createMenu().execute();
    Prompt.close();
  }


  //--------------------------------------
  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");


    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);


    boardMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        boardHandler.add();
      }
    });
    boardMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        boardHandler.list();
      }
    });
    boardMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail();
      }
    });
    boardMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        boardHandler.update();
      }
    });
    boardMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        boardHandler.delete();
      }
    });



    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);
    memberMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        memberHandler.add();
      }
    }); 
    memberMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        memberHandler.list();
      }
    });
    memberMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail();
      }
    });
    memberMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        memberHandler.update();
      }
    });
    memberMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        memberHandler.delete();
      }
    });




    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);
    projectMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        projectHandler.add();
      }
    });
    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list();
      }
    });
    projectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail();
      }
    });
    projectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        projectHandler.update();
      }
    });
    projectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        projectHandler.delete();
      }
    });




    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);
    taskMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        taskHandler.add();
      }
    });
    taskMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        taskHandler.list();
      }
    });
    taskMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail();
      }
    });
    taskMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        taskHandler.update();
      }
    });
    taskMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        taskHandler.delete();
      }
    });

    return mainMenuGroup;  
  }



  // 필요없는 메서드들 다 지우기

  //  static void doBoardMenu() {
  //    while(true) {
  //      System.out.println("[메인/게시판]");
  //      System.out.println("1. 등록");
  //      System.out.println("2. 목록");
  //      System.out.println("3. 상세 보기");
  //      System.out.println("4. 변경");
  //      System.out.println("5. 삭제");
  //      System.out.println("0. 이전메뉴");
  //
  //      int menuNo = Prompt.inputInt("게시판> ");
  //      switch(menuNo) {
  //        case 1 : boardHandler.add(); break;
  //        case 2 : boardHandler.list(); break;
  //        case 3 : boardHandler.detail(); break;
  //        case 4 : boardHandler.update(); break;
  //        case 5 : boardHandler.delete(); break;
  //        case 0 : return ;
  //        default : System.out.println("무효한 메뉴 번호입니다.");
  //      }
  //      System.out.println();
  //    }
  //  }
  //
  //
  //
  //  static void doMemberMenu() {
  //    while(true) {
  //      System.out.println("[메인/회원]");
  //      System.out.println("1. 등록");
  //      System.out.println("2. 목록");
  //      System.out.println("3. 상세 보기");
  //      System.out.println("4. 변경");
  //      System.out.println("5. 삭제");
  //      System.out.println("0. 이전메뉴");
  //
  //      int menuNo = Prompt.inputInt("회원> ");
  //      switch(menuNo) {
  //        case 1 : memberHandler.add(); break;
  //        case 2 : memberHandler.list(); break;
  //        case 3 : memberHandler.detail(); break;
  //        case 4 : memberHandler.update(); break;
  //        case 5 : memberHandler.delete(); break;
  //        case 0 : return;
  //        default : System.out.println("무효한 메뉴 번호입니다.");
  //      }
  //      System.out.println();
  //    }
  //  }
  //
  //
  //
  //  static void doProjectMenu() {
  //    while(true) {
  //      System.out.println("[메인/프로젝트]");
  //      System.out.println("1. 등록");
  //      System.out.println("2. 목록");
  //      System.out.println("3. 상세 보기");
  //      System.out.println("4. 변경");
  //      System.out.println("5. 삭제");
  //      System.out.println("0. 이전메뉴");
  //
  //      int menuNo = Prompt.inputInt("프로젝트> ");
  //      switch(menuNo) {
  //        case 1 : projectHandler.add(); break;
  //        case 2 : projectHandler.list(); break;
  //        case 3 : projectHandler.detail(); break;
  //        case 4 : projectHandler.update(); break;
  //        case 5 : projectHandler.delete(); break;
  //        case 0 : return;
  //        default : System.out.println("무효한 메뉴 번호입니다.");
  //      }
  //      System.out.println();
  //    }
  //  }
  //
  //
  //  static void doTaskMenu() {
  //    while(true) {
  //      System.out.println("[메인/작업]");
  //      System.out.println("1. 등록");
  //      System.out.println("2. 목록");
  //      System.out.println("3. 상세 보기");
  //      System.out.println("4. 변경");
  //      System.out.println("5. 삭제");
  //      System.out.println("0. 이전메뉴");
  //
  //      int menuNo = Prompt.inputInt("작업> ");
  //      switch(menuNo) {
  //        case 1 : taskHandler.add(); break;
  //        case 2 : taskHandler.list(); break;
  //        case 3 : taskHandler.detail(); break;
  //        case 4 : taskHandler.update(); break;
  //        case 5 : taskHandler.delete(); break;
  //        case 0 : return;
  //        default : System.out.println("무효한 메뉴 번호입니다.");
  //      }
  //      System.out.println();
  //    }
  //  }
  //
  //  static int doMainMenu() {
  //    System.out.println("[메인]");
  //    System.out.println("1. 게시판");
  //    System.out.println("2. 회원");
  //    System.out.println("3. 프로젝트");
  //    System.out.println("4. 작업");
  //    System.out.println("0. 종료");
  //    return Prompt.inputInt("메인> "); 
  //  }
}













