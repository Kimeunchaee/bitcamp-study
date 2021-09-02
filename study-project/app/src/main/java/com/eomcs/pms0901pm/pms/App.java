package com.eomcs.pms0901pm.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0901pm.menu.Menu;
import com.eomcs.pms0901pm.menu.MenuGroup;
import com.eomcs.pms0901pm.pms.domain.Board;
import com.eomcs.pms0901pm.pms.domain.Member;
import com.eomcs.pms0901pm.pms.domain.Project;
import com.eomcs.pms0901pm.pms.handler.AuthLoginHandler;
import com.eomcs.pms0901pm.pms.handler.AuthLogoutHandler;
import com.eomcs.pms0901pm.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms0901pm.pms.handler.BoardAddHandler;
import com.eomcs.pms0901pm.pms.handler.BoardDeleteHandler;
import com.eomcs.pms0901pm.pms.handler.BoardDetailHandler;
import com.eomcs.pms0901pm.pms.handler.BoardListHandler;
import com.eomcs.pms0901pm.pms.handler.BoardUpdateHandler;
import com.eomcs.pms0901pm.pms.handler.MemberAddHandler;
import com.eomcs.pms0901pm.pms.handler.MemberDeleteHandler;
import com.eomcs.pms0901pm.pms.handler.MemberDetailHandler;
import com.eomcs.pms0901pm.pms.handler.MemberListHandler;
import com.eomcs.pms0901pm.pms.handler.MemberPromptHandler;
import com.eomcs.pms0901pm.pms.handler.MemberUpdateHandler;
import com.eomcs.pms0901pm.pms.handler.ProjectAddHandler;
import com.eomcs.pms0901pm.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms0901pm.pms.handler.ProjectDetailHandler;
import com.eomcs.pms0901pm.pms.handler.ProjectListHandler;
import com.eomcs.pms0901pm.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms0901pm.pms.handler.TaskAddHandler;
import com.eomcs.pms0901pm.pms.handler.TaskDeleteHandler;
import com.eomcs.pms0901pm.pms.handler.TaskDetailHandler;
import com.eomcs.pms0901pm.pms.handler.TaskListHandler;
import com.eomcs.pms0901pm.pms.handler.TaskUpdateHandler;
import com.eomcs.pms0901pm.util.Prompt;


// 0901pm
// 2. 인스턴스 멤버를 스태틱 멤버로 전환한다
// TaskHandler 에서 prinTasks()변경

// 3. 회원정보를 요구하는 메서드를 별도의 클래스로 분리
// promptXX() 메서드를 별도의 클래스로 만든다
// AbstractMemberHandler 를 복제후 MemberPromptHandler로 만들고
// AbstractMemberHandler 에서는 promptXX() 메서드들을 삭제해준다
// ProjectAddHandler. , ProjectUpdateHandler, TaskAddHandler , TaskUpdateHandler 4개의 클래스에서 사용하므로 가서 수정해주기
// 수정 후 App에 와서 파라미터 수정해주기

// 4. Task에서 project 정보를 불러와 작업번호를 찾는 findByNo()를
// 프로젝트가 직접 관리하도록 Project 도메인으로 옮겨줌
// TaskDetailHandler , TaskUpdateHandler , TaskDeleteHandler 3개의 클래스에서 사용하므로 가서 수정해주기

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();

  BoardAddHandler boardAddHandler = new BoardAddHandler(boardList);
  BoardListHandler boardListHandler = new BoardListHandler(boardList);
  BoardDetailHandler boardDetailHandler = new BoardDetailHandler(boardList);
  BoardUpdateHandler boardUpdateHandler = new BoardUpdateHandler(boardList);
  BoardDeleteHandler boardDeleteHandler = new BoardDeleteHandler(boardList);

  MemberAddHandler memberAddHandler = new MemberAddHandler(memberList);
  MemberListHandler memberListHandler = new MemberListHandler(memberList);
  MemberDetailHandler memberDetailHandler = new MemberDetailHandler(memberList);
  MemberUpdateHandler memberUpdateHandler = new MemberUpdateHandler(memberList);
  MemberDeleteHandler memberDeleteHandler = new MemberDeleteHandler(memberList);
  // 추가
  MemberPromptHandler memberPromptHandler = new MemberPromptHandler(memberList);

  //기존
  //ProjectAddHandler projectAddHandler = new ProjectAddHandler(projectList, memberListHandler);
  //수정
  ProjectAddHandler projectAddHandler = new ProjectAddHandler(projectList, memberPromptHandler);

  ProjectListHandler projectListHandler = new ProjectListHandler(projectList);
  ProjectDetailHandler projectDetailHandler = new ProjectDetailHandler(projectList);

  // 기존
  //ProjectUpdateHandler projectUpdateHandler = new ProjectUpdateHandler(projectList, memberListHandler);
  // 수정
  ProjectUpdateHandler projectUpdateHandler = new ProjectUpdateHandler(projectList, memberPromptHandler);

  ProjectDeleteHandler projectDeleteHandler = new ProjectDeleteHandler(projectList);

  TaskAddHandler taskAddHandler = new TaskAddHandler(projectListHandler);
  TaskListHandler taskListHandler = new TaskListHandler(projectListHandler);
  TaskDetailHandler taskDetailHandler = new TaskDetailHandler(projectListHandler);
  TaskUpdateHandler taskUpdateHandler = new TaskUpdateHandler(projectListHandler);
  TaskDeleteHandler taskDeleteHandler = new TaskDeleteHandler(projectListHandler);

  AuthLoginHandler authLoginHandler = new AuthLoginHandler(memberList);
  AuthLogoutHandler authLogoutHandler = new AuthLogoutHandler();
  AuthUserInfoHandler authUserInfoHandler = new AuthUserInfoHandler();

  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new Menu("로그인", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        authLoginHandler.login(); 
      }
    });

    mainMenuGroup.add(new Menu("내정보", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        authUserInfoHandler.displayLoginUser(); 
      }
    });

    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        authLogoutHandler.logout(); 
      }
    });

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardAddHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardListHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardDetailHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardUpdateHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardDeleteHandler.delete(); 
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberAddHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberListHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberDetailHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberUpdateHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberDeleteHandler.delete(); 
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectAddHandler.add(); 
      }});
    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectListHandler.list(); 
      }});
    projectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectDetailHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectUpdateHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectDeleteHandler.delete(); 
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskAddHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        taskListHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskDetailHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskUpdateHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskDeleteHandler.delete(); 
      }});


    return mainMenuGroup;
  }
}












