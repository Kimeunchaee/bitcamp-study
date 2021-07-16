package com.eomcs.pms0716;

//1. 사용자의 입력을 받는 프롬프트 메서드를 별도의 클래스로 분리한다. (Prompt 클래스를 생성)
//2. 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다. (MemberHandelr 클래스 생성)
//3. 프로젝트 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (ProjectHandelr 클래스 생성)
//4. 작업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (TaskHandler 클래스 생성)
//5. 키보드 스캐너를 닫는 기능을 스캐너를 가진 클래스에서 수행시킨다. 


public class App05 {

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

    // Prompt 클래스에서 .close 를 수행하도록 함
    // prompt가 가진 자원이기때문에 그 클래스에서 시행되게 한다.
    Prompt.close();
  }
}
