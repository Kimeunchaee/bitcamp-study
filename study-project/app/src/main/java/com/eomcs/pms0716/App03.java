package com.eomcs.pms0716;
import java.sql.Date;

//1. 사용자의 입력을 받는 프롬프트 메서드를 별도의 클래스로 분리한다. (Prompt 클래스를 생성)
//2. 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다. (MemberHandelr 클래스 생성)
//3. 프로젝트 데이터 처리와 관련된 메서드를 별도의 클래스로 분리한다 (ProjectHandelr 클래스 생성)



public class App03 {






  // 작업 정보
  static final int TASK_LENGTH = 100;
  static int[] tNo = new int[TASK_LENGTH];
  static String[] tContent = new String[TASK_LENGTH];
  static Date[] tDeadline = new Date[TASK_LENGTH];
  static String[] tOwner = new String[TASK_LENGTH];
  static int[] tStatus = new int[TASK_LENGTH];
  static int tSize = 0;

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
        addTask();

      }  else if (input.equals("/task/list")) {
        listTasks();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    Prompt.keyboardScan.close();
  }





  static void addTask() {
    System.out.println("[작업 등록]");

    tNo[tSize] = Prompt.inputInt("번호? ");
    tContent[tSize] = Prompt.inputString("내용? ");
    tDeadline[tSize] = Prompt.inputDate("마감일? ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    tStatus[tSize] = Prompt.inputInt("> ");
    tOwner[tSize] = Prompt.inputString("담당자? ");

    tSize++;
  }

  static void listTasks() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < tSize; i++) {
      String stateLabel = null;
      switch (tStatus[i]) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }
      System.out.printf("%d, %s, %s, %s, %s\n", 
          tNo[i], tContent[i], tDeadline[i], stateLabel, tOwner[i]);
    }
  }
}