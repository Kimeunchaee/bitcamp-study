package com.eomcs.pms.pms0717.handler;

import java.sql.Date;
import com.eomcs.pms.pms0717.domain.Member;
import com.eomcs.pms.pms0717.util.Prompt;


//`MemberHandler`에 이름으로 회원 정보를 찾는 exist() 메서드를 추가한다.
//: static boolean exist(String name)


public class MemberHandler {
  static Member[] members = new Member[100];
  static int size = 0;

  public static void add() {
    Member member = new Member();
    members[size++] = member;
    while(true) {
      System.out.println("[회원 등록]");
      member.no = Prompt.inputInt("번호? ");  
      member.name =  Prompt.inputString("이름? ");    
      member.email = Prompt.inputString("이메일? ");    
      member.password = Prompt.inputString("암호? ");
      member.photo = Prompt.inputString("사진? ");
      member.tel = Prompt.inputString("전화? ");
      member.registeredDate = new Date(System.currentTimeMillis());

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = Prompt.keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();

    }
  }





  public static void list() {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n", 
          members[i].no, members[i].name, members[i].email,members[i].tel,members[i].registeredDate);
    }
  }





  static boolean exist(String name) {
    for(int i = 0; i < size; i++) {
      if(name.equals(members[i].name)) {
        return true;
      }
    }
    return false;
  }



}
