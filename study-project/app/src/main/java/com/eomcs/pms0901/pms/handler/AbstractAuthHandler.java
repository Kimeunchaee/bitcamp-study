package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;

// 추상클래스로 변경
public abstract class AbstractAuthHandler {

  //접근 범위 변경
  protected List<Member> memberList;

  protected AbstractAuthHandler(List<Member> memberList) {
    this.memberList = memberList;

    Member testUser = new Member();
    testUser.setNo(1);
    testUser.setName("aaa");
    testUser.setEmail("aaa@test.com");
    testUser.setPassword("1111");
    testUser.setPhoto("aaa.gif");
    testUser.setTel("010-1111-1111");
    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(testUser);
  }

  static Member loginUser;
  public static Member getLoginUser() {
    return loginUser;
  }
}







