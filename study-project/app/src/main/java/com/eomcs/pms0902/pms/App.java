package com.eomcs.pms0902.pms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0902.menu.Menu;
import com.eomcs.pms0902.menu.MenuGroup;
import com.eomcs.pms0902.pms.domain.Board;
import com.eomcs.pms0902.pms.domain.Member;
import com.eomcs.pms0902.pms.domain.Project;
import com.eomcs.pms0902.pms.handler.AuthLoginHandler;
import com.eomcs.pms0902.pms.handler.AuthLogoutHandler;
import com.eomcs.pms0902.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms0902.pms.handler.BoardAddHandler;
import com.eomcs.pms0902.pms.handler.BoardDeleteHandler;
import com.eomcs.pms0902.pms.handler.BoardDetailHandler;
import com.eomcs.pms0902.pms.handler.BoardListHandler;
import com.eomcs.pms0902.pms.handler.BoardSearchHandler;
import com.eomcs.pms0902.pms.handler.BoardUpdateHandler;
import com.eomcs.pms0902.pms.handler.Command;
import com.eomcs.pms0902.pms.handler.MemberAddHandler;
import com.eomcs.pms0902.pms.handler.MemberDeleteHandler;
import com.eomcs.pms0902.pms.handler.MemberDetailHandler;
import com.eomcs.pms0902.pms.handler.MemberListHandler;
import com.eomcs.pms0902.pms.handler.MemberPrompt;
import com.eomcs.pms0902.pms.handler.MemberUpdateHandler;
import com.eomcs.pms0902.pms.handler.ProjectAddHandler;
import com.eomcs.pms0902.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms0902.pms.handler.ProjectDetailHandler;
import com.eomcs.pms0902.pms.handler.ProjectListHandler;
import com.eomcs.pms0902.pms.handler.ProjectPrompt;
import com.eomcs.pms0902.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms0902.pms.handler.TaskAddHandler;
import com.eomcs.pms0902.pms.handler.TaskDeleteHandler;
import com.eomcs.pms0902.pms.handler.TaskDetailHandler;
import com.eomcs.pms0902.pms.handler.TaskListHandler;
import com.eomcs.pms0902.pms.handler.TaskUpdateHandler;
import com.eomcs.pms0902.util.Prompt;

//0902

//Command 인터페이스 생성 > execute() 오바리이딩 : 실행 호출 규칙을 통일한다
//ProjectPrompt 클래스 추가 - promptProject() 메서드를 가져온다.
//HashMap 사용 > Menu 객체에서 Map 객체에 들어있는 Command 구현체를 사용하도록 변경한다
//inner class 정의 : `Menu`를 구현한 inner class `MenuItem`을 정의
// 메뉴를 실행할 때 `Map`에서 `Command` 객체를 찾아 실행한다.
// - createMenu() 변경 : 메뉴 객체를 만들 때 MenuItem 을 사용
// - MenuItem 객체를 만들 때 메뉴 아이디를 지정
// - 메뉴 아이디는 해당 메뉴를 처리할 커맨드 객체의 key 와 일치해야 한다.

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
    public MenuItem(/*App outer,*/String title, String menuId) {
      this(/*outer,*/ title, ENABLE_ALL, menuId); // 다른 생성자와 코드가 중복된다면 다른 생성자를 호출하라.
      this.menuId = menuId;
      //this$0 = outer; 자동으로 생성됨
    }

    public MenuItem(String title, int enableState, String menuId) {
      super(title, enableState);
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

  Menu createMenuItem() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", Menu.ENABLE_LOGOUT, "/auth/login)"));
    mainMenuGroup.add(new MenuItem("내정보", Menu.ENABLE_LOGIN, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("로그아웃", Menu.ENABLE_LOGIN, "/auth/logout"));

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new MenuItem("등록", Menu.ENABLE_LOGIN, "/board/add"));
    boardMenu.add(new MenuItem("목록", "/board/list"));
    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
    boardMenu.add(new MenuItem("변경", Menu.ENABLE_LOGIN, "/board/update"));
    boardMenu.add(new MenuItem("삭제", Menu.ENABLE_LOGIN, "/board/delete"));
    boardMenu.add(new MenuItem("검색", "/board/search"));

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new MenuItem("등록", Menu.ENABLE_LOGIN, "/member/add"));
    memberMenu.add(new MenuItem("목록", "/member/list"));
    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
    memberMenu.add(new MenuItem("변경", "/member/update"));
    memberMenu.add(new MenuItem("삭제", "/member/delete"));

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new MenuItem("등록", Menu.ENABLE_LOGIN, "/project/add"));
    projectMenu.add(new MenuItem("목록", "/project/list"));
    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
    projectMenu.add(new MenuItem("변경", Menu.ENABLE_LOGIN, "/project/update"));
    projectMenu.add(new MenuItem("삭제", Menu.ENABLE_LOGIN, "/project/delete"));

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new MenuItem("등록", Menu.ENABLE_LOGIN, "/task/add"));
    taskMenu.add(new MenuItem("목록", "/task/list"));
    taskMenu.add(new MenuItem("상세보기", "/task/detail"));
    taskMenu.add(new MenuItem("변경", Menu.ENABLE_LOGIN, "/task/update"));
    taskMenu.add(new MenuItem("삭제", Menu.ENABLE_LOGIN, "/task/delete"));


    return mainMenuGroup;
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
