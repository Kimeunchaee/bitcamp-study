package com.eomcs.pms.pms0726;

import com.eomcs.pms.pms0726.handler.BoardHandler;
import com.eomcs.pms.pms0726.handler.MemberHandler;
import com.eomcs.pms.pms0726.handler.ProjectHandler;
import com.eomcs.pms.pms0726.handler.TaskHandler;
import com.eomcs.pms.pms0726.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();

    ProjectHandler projectHandler = new ProjectHandler();
    projectHandler.memberHandler = memberHandler;
    // 프로젝트 핸들러의 메서드가 사용할 의존 객체를 인스턴스 변수에 미리 주입한다
    // 메서드를 호출할때마다 주입하는것이 아니라 미리 주입해놓는것이다

    TaskHandler taskHandler = new TaskHandler();
    taskHandler.memberHandler = memberHandler;
    // 테스크 핸들러의 메서드가 사용할 의존 객체를 인스턴스 변수에 미리 주입한다
    // 메서드를 호출할때마다 주입하는것이 아니라 미리 주입해놓는것이다


    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/member/detail")) {
        memberHandler.detail();

      } else if (input.equals("/member/update")) {
        memberHandler.update();

      } else if (input.equals("/member/delete")) {
        memberHandler.delete();

      }  else if (input.equals("/project/add")) {
        // projectHandler.add(memberHandler);
        // add 메서드가 사용할 의존 객체를 미리 주입했기때문에
        // 이제 파라미터로 전달할 필요가 없다.
        projectHandler.add();


      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/project/detail")) {
        projectHandler.detail();

      }  else if (input.equals("/project/update")) {
        //projectHandler.update(memberHandler);
        projectHandler.update();

      }  else if (input.equals("/project/delete")) {
        projectHandler.delete();

      }  else if (input.equals("/task/add")) {
        //taskHandler.add(memberHandler);
        taskHandler.add();

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      }  else if (input.equals("/task/detail")) {
        taskHandler.detail();

      }  else if (input.equals("/task/update")) {
        //taskHandler.update(memberHandler);
        taskHandler.update();

      }  else if (input.equals("/task/delete")) {
        taskHandler.delete();

      }  else if (input.equals("/board/add")) {
        boardHandler.add();

      }  else if (input.equals("/board/list")) {
        boardHandler.list();

      }  else if (input.equals("/board/detail")) {
        boardHandler.detail();

      }  else if (input.equals("/board/update")) {
        boardHandler.update();

      }  else if (input.equals("/board/delete")) {
        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}












