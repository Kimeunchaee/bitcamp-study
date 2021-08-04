package com.eomcs.pms0802;

import com.eomcs.pms0802.handler.BoardHandler1;
import com.eomcs.pms0802.handler.MemberHandler;
import com.eomcs.pms0802.handler.ProjectHandler;
import com.eomcs.pms0802.handler.TaskHandler;
import com.eomcs.pms0802.menu.Menu;
import com.eomcs.pms0802.menu.MenuGroup;
import com.eomcs.pms0802.util.Prompt;

public class App10 {

  // 10) 자료구조

  // <배열 방식의 자료구조 방법>
  // 핸들러 클래스 가서 수정해줌
  // 기존배열의 크기를 늘리기위해
  // 새로운 배열에 기존배열을 복사하고 저장한다
  // 기존 배열을 가비지가 된다

  // <연결리스트 방식의 자료구조 방법 (링크)>
  // 핸들러 패키지에 노드 클래스만들기
  // 핸들러 파일에 노드 코드 추가하면서 메서드들을 수정해준다

  // 우리가 만든 노드파일은 board에서만 사용할수 있다
  //member에 필요한 노드파일, project에 필요한 노드 파일을 각각 만들어줘야한다

  // 그렇게 하면 파일이 많아지고 번거롭기때문에
  // 노드 코드를 복사해서 보드핸들러에 중접클래스,static으로 넣어준다
  // 특정 클래스에서만 사용되는 node이기 때문에 public은 빼주고 자기 자신 클래스에 중첩으로 넣어주는것이다
  // 노트 파일은 삭제

  BoardHandler1 boardHandler = new BoardHandler1();
  MemberHandler memberHandler = new MemberHandler();
  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {

    App10 app = new App10();
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


    boardMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        boardHandler.add();
      }
    });
    boardMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        boardHandler.list();
      }
    });
    boardMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail();
      }
    });
    boardMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        boardHandler.update();
      }
    });
    boardMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        boardHandler.delete();
      }
    });



    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);
    memberMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        memberHandler.add();
      }
    }); 
    memberMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        memberHandler.list();
      }
    });
    memberMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        memberHandler.detail();
      }
    });
    memberMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        memberHandler.update();
      }
    });
    memberMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        memberHandler.delete();
      }
    });




    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);
    projectMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        projectHandler.add();
      }
    });
    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list();
      }
    });
    projectMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        projectHandler.detail();
      }
    });
    projectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        projectHandler.update();
      }
    });
    projectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        projectHandler.delete();
      }
    });




    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);
    taskMenu.add(new Menu ("등록") {
      @Override
      public void execute() {
        taskHandler.add();
      }
    });
    taskMenu.add(new Menu ("목록") {
      @Override
      public void execute() {
        taskHandler.list();
      }
    });
    taskMenu.add(new Menu ("상세보기") {
      @Override
      public void execute() {
        taskHandler.detail();
      }
    });
    taskMenu.add(new Menu ("변경") {
      @Override
      public void execute() {
        taskHandler.update();
      }
    });
    taskMenu.add(new Menu ("삭제") {
      @Override
      public void execute() {
        taskHandler.delete();
      }
    });

    return mainMenuGroup;  
  }
}


