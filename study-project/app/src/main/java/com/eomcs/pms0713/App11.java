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

//  10. prompt() 기능 세분화
//      > promptString() : 사용자로부터 문자열을 입력 받아 리턴한다.
//      > promptInt() : 사용자로부터 숫자를 입력 받아 리턴한다.
//      > promptDate() : 사용자로부터 날짜를 입력 받아 리턴한다.

//  11. promtString(), promptInt(), promptDate() 메서드의 코드를 정리한다.

public class App11 {

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
      String input = promptString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
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

    no[size] = promptInt("번호? ");
    name[size] = promptString("이름? ");
    email[size] = promptString("이메일? ");
    password[size] = promptString("암호? ");
    photo[size] = promptString("사진? ");
    tel[size] = promptString("전화? ");
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

    pNo[pSize] = Integer.valueOf(promptInt("번호? "));
    pTitle[pSize] = promptString("프로젝트명? ");
    pContent[pSize] = promptString("내용? ");
    pStartDate[pSize] = promptDate("시작일? ");
    pEndDate[pSize] = promptDate("종료일? ");
    pOwner[pSize] = promptString("만든이? ");
    pMembers[pSize] = promptString("팀원? ");

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

    tNo[tSize] = promptInt("번호? ");
    tContent[tSize] = promptString("내용? ");
    tDeadline[tSize] = promptDate ("마감일? ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    tStatus[tSize] = promptInt("> ");
    tOwner[tSize] = promptString("담당자? ");

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

  // 사용자로부터 문자열을 입력받아 리턴 
  static String promptString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  //사용자로부터 정수값을 입력받아 리턴 
  static int promptInt(String title) {
    System.out.print(title);
    return Integer.parseInt(promptString(title));  

    // (keyboardScan.nextLine()); 대신 promptString(title)작성해서
    // promptString명령어를 사용하면 화면출력과 사용자가 입력, 한줄바꿈까지 한번에 작성가능

  }

  //사용자로부터 날짜를 입력받아 리턴 
  static Date promptDate(String title) {
    System.out.print(title);
    return Date.valueOf(promptString(title));
  }

}