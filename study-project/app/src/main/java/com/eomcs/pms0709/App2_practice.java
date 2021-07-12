package com.eomcs.pms0709;
import java.sql.Date;
import java.util.Scanner;

// app2 여러 개의 프로젝트 정보를 입력 받아 출력

public class App2_practice {
  public static void main(String[] args) {

    int max=20;
    int[] no = new int[max];
    String[] title = new String[max];
    String[] content = new String[max];
    Date[] startDate = new Date[max];
    Date[] endDate = new Date[max];
    String[] owner = new String[max];
    String[] members = new String[max];

    Scanner keyboardScan = new Scanner(System.in);

    int d = 0;

    System.out.println("[프로젝트]");

    for (int i = 0; i < max; i++) {
      d = d + 1;
      System.out.print("번호? ");
      no[i] = keyboardScan.nextInt();
      keyboardScan.nextLine(); // 번호 뒤에 남아 있는 줄바꿈 코드를 제거한다.

      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();

      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();

      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(y/N)");
      String txt = keyboardScan.nextLine();
      if(txt.equalsIgnoreCase("N") || txt.equals("")) {
        break;
      }
      System.out.println();
    }
    // || (논리연산자 or) : 조건1, 조건2 중에 한 쪽만 true이면 결과값을 true로 내보낸다.

    keyboardScan.close();

    System.out.println("--------------------------------");
    for (int i = 0; i < d; i++) {
      System.out.printf("%1$d %2$s %3$s %4$s %5$s\n", no[i], title[i], startDate[i], 
          endDate[i], owner[i]);
    }
  }
}
