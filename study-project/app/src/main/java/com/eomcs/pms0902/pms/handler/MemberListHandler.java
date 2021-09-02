package com.eomcs.pms0902.pms.handler;

import java.util.List;
import com.eomcs.pms0902.pms.domain.Member;


public class MemberListHandler extends AbstractMemberHandler implements Command {

  public MemberListHandler(List<Member> memberList) {
    super(memberList);
  }

  //  public void list() {
  @Override
  public void execute() {
    System.out.println("[회원 목록]");

    for (Member member : memberList) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel(), 
          member.getRegisteredDate());
    }
  }
}







