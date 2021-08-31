package com.eomcs.pms0831.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0830.menu.Menu;
import com.eomcs.pms0830.menu.MenuGroup;
import com.eomcs.pms0830.pms.domain.Board;
import com.eomcs.pms0830.pms.domain.Member;
import com.eomcs.pms0830.pms.domain.Project;
import com.eomcs.pms0830.pms.domain.Task;
import com.eomcs.pms0830.pms.handler.AuthHandler;
import com.eomcs.pms0830.pms.handler.BoardHandler;
import com.eomcs.pms0830.pms.handler.MemberHandler;
import com.eomcs.pms0830.pms.handler.ProjectHandler;
import com.eomcs.pms0830.pms.handler.TaskHandler;
import com.eomcs.pms0830.util.Prompt;

// 0831
// 메뉴 그룹 리팩토링
// AuthHandler 수정
// App수정

// 클래스간의 포함관계로 수정
// 보드,멤버,프로젝트,테스크 도메인 수정
// 보드,멤버,프로젝트,테스크 핸들러 수정
public class App {

  List<Board> boardList = new ArrayList<>();      
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();
  List<Task> taskList = new LinkedList<>();

  BoardHandler boardHandler = new BoardHandler(boardList);
  MemberHandler memberHandler = new MemberHandler(memberList);
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
  TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);
  //추가
  AuthHandler authHandler = new AuthHandler(memberList); // 멤버핸들러와 받아오는 리스트와 같음


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

    // 로그인 기능 추가
    mainMenuGroup.add(new Menu("로그인" , Menu.ENABLE_LOGOUT) {   //로그아웃 상태일때만 로그인메뉴가 활성화됨
      @Override
      public void execute() {
        authHandler.login();
      }});


    // 내정보 추가
    mainMenuGroup.add(new Menu("내정보" , Menu.ENABLE_LOGIN) {   //로그인 상태일때만 내정보메뉴가 활성화됨
      @Override
      public void execute() {
        authHandler.displayLoginUser();
      }});

    // 로그아웃 추가
    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {    //로그인 상태일때만 로그아웃메뉴가 활성화됨
      @Override
      public void execute() {
        authHandler.logout();
      }});



    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);
    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardHandler.add(); 
      }});
    boardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});






    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);
    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경" , Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});




    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);
    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
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
    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        projectHandler.delete(); 
      }});




    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);
    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});

    MenuGroup mg1 = new MenuGroup("관리자");
    mainMenuGroup.add(mg1);

    MenuGroup mg2 = new MenuGroup("관리4");
    mg1.add(mg2);

    MenuGroup mg3 = new MenuGroup("관리3");
    mg2.add(mg3);

    return mainMenuGroup;
  }
}












