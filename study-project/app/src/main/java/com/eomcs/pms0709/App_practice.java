package com.eomcs.pms0709;
import java.util.Date;
import java.util.Scanner;

// app 연습 회원 3명의 정보를 입력 받아 출력

public class App_practice {

  public static void main(String[] args) {

    int[] no = new int[3];
    String[] name = new String[3];
    String[] email = new String[3];
    String[] password = new String[3];
    String[] photo = new String[3];
    String[] tel = new String[3];
    Date[] registeredDate = new Date[5];


    Scanner keyboardScan = new Scanner(System.in);
    java.sql.Date now = new java.sql.Date(System.currentTimeMillis());

    int i = 0;
    while (i<3) { //조건이 참인 동안 문장을 계속 실행
      System.out.println("[회원]");
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("이름? ");
      name[i] = keyboardScan.nextLine();

      System.out.print("이메일? ");
      email[i] = keyboardScan.nextLine();

      System.out.print("암호? ");
      password[i] = keyboardScan.nextLine();

      System.out.print("사진? ");
      photo[i] = keyboardScan.nextLine();

      System.out.print("전화? ");
      tel[i] = keyboardScan.nextLine();
      registeredDate[i] = new Date();
      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String ans = keyboardScan.nextLine();
      if (ans.equalsIgnoreCase("N") || ans.equals("")) {
        break; 
      }

      System.out.println();
      i = i + 1;
    }

    keyboardScan.close();
    System.out.println("------------------------------");
    i = 0;
    while(i<3) {
      System.out.printf("%1$d %2$s %3$s %4$s %5$tY-%5$tm-%5$td\n", no[i], name[i], email[i], tel[i], registeredDate[i]);
      i = i + 1;
    }

  }
}
