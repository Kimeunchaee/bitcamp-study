package com.eomcs.pms0819;

import com.eomcs.pms0819.handler.ArrayList;
import com.eomcs.pms0819.handler.BoardHandler;
import com.eomcs.pms0819.handler.LinkedList;
import com.eomcs.pms0819.handler.List;
import com.eomcs.pms0819.handler.MemberHandler;
import com.eomcs.pms0819.handler.ProjectHandler;
import com.eomcs.pms0819.handler.TaskHandler;
import com.eomcs.pms0819.menu.Menu;
import com.eomcs.pms0819.menu.MenuGroup;
import com.eomcs.pms0819.util.Prompt;

// list에 공통변수 size 추가
// arrylist 와 linkedlist에서 오버리이딩 하기 > 하나하나 넣어서 구현하는것보다
// 중간에 추상클래스를 만들어서 인터페이스의 일부를 미리 구현해주고
// 이 추상클래스로 서브클래스를 구현하면 서브클래스를 만들때 편하다

public class App {

  List boardList = new ArrayList();
  List memberList = new LinkedList();
  List projectList = new ArrayList();
  List taskList = new LinkedList();

  BoardHandler boardHandler = new BoardHandler(boardList);
  MemberHandler memberHandler = new MemberHandler(memberList);
  ProjectHandler projectHandler = new ProjectHandler(projectList, memberHandler);
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



    MenuGroup mg1 = new MenuGroup("관리");
    mainMenuGroup.add(mg1);

    MenuGroup mg2 = new MenuGroup("게시글 관리");
    mg1.add(mg2);

    MenuGroup mg3 = new MenuGroup("관리");
    mg2.add(mg3);

    return mainMenuGroup;
  }
}












