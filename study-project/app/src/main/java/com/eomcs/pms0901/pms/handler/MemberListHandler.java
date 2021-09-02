package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;

public class MemberListHandler extends AbstractMemberHandler {

  // List<Member> memberList;

  public MemberListHandler(List<Member> memberList) {
    //this.memberList = memberList;
    super(memberList);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Member[] list = memberList.toArray(new Member[0]);

    for (Member member : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel(), 
          member.getRegisteredDate());
    }
  }
}







