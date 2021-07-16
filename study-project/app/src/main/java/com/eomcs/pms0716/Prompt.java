package com.eomcs.pms0716;

import java.sql.Date;
import java.util.Scanner;


public class Prompt {

  static Scanner keyboardScan = new Scanner(System.in);

  //static String promptString 변수명을 inputString 으로 변경
  static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  static int inputInt(String title) {
    return Integer.parseInt(inputString(title));  
    // return Integer.parseInt(promptString(title)); 에서
    // return Integer.parseInt(inputString(title)); 으로 변경
  }

  static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  //prompt가 가진 자원이기때문에 그 클래스에서 시행되게 한다.
  static void close() {
    Prompt.keyboardScan.close();
  }

}
