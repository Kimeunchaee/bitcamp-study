package com.eomcs.pms0902.pms.handler;

import java.util.List;
import com.eomcs.pms0902.pms.domain.Member;

public abstract class AbstractMemberHandler {

  protected List<Member> memberList;

  public AbstractMemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  protected Member findByNo(int no) {
    for (Member member : memberList) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }
}







