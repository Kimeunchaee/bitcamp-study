package com.eomcs.pms0820pm.pms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0820pm.menu.Menu;
import com.eomcs.pms0820pm.menu.MenuGroup;
import com.eomcs.pms0820pm.pms.domain.Board;
import com.eomcs.pms0820pm.pms.domain.Member;
import com.eomcs.pms0820pm.pms.domain.Project;
import com.eomcs.pms0820pm.pms.domain.Task;
import com.eomcs.pms0820pm.pms.handler.BoardHandler;
import com.eomcs.pms0820pm.pms.handler.MemberHandler;
import com.eomcs.pms0820pm.pms.handler.ProjectHandler;
import com.eomcs.pms0820pm.pms.handler.TaskHandler;
import com.eomcs.pms0820pm.util.Prompt;


// 0820
//### 11-b. 자료 구조 다루기 : 리팩토링 - 클래스 및 패키지 이동
//### 11-c. 자료 구조 다루기 : 제네릭이 필요한 이유와 사용법

// 0820 pm
// ### 11-d. 자료 구조 다루기 : 자바 API

// 기존 컬렉션 클래스를 자바에서 기본으로 제공하는 컬렉션 API로 교체한다
// List / AbstractList / ArrayList / LinkedList / Stack 삭제함
// ctrl + Shift + o 단축키로 import하기 (기존에 자바에서 제공하는 파일로)

public class App {

  List<Board> boardList = new ArrayList<>();      
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();
  List<Task> taskList = new LinkedList<>();

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

    MenuGroup mg1 = new MenuGroup("관리1");
    mainMenuGroup.add(mg1);

    MenuGroup mg2 = new MenuGroup("관리2");
    mg1.add(mg2);

    MenuGroup mg3 = new MenuGroup("관리3");
    mg2.add(mg3);

    return mainMenuGroup;
  }
}











