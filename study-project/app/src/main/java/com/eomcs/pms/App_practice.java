package com.eomcs.pms;
import java.util.Date;
import java.util.Scanner;

// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
// 3) 배열을 사용하여 여러 개의 값을 다루기
// - 배열을 사용하면 간단하게 여러 개의 변수를 선언할 수 있다.
// 4) 반복문을 사용하여 여러 개의 값을 다루기
// - 반복문을 사용하면 같은 코드를 중복해서 작성할 필요가 없다.
// 5) 배열 개수를 변수에서 관리하기
// - 변수의 값만 바꾸면 배열 개수를 바로 변경할 수 있어 편하다.
// 6) 상수를 사용하여 초기 값을 변경하지 못하게 막기
// - 변수는 중간에 값을 바꿀 수 있기 때문에 값을 바꾸지 말아야 하는 경우
//   상수로 선언한다.

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


    int i = 0;
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

    System.out.print("계속 입력하시겠습니까? ");
    registeredDate[i] = new Date();

    System.out.println();
    keyboardScan.close();




    System.out.println("------------------------------");
    System.out.println("[회원]");

    System.out.printf("번호: %s\n" , no);
    System.out.printf("이름: %s\n" , name);
    System.out.printf("이메일: %s\n" , email);
    System.out.printf("암호: %s\n" , password);
    System.out.printf("사진: %s\n" , photo);
    System.out.printf("전화: %s\n" , registeredDate);
  }
}
