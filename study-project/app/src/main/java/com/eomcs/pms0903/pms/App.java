package com.eomcs.pms0903.pms;

import static com.eomcs.pms0903.menu.Menu.ACCESS_ADMIN;
import static com.eomcs.pms0903.menu.Menu.ACCESS_GENERAL;
import static com.eomcs.pms0903.menu.Menu.ACCESS_LOGOUT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0903.menu.Menu;
import com.eomcs.pms0903.menu.MenuGroup;
import com.eomcs.pms0903.pms.domain.Board;
import com.eomcs.pms0903.pms.domain.Member;
import com.eomcs.pms0903.pms.domain.Project;
import com.eomcs.pms0903.pms.handler.AuthLoginHandler;
import com.eomcs.pms0903.pms.handler.AuthLogoutHandler;
import com.eomcs.pms0903.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms0903.pms.handler.BoardAddHandler;
import com.eomcs.pms0903.pms.handler.BoardDeleteHandler;
import com.eomcs.pms0903.pms.handler.BoardDetailHandler;
import com.eomcs.pms0903.pms.handler.BoardListHandler;
import com.eomcs.pms0903.pms.handler.BoardSearchHandler;
import com.eomcs.pms0903.pms.handler.BoardUpdateHandler;
import com.eomcs.pms0903.pms.handler.Command;
import com.eomcs.pms0903.pms.handler.MemberAddHandler;
import com.eomcs.pms0903.pms.handler.MemberDeleteHandler;
import com.eomcs.pms0903.pms.handler.MemberDetailHandler;
import com.eomcs.pms0903.pms.handler.MemberListHandler;
import com.eomcs.pms0903.pms.handler.MemberPrompt;
import com.eomcs.pms0903.pms.handler.MemberUpdateHandler;
import com.eomcs.pms0903.pms.handler.ProjectAddHandler;
import com.eomcs.pms0903.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms0903.pms.handler.ProjectDetailHandler;
import com.eomcs.pms0903.pms.handler.ProjectListHandler;
import com.eomcs.pms0903.pms.handler.ProjectPrompt;
import com.eomcs.pms0903.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms0903.pms.handler.TaskAddHandler;
import com.eomcs.pms0903.pms.handler.TaskDeleteHandler;
import com.eomcs.pms0903.pms.handler.TaskDetailHandler;
import com.eomcs.pms0903.pms.handler.TaskListHandler;
import com.eomcs.pms0903.pms.handler.TaskUpdateHandler;
import com.eomcs.pms0903.util.Prompt;


// 0903
// 비트 연산자를 이용하여 비트를 다루기
// 비트 연산자를 이용하여 접근 권한 통제에 활용

// 1) 메뉴의 접근 범위를 지정할 상수와 생성자를 정의
// Menu : 기존의 상수 값과 필드를 변경
// MenuGroup : 생성자를 추가

// 2) 로그인/로그아웃 할 때 사용자의 권한을 설정
// AuthLoginHandler 클래스 변경 : 사용자 접근 수준을 설정할 필드와 메서드를 추가
// AuthLogoutHandler : 로그아웃 했을 때 사용자 접근 권한을 줄이기

// 3) 메뉴를 구성할 때 접근 범위를 설정
// App : createXxxMenu() 변경, 새로운 규칙에 따라 접근 범위를 설정


