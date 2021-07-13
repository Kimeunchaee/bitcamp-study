package com.eomcs.pms0713;
import java.sql.Date;
import java.util.Scanner;
//  1. 회원데이터를 입력받는 코드를 변도의 메서드로 분리한다
//      > addMember() 메서드 정의 및 회원 등록 코드를 가져오기
//      > main()과 addMember() 메서드가 서로 공유하는 변수는 클래스변수로 만든다
//  2. 회원 데이터의 목록 출력을 처리하는 코드를 listMember() 메서드로 분리한다.

//  3. 프로젝트 데이터의 목록 출력을 처리하는 코드를 별도의 메서드로 분리한다
//      > listProject() 메서드정의 및 호출
//      >  main()과 addProject()에서 메서드가 서로 공유하는 변수는 클래스변수로 만든다
//  4. 프로젝트 데이터의 목록 출력을 처리하는 코드를 listProject() 메서드로 분리한다.

//  5. 작업 데이터의 입력을 처리하는 코드를 별도의 메서드로 분리한다.
//      > addTask() 메서드정의 및 호출
//      > main()과 addTask()에서 메서드가 서로 공유하는 변수는 클래스변수로 만든다
//  6. 작업 데이터의 목록 출력을 처리하는 코드를 listTask() 메서드로 분리한다.
public class App06 {

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


  public static void main(String[] args) {

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();
    System.out.println();

    while(true) {
      System.out.print("명령 > ");
      String input = keyboardScan.nextLine();

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
    System.out.print("번호? ");
    no[size] = Integer.parseInt(keyboardScan.nextLine());

    System.out.print("이름? ");
    name[size] = keyboardScan.nextLine();

    System.out.print("이메일? ");
    email[size] = keyboardScan.nextLine();

    System.out.print("암호? ");
    password[size] = keyboardScan.nextLine();

    System.out.print("사진? ");
    photo[size] = keyboardScan.nextLine();

    System.out.print("전화? ");
    tel[size] = keyboardScan.nextLine();

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
    System.out.print("번호? ");
    pno[psize] = Integer.valueOf(keyboardScan.nextLine());

    System.out.print("프로젝트명? ");
    ptitle[psize] = keyboardScan.nextLine();

    System.out.print("내용? ");
    pcontent[psize] = keyboardScan.nextLine();

    System.out.print("시작일? ");
    pstartDate[psize] = Date.valueOf(keyboardScan.nextLine());

    System.out.print("종료일? ");
    pendDate[psize] = Date.valueOf(keyboardScan.nextLine());

    System.out.print("만든이? ");
    powner[psize] = keyboardScan.nextLine();

    System.out.print("팀원? ");
    pmembers[psize] = keyboardScan.nextLine();

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
    System.out.print("번호? ");
    tno[TASK_LENGTH] = Integer.parseInt(keyboardScan.nextLine());

    System.out.print("내용? ");
    tcontent[TASK_LENGTH] = keyboardScan.nextLine();

    System.out.print("마감일? ");
    tdeadline[TASK_LENGTH] = Date.valueOf(keyboardScan.nextLine());

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    System.out.print("> ");
    tstatus[TASK_LENGTH] = Integer.valueOf(keyboardScan.nextLine());

    System.out.print("담당자? ");
    towner[TASK_LENGTH] = keyboardScan.nextLine();

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
}
