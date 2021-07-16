package com.eomcs.pms0716.pm.pms.handler;


import java.sql.Date;
import com.eomcs.pms0716.pm.pms.domain.Member;
import com.eomcs.pms0716.pm.util.Prompt;



public class MemberHandler {
  static Member[] members = new Member[100];
  static int size = 0;

  static final int MAX_LENGTH = 5;


  public static void add() {   
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members [size++] = member;
  }


  public static void list() {  
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
