package com.eomcs.pms0901pm.pms.handler;

import java.util.List;
import com.eomcs.pms0901pm.pms.domain.Member;

public abstract class AbstractMemberHandler {

  // findByNo 빼고 다 삭제
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







