package com.eomcs.pms0716.practice;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  static void close() {
    keyboardScan.close();
  }

  //사용자로부터 문자열을 입력받아 리턴 
  static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  //사용자로부터 정수값을 입력받아 리턴 
  static int inputInt(String title) {
    return Integer.parseInt(inputString(title));  

  }

  //사용자로부터 날짜를 입력받아 리턴 
  static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }


}
