package com.eomcs.pms0805;

import com.eomcs.pms0805.handler.BoardHandler;
import com.eomcs.pms0805.handler.MemberHandler;
import com.eomcs.pms0805.handler.ProjectHandler;
import com.eomcs.pms0805.handler.TaskHandler;
import com.eomcs.pms0805.menu.Menu;
import com.eomcs.pms0805.menu.MenuGroup;
import com.eomcs.pms0805.util.Prompt;


// 08-d 를 가지고 10-a로 수정
// 핸들러를 역할별로 두개로 나눈다 (High Cohesion) 
// 교체와 유지보수가 쉽다
// **핸들러 : UI 처리
// **리스트 : 데이터처리

// GRASP : OOP기초 설계 패턴
// 에 맞게 핸들러와 리스트를 수정해주고
// APP에 와서 수정

public class App {

  BoardHandler boardHandler = new BoardHandler();
  MemberHandler memberHandler = new MemberHandler();

  //memberhandler.getMemberList(); 안됨
  // 클래스에서는 선언만 할수 있기 때문에

  // memberHandler 에서 호출했던걸 .getMemberList 메서드 호출로 바꿔줌
  // 기존코드 ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  ProjectHandler projectHandler = new ProjectHandler(memberHandler.getMemberList());

  //memberHandler 에서 호출했던걸 .getMemberList 메서드 호출로 바꿔줌
  // 기존코드 TaskHandler taskHandler = new TaskHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler.getMemberList());



  //App생성자 만들어서
  public App() {
    //memberhandler.memberList = null; 이렇게 마음대로 바꾸는걸 막기위해
    //memberList을 사용하려면 getter를 사용하도록한다


  }


  public static void main(String[] args) {
    App app = new App();
    app.service();
  }

  void service() {
    //    Menu mainMenu = createMenu();
    //    mainMenu.execute();
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












