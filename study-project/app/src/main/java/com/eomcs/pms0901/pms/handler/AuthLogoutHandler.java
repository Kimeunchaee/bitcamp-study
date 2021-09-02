package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;

// 상속 추가
public class AuthLogoutHandler extends AbstractAuthHandler {

  // 기존
  //  List<Member> memberList;
  //
  //  public AuthLogoutHandler(List<Member> memberList) {
  //    this.memberList = memberList;
  //
  //    Member testUser = new Member();
  //    testUser.setNo(1);
  //    testUser.setName("aaa");
  //    testUser.setEmail("aaa@test.com");
  //    testUser.setPassword("1111");
  //    testUser.setPhoto("aaa.gif");
  //    testUser.setTel("010-1111-1111");
  //    testUser.setRegisteredDate(new Date(System.currentTimeMillis()));
  //
  //    memberList.add(testUser);
  //  }

  // 수정
  List<Member> memberList;

  public AuthLogoutHandler(List<Member> memberList) {
    super(memberList);

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

  public void logout() {
    System.out.println("[로그아웃]");

    loginUser = null;
    System.out.println("로그아웃 하였습니다.");
  }

}







