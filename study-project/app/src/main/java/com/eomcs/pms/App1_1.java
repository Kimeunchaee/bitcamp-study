package com.eomcs.pms;
import java.sql.Date;

//Mini-PMS를 이용하는 회원 정보를 출력, 일단 한 명의 정보만 출력
public class App1_1 {
  public static void main(String[] args) {

    // 입력창
    java.io.InputStream keyboard = System.in;
    java.util.Scanner keyScan = new java.util.Scanner(keyboard);

    System.out.println("[회원]");

    System.out.print("번호? ");
    String str1 = keyScan.nextLine();
    // 변수명은 알아볼수있도록 의미있는 이름으로 만들기 no, name, tel, registeredDate ...

    System.out.print("이름? "); // println 으로 하면 입력한 내용이 아래로 줄바꿈됨
    String str2 = keyScan.nextLine();

    System.out.print("이메일? ");
    String str3 = keyScan.nextLine();

    System.out.print("암호? ");
    String str4 = keyScan.nextLine();

    System.out.print("사진? ");
    String str5 = keyScan.nextLine();

    System.out.print("전화? ");
    String str6 = keyScan.nextLine();

    // 현재 일시 알아내기
    java.sql.Date now = new java.sql.Date(System.currentTimeMillis());

    keyScan.close();





    // 출력창
    System.out.println("------------------------------");
    System.out.println("[회원]");

    // 형식을 갖는 값을 출력할때 : printf
    // `%d` 는 오른쪽에 정수값 자체가 있어야 하는데 여기서는 변수명을 넣어줬기떄문에 %s를 사용
    System.out.printf("번호: %s\n" , str1);   // System.out.println("번호: " + str1);

    // 형식 : `%s` 지정한 자리에 오른쪽 문자열을 삽입한다.
    System.out.printf("이름: %s\n" , str2);
    System.out.printf("이메일: %s\n" , str3);
    System.out.printf("암호: %s\n" , str4);
    System.out.printf("사진: %s\n" , str5);
    System.out.printf("전화: %s\n" , str6);
    System.out.printf("가입일: %s\n", now);

  }
}












