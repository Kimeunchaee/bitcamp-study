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

    ProjectHandler projectHandler = new ProjectHandler(memberHandler);
    // 프로젝트핸들러의 인스턴스를 만들때  멤버핸들러 인스턴스 변수를
    // 필수로 사용한다 (강제시킨다) > 생성자 문법을 쓰는이유 : 반드시 그 값을 사용하도록 만들기 위해!


    //projectHandler.memberHandler = memberHandler;
    // 프로젝트 핸들러의 메서드가 사용할 의존 객체를 인스턴스 변수에 미리 주입한다
    // 메서드를 호출할때마다 주입하는것이 아니라 미리 주입해놓는것이다
    // 2. 생성자 선언 후에는 필요없는 코드
    //생성자를 통해서만 의존객체를 접근할수 있도록 했기떄문에

    // projectHandler의 메서드가 사용할 의존 객체를 주입하지 않는다면?
    // 그 의존 객체를 사용하는 메서드르 호출할때 실행오류가 발생할 것이다.
    // 프로젝트핸들러의 인스턴스를 생성할때 의존객체를 반드시 주입하도록
    // 생성자를 선언한다

    TaskHandler taskHandler = new TaskHandler(memberHandler);   // 의존객체 주입을 강제함

    //taskHandler.memberHandler = memberHandler;
    // 테스크 핸들러의 메서드가 사용할 의존 객체를 인스턴스 변수에 미리 주입한다
    // 메서드를 호출할때마다 주입하는것이 아니라 미리 주입해놓는것이다
    // 2. 생성자 선언 후에는 필요없는 코드
    //생성자를 통해서만 의존객체를 접근할수 있도록 했기떄문에


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












