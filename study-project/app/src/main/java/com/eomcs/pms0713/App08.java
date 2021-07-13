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

public class App08 {

  static Scanner keyboardScan = new Scanner(System.in);


  // 회원정보
  static final int LENGTH = 100;  // 최대 입력 개수
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
  static int[] pno = new int[PROJECT_LENGTH];
  static String[] ptitle = new String[PROJECT_LENGTH];
  static String[] pcontent = new String[PROJECT_LENGTH];
  static Date[] pstartDate = new Date[PROJECT_LENGTH];
  static Date[] pendDate = new Date[PROJECT_LENGTH];
  static String[] powner = new String[PROJECT_LENGTH];
  static String[] pmembers = new String[PROJECT_LENGTH];
  static int psize = 0;

  // 작업 정보
  static final int TASK_LENGTH = 100;

  static int[] tno = new int[TASK_LENGTH];
  static String[] tcontent = new String[TASK_LENGTH];
  static Date[] tdeadline = new Date[TASK_LENGTH];
  static String[] towner = new String[TASK_LENGTH];
  static int[] tstatus = new int[TASK_LENGTH];
  static int tsize = 0;

  // 사용자가 입력한 값을 보관하는 변수
  static String input;


  public static void main(String[] args) {

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();
    System.out.println();

    while(true) {
      prompt("번호? ");
      no[size] = Integer.parseInt(input);

      prompt("이름? ");
      no[size] = Integer.parseInt(input);

      if(input.equals("exit") || input.equals("quit")) {
        break;

      } else if(input.equals("/member/add")) {
        // 메서드로 분리한 코드를 실행하기(메서드 호출)
        addMember();

      } else if (input.equals("/member/list")) {
        listMember();

      }  else if (input.equals("/project/add")) {
        addProject();

      } else if (input.equals("/project/list")) {
        listProject();

      } else if (input.equals("/task/add")) {
        addTask();

        System.out.print("계속 입력하시겠습니까?(y/N) ");
        String str = keyboardScan.nextLine();
        if (!str.equalsIgnoreCase("y")) {
          break;
        }
        System.out.println();


      } else if (input.equals("/task/list")) {
        listTask();

      } else {
        System.out.println("실행할수없는 명령입니다.");
      }
      System.out.println();
    }
    keyboardScan.close();
  }


  static void addMember() {   //다른 메소드가 같은 변수명을 공유할수 없다
    System.out.println("[회원등록]");
    prompt("번호? ");
    no[size] = Integer.parseInt(input);

    prompt("이름? ");
    name[size] = input;

    prompt("이메일? ");
    email[size] = input;

    prompt("암호? ");
    password[size] = input;

    prompt("사진? ");
    photo[size] = input;

    prompt("전화? ");
    tel[size] = input;

    registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

    size++;
  }

  static void listMember() { 
    System.out.println("[회원목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
  }

  static void addProject() {
    System.out.println("[프로젝트목록]");
    prompt("번호? ");    // System.out.print 을 prompt메소드로 변경해줌
    pno[psize] = Integer.valueOf(input);

    prompt("프로젝트명? ");
    ptitle[psize] = input;

    prompt("내용? ");
    pcontent[psize] = input;

    prompt("시작일? ");
    pstartDate[psize] = Date.valueOf(input);

    prompt("종료일? ");
    pendDate[psize] = Date.valueOf(input);

    prompt("만든이? ");
    powner[psize] = input;

    prompt("팀원? ");
    pmembers[psize] = input;

    psize++;
  }

  static void listProject() {
    for (int i = 0; i < psize; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          pno[i], ptitle[i], pstartDate[i], pendDate[i], powner[i]);
    }
  }

  static void addTask() {
    System.out.print("프로젝트? ");
    prompt("번호? ");
    tno[TASK_LENGTH] = Integer.parseInt(input );

    prompt("내용? ");
    tcontent[TASK_LENGTH] = input;            // keyboardScan.nextLine(); 을 input 으로 바꿔줌

    prompt("마감일? ");
    tdeadline[TASK_LENGTH] = Date.valueOf(input );

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    System.out.print("> ");
    tstatus[TASK_LENGTH] = Integer.valueOf(input );

    prompt("담당자? ");
    towner[TASK_LENGTH] = input;

    tsize++;
    System.out.println(); // 빈 줄 출력
  }

  static void listTask() {
    for (int i = 0; i < tsize; i++) {
      String stateLabel = null;
      switch (tstatus[i]) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          tno[i], tcontent[i], tdeadline[i], stateLabel, towner[i]);
    }
  }

  static void prompt (String title) {  // ()안에 String 변수를 넣어주면 문자열을 입력할때만 prompt명령러가 실행되도록 함.
    System.out.print("명령 > ");
    input = keyboardScan.nextLine();   //원래 소스코드는 String input 이지만 선언을 클래스 메소드에 해줬으므로 String을 지워줌
  }

}
