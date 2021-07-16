package com.eomcs.pms0716.am;

import java.sql.Date;


public class MemberHandler {
  /*
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
   */
  //위에 코드를 바꿔줌 (1,2번)

  // 1. Member 인스턴스의 주소를 저장할 레퍼런스를 5개 생성한다. 이름은 m1,m2... 이다.
  //static Member m1, m2, m3, m4, m5;

  // 2. Member 인스턴스의 주소를 저장할 레퍼런스를 100개 생성한다.
  //인스턴스를 100개 만드는게 아니라 인스턴스 저장될 주소인 레퍼런스가 100개 생기는것이다!!
  static Member[] members = new Member[100];
  static int size = 0;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 5개 생성한다.
  static final int MAX_LENGTH = 5;


  public static void add() {   //변수명에 member을 빼줌
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱개의 변수가 아니라 Member에 정의된 그대로 묶음 변수를 만든다.
    Member member = new Member();

    // Integer.valueOf(promptInt) 를 Prompt.inputInt 으로 바꿔줌
    // promptString 을 Prompt.inputString 으로 바꿔줌

    //no[size] = Prompt.inputInt("번호? "); 을 member인스턴스 변수로 바꿔서 선언해줌
    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members [size++] = member;
    //members 가 가르키는 배열 0번째, 1번째, 2번째 ... 에 member값(=인스턴스 주소)을 넣어라
    // 그 배열의 이름이 size , 0번째에 값이넣어지면 size++ 되서 배열 1번째를 가르킴, 1번에 다시 값이 넣어지고 배열 2번째를 가리킴 ... 반복 
  }


  public static void list() {  //변수명에 member을 빼줌
    System.out.println("[회원 목록]");
    for (int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].tel,
          members[i].registeredDate

          );
    }
  }
}
