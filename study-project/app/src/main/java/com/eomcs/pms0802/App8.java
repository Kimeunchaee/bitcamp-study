package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.menu.Menu;
import com.eomcs.pms0802.menu.MenuGroup;
import com.eomcs.pms0802.util.Prompt;

public class App8 {

  // 8) 익명클래스 만들기


  static BoardHandler boardHandler = new BoardHandler();
  static MemberHandler memberHandler = new MemberHandler();
  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {

    Menu mainMenu = createMenu();
    mainMenu.execute();
    Prompt.close();


  }

  //--------------------------------------
  static Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");


    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);
    // 로컬클래스 복붙해옴 (BoardAddMenu클래스는 삭제)
    // App에서만 사용하는 클래스는 따로 만들필요없이
    // 같은 클래스안에 익명클래스로 만듦
    // BoardHandler boardHandler 받을 필요없으므로 삭제
    // 클래스 이름 지우기

    //  public class BoardAddMenu extends Menu {
    //    BoardHandler boardHandler;
    //    public BoardAddMenu(BoardHandler boardHandler) {
    //      super("등록");
    //      this.boardHandler = boardHandler;
    //    }
    //    @Override
    //    public void execute() {
    //      boardhandler.add();
    //    }
    //  }

    // 중첩클래스를 사용하기때문에 App클래스의 메소드를
    //자유롭게 사용할 수 있다
    // 0. boardMenu.add(new BoardAddMenu()); 추가
    // 1. BoardHandler boardhandler 패키지멤버일때 받은 값은 필요없으므로 지워준다
    // 2. 중첩클래스일 경우에는 이름이 필요없다(익명클래스로 바꿔줌) > public class extends 도 다 빼준다
    // 3. 익명클래스로 만들어짐과 동시에 생성자를 만들어줘야한다 Menu앞에 new넣기 
    // Menu m = new Menu 으로 바꿔주는데 m 파라미터를 딱 한번만 사용하므로
    // 지정해주지않고 (지정해줬던거 삭제) 바로 boardMenu.add()메서드안에 넣어줌
    // 4. 수퍼클래스의 생성자를 호출할수없으므로 삭제함, super("등록") 은 new Menu ("등록") 으로 바꿔줌
    // 5. 지금까지 수정한 값을 //boardMenu.add(new BoardAddMenu(boardHandler)); 이 코드에서
    // boardMenu.add (  여기에 ) 넣어주는걸로 수정해준다

    // 이제 ProjectListMenu.... 모든 클래스파일이 필요없게 된다

    boardMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        boardHandler.add();
      }
    });
    //boardMenu.add(new BoardAddMenu(boardHandler));


    boardMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        boardHandler.list();
      }
    });
    //boardMenu.add(new BoardListMenu(boardHandler));


    boardMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail();
      }
    });
    //boardMenu.add(new BoardDetailMenu(boardHandler));


    boardMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        boardHandler.update();
      }
    });
    //boardMenu.add(new BoardUpdateMenu(boardHandler));


    boardMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        boardHandler.delete();
      }
    });
    //boardMenu.add(new BoardDeleteMenu(boardHandler));


    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);
    memberMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        memberHandler.add();
      }}); 
    memberMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        memberHandler.list();
      }});
    memberMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail();
      }});
    memberMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        memberHandler.update();
      }});
    memberMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        memberHandler.delete();
      }});




    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);
    projectMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        projectHandler.add();
      }});
    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list();
      }});
    projectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail();
      }});
    projectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        projectHandler.update();
      }});
    projectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        projectHandler.delete();
      }});




    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);
    taskMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        taskHandler.add();
      }});
    taskMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        taskHandler.list();
      }});
    taskMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail();
      }});
    taskMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        taskHandler.update();
      }});
    taskMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        taskHandler.delete();
      }});

    return mainMenuGroup;  
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

  static int doMainMenu() {
    System.out.println("[메인]");
    System.out.println("1. 게시판");
    System.out.println("2. 회원");
    System.out.println("3. 프로젝트");
    System.out.println("4. 작업");
    System.out.println("0. 종료");
    return Prompt.inputInt("메인> "); 
  }
}













