package com.eomcs.pms0716;

//1. 사용자의 입력을 받는 프롬프트 메서드를 별도의 클래스로 분리한다. (Prompt 클래스를 생성)
//2. 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다. (MemberHandelr 클래스 생성)
//3. 프로젝트 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (ProjectHandelr 클래스 생성)
//4. 작업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (TaskHandler 클래스 생성)


public class App04 {

  public static void main(String[] args) {

    while (true) {
      // String input = promptString("명령> ");
      // 아래 코드로 변경해줌
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        // addMember(); 을 변경해줌
        MemberHandler.add();

      } else if (input.equals("/member/list")) {
        //listMembers();
        MemberHandler.list();

      }  else if (input.equals("/project/add")) {
        //addProject();
        ProjectHandler.add();

      }  else if (input.equals("/project/list")) {
        //listProjects();
        ProjectHandler.list();

      }  else if (input.equals("/task/add")) {
        //addTask();
        TaskHandler.add();

      }  else if (input.equals("/task/list")) {
        //listTasks();
        TaskHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    Prompt.keyboardScan.close();
  }
}