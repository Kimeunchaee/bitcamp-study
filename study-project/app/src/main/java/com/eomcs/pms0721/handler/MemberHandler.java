package com.eomcs.pms0721.handler;

import java.sql.Date;
import com.eomcs.pms.pms0719.domain.Member;
import com.eomcs.pms.pms0719.util.Prompt;



public class MemberHandler {

  static final int MAX_LENGTH = 5;

  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  public void add(MemberHandler this) {
    Member member = new Member();
    this.members[this.size++] = member;

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





  public void list(MemberHandler this) {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n", 
          this.members[i].no, this.members[i].name, this.members[i].email,
          this.members[i].tel, this.members[i].registeredDate);
    }
  }





  boolean exist(String name) {
    for(int i = 0; i < this.size; i++) {
      if(name.equals(this.members[i].name)) {
        return true;
      }
    }
    return false;
  }



}
