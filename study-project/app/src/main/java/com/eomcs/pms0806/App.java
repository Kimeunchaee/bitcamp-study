package com.eomcs.pms0806;

import com.eomcs.pms0806.handler.ArrayList;
import com.eomcs.pms0806.handler.BoardHandler;
import com.eomcs.pms0806.handler.LinkedList;
import com.eomcs.pms0806.handler.List;
import com.eomcs.pms0806.handler.MemberHandler;
import com.eomcs.pms0806.handler.ProjectHandler;
import com.eomcs.pms0806.handler.TaskHandler;
import com.eomcs.pms0806.menu.Menu;
import com.eomcs.pms0806.menu.MenuGroup;
import com.eomcs.pms0806.util.Prompt;

public class App {

  // 2.
  //BoardHandler 에 생성자를 만들어줬는데 기존코드는
  // () 에 객체가 아무것도 없어서 오류뜸
  //BoardHandler boardHandler = new BoardHandler();

  // 보드핸들러에서 만들어준 생성자와 똑같이 (List boardList)를 넣어줘야하는데
  // List는 추상클래스여서 인스턴스를 만들수없음
  // 서브클래스인 ArrayList()를 불러와서 new로 생성해줌
  // (추상클래스를 상속받은 서브클래스 아무거나 불러와서 인스턴스를 만들수 있다)
  // 보드핸들러에서 List boardList; 만 선언해서 생성자를 만들었기때문에
  // App에서 의존객체(new ArrayList, new LinkedList)를 교체하기가 쉽다
  List boardList = new ArrayList();
  BoardHandler boardHandler = new BoardHandler(boardList);


  // 3.
  // 기존 MemberHandler memberHandler = new MemberHandler();
  List memberList = new LinkedList();
  MemberHandler memberHandler = new MemberHandler(memberList);


  // 1.
  // ProjectHandler projectHandler = new ProjectHandler(memberHandler.getMemberList());
  // TaskHandler taskHandler = new TaskHandler(memberHandler.getMemberList());
  // get메서드를 사용하지 않으므로 다시 핸들러로 바꾸기
  // 수정 ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  // 수정 TaskHandler taskHandler = new TaskHandler(memberHandler);


  //4.
  // 기존 ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  List projectList = new LinkedList();
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);


  //5.
  // 기존 TaskHandler taskHandler = new TaskHandler(memberHandler);
  List taskList = new LinkedList();
  TaskHandler taskHandler = new TaskHandler(taskList, memberHandler);


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

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new Menu("등록") {
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
    boardMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete(); 
      }});

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록") {
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
    memberMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        memberHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        memberHandler.delete(); 
      }});

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록") {
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

    taskMenu.add(new Menu("등록") {
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
    taskMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        taskHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        taskHandler.delete(); 
      }});

    return mainMenuGroup;
  }
}












