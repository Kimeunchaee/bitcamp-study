package com.eomcs.pms0901.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0901.menu.Menu;
import com.eomcs.pms0901.menu.MenuGroup;
import com.eomcs.pms0901.pms.domain.Board;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.pms.domain.Project;
import com.eomcs.pms0901.pms.handler.AuthLoginHandler;
import com.eomcs.pms0901.pms.handler.AuthLogoutHandler;
import com.eomcs.pms0901.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms0901.pms.handler.BoardAddHandler;
import com.eomcs.pms0901.pms.handler.BoardDeleteHandler;
import com.eomcs.pms0901.pms.handler.BoardDetailHandler;
import com.eomcs.pms0901.pms.handler.BoardListHandler;
import com.eomcs.pms0901.pms.handler.BoardUpdateHandler;
import com.eomcs.pms0901.pms.handler.MemberAddHandler;
import com.eomcs.pms0901.pms.handler.MemberDeleteHandler;
import com.eomcs.pms0901.pms.handler.MemberDetailHandler;
import com.eomcs.pms0901.pms.handler.MemberListHandler;
import com.eomcs.pms0901.pms.handler.MemberUpdateHandler;
import com.eomcs.pms0901.pms.handler.ProjectAddHandler;
import com.eomcs.pms0901.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms0901.pms.handler.ProjectDetailHandler;
import com.eomcs.pms0901.pms.handler.ProjectListHandler;
import com.eomcs.pms0901.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms0901.pms.handler.TaskAddHandler;
import com.eomcs.pms0901.pms.handler.TaskDeleteHandler;
import com.eomcs.pms0901.pms.handler.TaskDetailHandler;
import com.eomcs.pms0901.pms.handler.TaskListHandler;
import com.eomcs.pms0901.pms.handler.TaskUpdateHandler;
import com.eomcs.pms0901.util.Prompt;

//0901
// 0. 예습
// App - 게시판메뉴 하위에 검색 메뉴 추가
// BoardHandler - search() 메서드 추가 (`게시글 검색` 명령을 처리)
// 위에 2개 작업을 취소하고 처음부터 만들어보기

// 1. BoardHandler에서 클래스 분리
// 보드 핸들러 클래스를 복사해서 >
// 보드add핸들러, 보드 list핸들러, 보드 detail핸들러, 보드 update핸들러, 보드 dlelte핸들러 생성
// 각각 클래스에 해당되는 메서드남 남기고 지운다

// 2. App에서 각각핸들러 인스턴스 생성
// 2-1. execute() 호출안에서 파라미터명 바꿔주기

// 3. generalization 적용
// 3-1. AbstractBoardHandler 파일 생성 (보드 detail핸들러 복사해서 만들기)
// 3-2. 자식클래스에 extends 해주기 , 생성자 호출 super()로 바꿔주기

// 4. 나머지 핸들러도 generalization를 적용해준다
// 클래스 분리 > 추상클래스 생성 > 각각 클래스에 상속 > app에서 핸들러 인스턴스 생성 >  app에서 execute() 호출안에 파라미터명 바꿔주기

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();

  //  BoardHandler boardHandler = new BoardHandler(boardList);
  //추가
  BoardAddHandler boardAddHandler = new BoardAddHandler(boardList);
  BoardListHandler boardListHandler = new BoardListHandler(boardList);
  BoardDetailHandler boardDetailHandler = new BoardDetailHandler(boardList);
  BoardUpdateHandler boardUpdateHandler = new BoardUpdateHandler(boardList);
  BoardDeleteHandler boardDeleteHandler = new BoardDeleteHandler(boardList);

  //  MemberHandler memberHandler = new MemberHandler(memberList);
  //추가
  MemberAddHandler memberAddHandler = new MemberAddHandler(memberList);
  MemberListHandler memberListHandler = new MemberListHandler(memberList);
  MemberDetailHandler memberDetailHandler = new MemberDetailHandler(memberList);
  MemberUpdateHandler memberUpdateHandler = new MemberUpdateHandler(memberList);
  MemberDeleteHandler memberDeleteHandler = new MemberDeleteHandler(memberList);

  //  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
  //추가
  ProjectAddHandler projectAddHandler = new ProjectAddHandler(projectList, memberListHandler);
  ProjectListHandler projectListHandler = new ProjectListHandler(projectList);
  ProjectDetailHandler projectDetailHandler = new ProjectDetailHandler(projectList);
  ProjectUpdateHandler projectUpdateHandler = new ProjectUpdateHandler(projectList, memberListHandler);
  ProjectDeleteHandler projectDeleteHandler = new ProjectDeleteHandler(projectList);

  //  TaskHandler taskHandler = new TaskHandler(projectHandler);
  //추가
  TaskAddHandler taskAddHandler = new TaskAddHandler(projectListHandler);
  TaskListHandler taskListHandler = new TaskListHandler(projectListHandler);
  TaskDetailHandler taskDetailHandler = new TaskDetailHandler(projectListHandler);
  TaskUpdateHandler taskUpdateHandler = new TaskUpdateHandler(projectListHandler);
  TaskDeleteHandler taskDeleteHandler = new TaskDeleteHandler(projectListHandler);

  //  AuthHandler authHandler = new AuthHandler(memberList);
  //추가
  AuthLoginHandler authLoginHandler = new AuthLoginHandler(memberList);
  AuthLogoutHandler authLogoutHandler = new AuthLogoutHandler(memberList);
  AuthUserInfoHandler authUserInfoHandler = new AuthUserInfoHandler(memberList);

  //------------------------------------------------------------------------------------------------
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
        //authHandler.login(); 
        authLoginHandler.login();
      }
    });

    mainMenuGroup.add(new Menu("내정보", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //authHandler.displayLoginUser(); 
        authUserInfoHandler.displayLoginUser();
      }
    });

    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //authHandler.logout(); 
        authLogoutHandler.logout();
      }
    });

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //기존
        //boardHandler.add(); 
        //수정
        boardAddHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        //기존
        //boardHandler.list(); 
        //수정
        boardListHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        //기존
        //boardHandler.detail(); 
        //수정
        boardDetailHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //기존
        //boardHandler.update(); 
        //수정
        boardUpdateHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //기존
        //boardHandler.delete(); 
        //수정
        boardDeleteHandler.delete(); 
      }});
    //    boardMenu.add(new Menu("검색") {
    //      @Override
    //      public void execute() {
    //        boardHandler.search(); 
    //      }});


    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGOUT) {
      @Override
      public void execute() {
        //memberHandler.add(); 
        memberAddHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        //memberHandler.list(); 
        memberListHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        //memberHandler.detail(); 
        memberDetailHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //memberHandler.update();
        memberUpdateHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //memberHandler.delete();
        memberDeleteHandler.delete();
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //projectListHandler.add(); 
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
        //projectListHandler.detail();
        projectDetailHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //projectListHandler.update();
        projectUpdateHandler.update();
      }});
    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //projectListHandler.delete();
        projectDeleteHandler.delete();
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //taskHandler.add();
        taskAddHandler.add();
      }});
    taskMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        //taskHandler.list();
        taskListHandler.list();
      }});
    taskMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        //taskHandler.detail();
        taskDetailHandler.detail();
      }});
    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //taskHandler.update();
        taskUpdateHandler.update();
      }});
    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        //taskHandler.delete();
        taskDeleteHandler.delete();
      }});


    return mainMenuGroup;
  }
}












