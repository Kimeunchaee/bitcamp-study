package com.eomcs.pms0716.pm;

import com.eomcs.pms0716.pm.pms.handler.MemberHandler;
import com.eomcs.pms0716.pm.pms.handler.ProjectHandler;
import com.eomcs.pms0716.pm.pms.handler.TaskHandler;
import com.eomcs.pms0716.pm.util.Prompt;

//7번 이후~
//8. 패키지로 클래스 분류 : 클래스를 쓰임새(역할)에 따라 여러 디렉토리로 분류하려 관리하는 방법

// 8-1. util 패키지에 Prompt 파일 옮김
//   a. 다른 패키지에서도 사용할 수 있도록 Prompt클래스의 메소드 앞에 public 붙혀줌
//   b. Prompt클래스를 사용하는 App 파일에 import com.eomcs.pms0716.util.Prompt; 작성

// 8-2. domain 패키지에 Member,Project, Task 파일 옮김
//   a. 각각의 파일 메소드 앞에 public 붙혀줌
//   b. 필요한 파일 import 해주기

// 8-3. handler 패키지에 MemberHandler, ProjectHandler, TaskHandler 파일 옮김
//   a. 필요한 파일 import 해주기


public class App08 {

  public static void main(String[] args) {

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        MemberHandler.add();

      } else if (input.equals("/member/list")) {
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        ProjectHandler.add();

      }  else if (input.equals("/project/list")) {
        ProjectHandler.list();

      }  else if (input.equals("/task/add")) {
        TaskHandler.add();

      }  else if (input.equals("/task/list")) {
        TaskHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    Prompt.close();
  }
}
