package com.eomcs.pms0712;
import java.sql.Date;
import java.util.Scanner;

// 09단계 작성해보기

// 9) /project/add 추가하기 (변수명이 겹치니까 바꿔주기)
// 10) /project/list 처리하기
// 11) /task/add 추가하기
public class App_project1_3 {
  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);


    // 회원정보
    final int LENGTH = 100;  // 최대 입력 개수
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];
    int size = 0;

    // 프로젝트 정보
    final int PROJECT_LENGTH = 1000;
    int[] pno = new int[PROJECT_LENGTH];
    String[] ptitle = new String[PROJECT_LENGTH];
    String[] pcontent = new String[PROJECT_LENGTH];
    Date[] pstartDate = new Date[PROJECT_LENGTH];
    Date[] pendDate = new Date[PROJECT_LENGTH];
    String[] powner = new String[PROJECT_LENGTH];
    String[] pmembers = new String[PROJECT_LENGTH];
    int psize = 0;

    // 작업 정보
    final int TASK_LENGTH = 100;

    int[] tno = new int[TASK_LENGTH];
    String[] tcontent = new String[TASK_LENGTH];
    Date[] tdeadline = new Date[TASK_LENGTH];
    String[] towner = new String[TASK_LENGTH];
    int[] tstatus = new int[TASK_LENGTH];
    int tsize = 0;


    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();
    System.out.println();

    while(true) {
      System.out.print("명령 > ");
      String input = keyboardScan.nextLine();

      if(input.equals("exit") || input.equals("quit")) {
        break;

      } else if(input.equals("/member/add")) {
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

      } else if (input.equals("/member/list")) {
        System.out.println("[회원목록]");
        for (int i = 0; i < size; i++) {
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], name[i], email[i], tel[i], registeredDate[i]);
        }

      } else if (input.equals("/project/add")) {
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

      } else if (input.equals("/project/list")) {
        for (int i = 0; i < psize; i++) {
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              pno[i], ptitle[i], pstartDate[i], pendDate[i], powner[i]);
        }

      } else if (input.equals("/task/add")) {
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

        System.out.print("계속 입력하시겠습니까?(y/N) ");
        String str = keyboardScan.nextLine();
        if (!str.equalsIgnoreCase("y")) {
          break;
        }
        System.out.println();

      } else if (input.equals("/task/list")) {
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

      } else {
        System.out.println("실행할수없는 명령입니다.");
      }
      System.out.println();
    }
    keyboardScan.close();

  }
}


