package com.eomcs.pms.pms0717;

import java.sql.Date;
import java.util.Scanner;

public class App0 {


  static Scanner keyboardScan = new Scanner(System.in);

  // 회원 정보입력
  static final int max = 100;
  static int[] no = new int[max];
  static String[] name = new String[max];
  static String[] email = new String[max];
  static String[] password = new String[max];
  static String[] photo = new String[max];
  static String[] tel = new String[max];
  static Date[] registeredDate = new Date[max];
  static int size = 0;

  // 프로젝트 정보입력
  static final int pmax = 100;
  static int[] pno = new int[pmax];
  static String[] ptitle = new String[pmax];
  static String[] content = new String[pmax];
  static Date[] startDate = new Date[pmax];
  static Date[] endDate = new Date[pmax];
  static String[] owner = new String[pmax];
  static String[] member = new String[pmax];
  static  int psize = 0;

  //작업 정보입력
  static final int tmax = 100;
  static  int[] tno = new int[tmax];
  static String[] tcontent = new String[tmax];
  static Date[] deadLine = new Date[tmax];
  static String[] towner = new String[tmax];
  static int[] status = new int[tmax];
  static int tsize = 0;

  static String str;

  public static void main(String[] args) {

    while(true) {

      String str = prompt("명령 > ");

      if (str.equals("exit") || str.equals("quit")) {
        break;

      } else if (str.equals("/member/add")) {
        addmember();

      } else if(str.equals("/member/list")) {
        listmember();

      } else if(str.equals("/project/add")) { 
        addproject();

      } else if (str.equals("/project/list")) {
        listproject();

      } else if (str.equals("/task/add")) {
        addtask();

      } else if (str.equals("/task/list")) {
        listtask();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboardScan.close();
  }


  static String prompt(String title) {
    System.out.print("title");
    str = keyboardScan.nextLine();
    return str;
  }


  static void listtask() {
    System.out.println("-------------출력------------");
    for(int i = 0; i < tsize; i++) {
      String statusinput = null;
      if(status[i] == 0) {
        statusinput = "신규";
      } else if (status[i] == 1) {
        statusinput = "진행중";
      } else if (status[i] == 2) {
        statusinput = "완료";
      }
      System.out.printf("%d %s %s %s %s\n", 
          tno[i], tcontent[i], deadLine[i], towner[i], statusinput);
    }
  }

  static void addtask() {
    tsize++;

    System.out.println("[작업 등록]");

    tno[tsize] = Integer.parseInt(prompt("번호? "));
    tcontent[tsize] = prompt("내용? ");
    deadLine[tsize] = Date.valueOf(prompt("시작일? "));
    towner[tsize] = prompt("작성자? ");

    System.out.println("상태? ");
    System.out.println(" 0: 신규\n 1: 진행중\n 2: 완료");
    System.out.print("> ");
    status[tsize] = Integer.valueOf(str);
  }

  static void listproject() {
    System.out.println("-------------출력------------");
    for(int i = 0; i < psize; i++) {
      System.out.printf("%d %s %s %s %s %s %s\n", 
          pno[i], ptitle[i], content[i], startDate[i], startDate[i], owner[i], member[i]);
    }
  }

  static void addproject() {
    psize++;

    System.out.println("[프로젝트 등록]");

    pno[psize] = Integer.parseInt(prompt("번호? "));


    ptitle[psize] = prompt("프로젝트명? ");


    content[psize] = prompt("내용? ");

    prompt("시작일? ");
    startDate[psize] = Date.valueOf(str);

    prompt("종료일? ");
    endDate[psize] = Date.valueOf(str);

    prompt("만든이? ");
    owner[psize] = str;

    prompt("팀원? ");
    member[psize] = str;
  }

  static void listmember() {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n", 
          no[i], name[i], email[i],tel[i],registeredDate[i]);
    }
  }

  static void addmember() {
    size++;
    System.out.println("[회원 등록]");
    prompt("번호? ");
    no[size] = Integer.parseInt(str);

    prompt("이름? ");
    name[size] = str;

    prompt("이메일? ");
    email[size] = str;

    prompt("암호? ");
    password[size] = str;

    prompt("사진? ");
    photo[size] = str;

    prompt("전화? ");
    tel[size] = str;

    registeredDate[size] = new Date(System.currentTimeMillis());
  }
}



