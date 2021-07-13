package com.eomcs.pms0713;
import java.sql.Date;
import java.util.Scanner;

//  7. 사용자로부터 값을 입력 받는 키보드 코드를 별도의 메서드로 분리한다.
//      > prompt() 메서드정의 및 호출
// --------------------------------1~7번 지금까지 호출한 메소드는 값이 없었다------------
// --------------------------------8번부터는 값이 있는 메소드 호출하기-------------

//  8. 명령어 뿐만 아니라 사용자로부터 입력을 받는 기능을 모두 prompt()를 사용하여 처리한다.
//      > prompt()를 호출할 때 사용자에게 출력할 프롬프트 메시지를 아규먼트로 넘긴다.
//      > prompt()는 호출할 때 넘어온 프롬프트 메시지 값을 파라미터로 받는다.

//  9. prompt() 가 작업한 결과를 클래스 변수에 담지 말고 호출자에게 리턴한다.
//      > prompt()를 실행한 후 사용자가 입력한 문자열(String)을 리턴한다.

public class App09 {

  static Scanner keyboardScan = new Scanner(System.in);

  // 회원 정보
  static final int LENGTH = 100;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
  static int size = 0;

  // 프로젝트 정보
  static final int PROJECT_LENGTH = 1000;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static String[] pContent = new String[PROJECT_LENGTH];
  static Date[] pStartDate = new Date[PROJECT_LENGTH];
  static Date[] pEndDate = new Date[PROJECT_LENGTH];
  static String[] pOwner = new String[PROJECT_LENGTH];
  static String[] pMembers = new String[PROJECT_LENGTH];
  static int pSize = 0;

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
      String input = prompt("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        // 메서드로 분리한 코드를 실행하기(메서드 호출)
        // => 메서드명();
        addMember();

      } else if (input.equals("/member/list")) {
        listMembers();

      }  else if (input.equals("/project/add")) {
        addProject();

      }  else if (input.equals("/project/list")) {
        listProjects();

      }  else if (input.equals("/task/add")) {
        addTask();

      }  else if (input.equals("/task/list")) {
        listTasks();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    keyboardScan.close();
  }

  static void addMember() {
    System.out.println("[회원 등록]");

    //    String input = prompt("번호? ");
    //    no[size] = Integer.parseInt(input);
    //    한줄로 작성

    no[size] = Integer.parseInt(prompt("번호? "));
    name[size] = prompt("이름? ");
    email[size] = prompt("이메일? ");
    password[size] = prompt("암호? ");
    photo[size] = prompt("사진? ");
    tel[size] = prompt("전화? ");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;
  }

  static void listMembers() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
  }

  static void addProject() {
    System.out.println("[프로젝트 등록]");

    pNo[pSize] = Integer.valueOf(prompt("번호? "));
    pTitle[pSize] = prompt("프로젝트명? ");
    pContent[pSize] = prompt("내용? ");
    pStartDate[pSize] = Date.valueOf(prompt("시작일? "));
    pEndDate[pSize] = Date.valueOf(prompt("종료일? "));
    pOwner[pSize] = prompt("만든이? ");
    pMembers[pSize] = prompt("팀원? ");

    pSize++;
  }

  static void listProjects() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < pSize; i++) {

      System.out.printf("%d, %s, %s, %s, %s\n",
          pNo[i], pTitle[i], pStartDate[i], pEndDate[i], pOwner[i]);
    }
  }

  static void addTask() {
    System.out.println("[작업 등록]");

    tNo[tSize] = Integer.parseInt(prompt("번호? "));
    tContent[tSize] = prompt("내용? ");
    tDeadline[tSize] = Date.valueOf(prompt("마감일? "));

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    tStatus[tSize] = Integer.valueOf(prompt("> "));
    tOwner[tSize] = prompt("담당자? ");

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

  // prompt();
  // - 사용자로부터 문자열을 입력 받는 기능을 수행한다.
  // - 파라미터:
  //     title - 프롬프트의 메시지
  // - 리턴 값:
  //     String - 사용자가 입력한 문자열
  // 
  static String prompt(String title) {
    System.out.print(title);
    String input = keyboardScan.nextLine();
    return input;
  }

}