public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();


  //추가
  // 해시맵을 사용하면 객체를 관리하기 쉽다
  // 생성자에서 사용
  HashMap<String,Command> commandMap = new HashMap<>();

  MemberPrompt memberPrompt = new MemberPrompt(memberList);
  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);


  //이너클래스(논스태틱중첩 클래스) 추가
  // Menu 추상 클래스를 상속 받아서 PMS시스템에 맞게 기능을 추가한다.
  class MenuItem extends Menu {

    // inner 클래스는 컴파일할 때 바깥 클래스의 인스턴스 주소를 저장할 필드가 자동 생성된다.
    // 개발자가 따로 선언한 필요가 없다.
    // 예) App this$0

    // 1) 메뉴의 ID를 저장할 필드를 선언한다.
    // - 이 메뉴 아이디는 커맨드 객체를 찾을 때 사용할 것이다.
    String menuId;


    // inner 클래스의 생성자를 컴파일 할 때
    // 바깥 클래스의 인스턴스를 받는 파라미터가 자동으로 추가된다.
    // 개발자가 따로 파라미터를 추가할 필요가 없다.
    //    public MenuItem(/*App outer,*/String title, String menuId) {
    //      this(/*outer,*/ title, ENABLE_ALL, menuId*/); // 다른 생성자와 코드가 중복된다면 다른 생성자를 호출하라.
    //      this.menuId = menuId;
    //      //this$0 = outer; 자동으로 생성됨
    //    }


    // enableState를 accessScope로 바꿔줌 
    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      // inner 클래스는 바깥 클래스의 인스턴스를 내부 필드로 갖고 있기 때문에
      // inner 클래스의 멤버를 마음대로 사용할 수 있다.

      // 메뉴가 실행될 때 메뉴 아이디를 사용하여 Map에서 Command 객체를 찾아 실행한다.
      Command command = commandMap.get(menuId);
      command.execute();

    }
  }

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  // 생성자 준비
  public App() {
    commandMap.put("/board/app", new BoardAddHandler(boardList));
    commandMap.put("/board/list", new BoardListHandler(boardList));
    commandMap.put("/board/detail", new BoardDetailHandler(boardList));
    commandMap.put("/board/update", new BoardUpdateHandler(boardList));
    commandMap.put("/board/delete", new BoardDeleteHandler(boardList));
    commandMap.put("/board/search", new BoardSearchHandler(boardList));

    commandMap.put("/member/app", new MemberAddHandler(memberList));
    commandMap.put("/member/list", new MemberListHandler(memberList));
    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));

    commandMap.put("/project/app", new ProjectAddHandler(projectList, memberPrompt));
    commandMap.put("/project/list", new ProjectListHandler(projectList));
    commandMap.put("/project/detail", new ProjectDetailHandler(projectList));
    commandMap.put("/project/update", new ProjectUpdateHandler(projectList, memberPrompt));
    commandMap.put("/project/delete", new ProjectDeleteHandler(projectList));

    commandMap.put("/task/app", new TaskAddHandler(projectPrompt));
    commandMap.put("/task/list", new TaskListHandler(projectPrompt));
    commandMap.put("/task/detail", new TaskDetailHandler(projectPrompt));
    commandMap.put("/task/update", new TaskUpdateHandler(projectPrompt));
    commandMap.put("/task/delete", new TaskDeleteHandler(projectPrompt));

    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
    commandMap.put("/auth/logout", new AuthLogoutHandler());
    commandMap.put("/auth/userinfo", new AuthUserInfoHandler());

  }

  void service() {
    createMenuItem().execute();
    Prompt.close();
  }


  //어떤 메뉴 아이디를 실행할지 Command 메뉴에서 이미 코드를 다 짰기 때문에
  // 사용할 어떤 메뉴를 Command 객체를 뒤에 저장해 준다
  // 이제 ACCESS_LOGOUT, ACCESS_GENERAL , ACCESS_GENERAL 로 바꿔줌
  Menu createMenuItem() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));
    mainMenuGroup.add(new MenuItem("내 정보", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());
    mainMenuGroup.add(createAdminMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("게시판");

    boardMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/board/add"));
    boardMenu.add(new MenuItem("목록", "/board/list"));
    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
    boardMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/board/update"));
    boardMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/board/delete"));
    boardMenu.add(new MenuItem("검색", "/board/search"));

    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");

    memberMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/member/add"));
    memberMenu.add(new MenuItem("목록", "/member/list"));
    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
    memberMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/member/update"));
    memberMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/member/delete"));

    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("프로젝트");

    projectMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/project/add"));
    projectMenu.add(new MenuItem("목록", "/project/list"));
    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
    projectMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/project/update"));
    projectMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/project/delete"));

    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("작업");

    taskMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/task/add"));
    taskMenu.add(new MenuItem("목록", "/task/list"));
    taskMenu.add(new MenuItem("상세보기", "task/detail"));
    taskMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/task/update"));
    taskMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/task/delete"));

    return taskMenu;
  }

  // 테스트용 - 메뉴 통제가 가능한지 확인만
  private Menu createAdminMenu() {
    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    adminMenu.add(new MenuItem("회원 등록", "/member/add"));
    adminMenu.add(new MenuItem("프로젝트 등록", "/project/add"));
    adminMenu.add(new MenuItem("작업 등록", "task/add"));
    adminMenu.add(new MenuItem("게시글 등록", "/board/add"));
    return adminMenu;
  }
}


