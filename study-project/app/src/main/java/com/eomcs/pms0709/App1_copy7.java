package com.eomcs.pms0709;

import java.util.Date;
import java.util.Scanner;

public class App1_copy7 {
  public static void main(String[] args) {

    // 7. 날짜의 출력형식을 "yyyy-mm-dd"로 변경한다 (%5$tY-%5$tm-%5$td)
    final int MAX_LENGTH = 100;

    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];

    Date now = new Date(System.currentTimeMillis());
    Scanner keyboardScan = new Scanner(System.in);

    int size = 0; //변수 선언 및 초기화
    // for문 밖에서 변수를 선언해줘야 각각의 for문에서 사용할수있음 

    System.out.println("[회원]");

    for (int i = 0; i < MAX_LENGTH; i = i + 1) {
      size = size + 1; //사용자 한명이 입력한 데이터들의 갯수
      // 한명한명 입력할수록 데이터가 쌓이고  MAX_LENGTH 값으로 설정해놓은
      // 100전까지만 데이터를 저장하도록 size라는 이름의 변수를 만들어줌

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());   //문자열을 숫자로 바꿔줌
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
      System.out.println();
      System.out.println("계속 입력하시겠습니까? (y/N)");
      String input = keyboardScan.nextLine();
      if (input.equalsIgnoreCase("N") || input.equals("")) {
        break; //현재 반복한걸 멈추게
      }
      System.out.println();
    }
    keyboardScan.close();

    // 출력창
    System.out.println("--------------------------------");

    // 쌓인 데이터(size)만큼 됐을때 출력하라
    for (int i = 0; i < size; i=i+1) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n", no[i], name[i], email[i],tel[i],registeredDate[i]);
      System.out.println();

    }
  }
}
