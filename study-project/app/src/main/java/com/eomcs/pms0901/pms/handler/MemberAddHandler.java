package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.util.Prompt;

// 상속 추가
public class MemberAddHandler extends AbstractMemberHandler {

  // 기존
  //  static List<Member> memberList;
  //
  //  public MemberAddHandler(List<Member> memberList) {
  //    this.memberList = memberList;
  //  }

  // 수정
  static List<Member> memberList;

  public MemberAddHandler(List<Member> memberList) {
    super(memberList);
  }

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
  }
}