// createMenuItem에서 add()가 실행될때 바로 commandMap.put(/task/add) 명령이 실행됨
//  Menu createMenu() {
//    MenuGroup mainMenuGroup = new MenuGroup("메인");
//    mainMenuGroup.setPrevMenuTitle("종료");
//
//    mainMenuGroup.add(new Menu("로그인", Menu.ENABLE_LOGOUT) {
//      @Override
//      public void execute() {
//        //authLoginHandler.login();
//        authLoginHandler.execute();
//      }
//    });
//
//    mainMenuGroup.add(new Menu("내정보", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //authUserInfoHandler.displayLoginUser();
//        authUserInfoHandler.execute();
//      }
//    });
//
//    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //authLogoutHandler.logout();
//        authLogoutHandler.execute();
//      }
//    });
//
//    MenuGroup boardMenu = new MenuGroup("게시판");
//    mainMenuGroup.add(boardMenu);
//
//    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //boardAddHandler.add(); 
//        boardAddHandler.execute(); 
//      }});
//    boardMenu.add(new Menu("목록") {
//      @Override
//      public void execute() {
//        //boardListHandler.list(); 
//        boardListHandler.execute(); 
//      }});
//    boardMenu.add(new Menu("상세보기") {
//      @Override
//      public void execute() {
//        //boardDetailHandler.detail(); 
//        boardDetailHandler.execute(); 
//      }});
//    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //boardUpdateHandler.update();
//        boardUpdateHandler.execute(); 
//      }});
//    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //boardDeleteHandler.delete();
//        boardDeleteHandler.execute(); 
//      }});
//    boardMenu.add(new Menu("검색") {
//      @Override
//      public void execute() {
//        //boardSearchHandler.search();
//        boardSearchHandler.execute(); 
//      }});
//
//    MenuGroup memberMenu = new MenuGroup("회원");
//    mainMenuGroup.add(memberMenu);
//
//    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //memberAddHandler.add(); 
//        memberAddHandler.execute(); 
//      }});
//    memberMenu.add(new Menu("목록") {
//      @Override
//      public void execute() {
//        //memberListHandler.list(); 
//        memberListHandler.execute(); 
//      }});
//    memberMenu.add(new Menu("상세보기") {
//      @Override
//      public void execute() {
//        //memberDetailHandler.detail(); 
//        memberDetailHandler.execute(); 
//      }});
//    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //memberUpdateHandler.update();
//        memberUpdateHandler.execute();
//      }});
//    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //memberDeleteHandler.delete();
//        memberDeleteHandler.execute();
//      }});
//
//    MenuGroup projectMenu = new MenuGroup("프로젝트");
//    mainMenuGroup.add(projectMenu);
//
//    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //projectAddHandler.add(); 
//        projectAddHandler.execute();
//      }});
//    projectMenu.add(new Menu("목록") {
//      @Override
//      public void execute() {
//        //projectListHandler.list();
//        projectListHandler.execute();
//      }});
//    projectMenu.add(new Menu("상세보기") {
//      @Override
//      public void execute() {
//        //projectDetailHandler.detail();
//        projectDetailHandler.execute();
//      }});
//    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //projectUpdateHandler.update();
//        projectUpdateHandler.execute();
//      }});
//    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //projectDeleteHandler.delete();
//        projectDeleteHandler.execute();
//      }});
//
//    MenuGroup taskMenu = new MenuGroup("작업");
//    mainMenuGroup.add(taskMenu);
//
//    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //taskAddHandler.add();
//        taskAddHandler.execute();
//      }});
//    taskMenu.add(new Menu("목록") {
//      @Override
//      public void execute() {
//        //taskListHandler.list();
//        taskListHandler.execute();
//      }});
//    taskMenu.add(new Menu("상세보기") {
//      @Override
//      public void execute() {
//        //taskDetailHandler.detail();
//        taskDetailHandler.execute();
//      }});
//    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //taskUpdateHandler.update();
//        taskUpdateHandler.execute();
//      }});
//    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
//      @Override
//      public void execute() {
//        //taskDeleteHandler.delete();
//        taskDeleteHandler.execute();
//      }});
//    return mainMenuGroup;
//  }
}
