package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;

// 상속 추가
public class AuthUserInfoHandler extends AbstractAuthHandler {

  // 기존
  //  List<Member> memberList;
  //
  //  public AuthUserInfoHandler(List<Member> memberList) {
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

  public AuthUserInfoHandler(List<Member> memberList) {
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

  public void displayLoginUser() {
    System.out.println("[내정보]");

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("이메일: %s\n", loginUser.getEmail());
    System.out.printf("사진: %s\n", loginUser.getPhoto());
    System.out.printf("전화: %s\n", loginUser.getTel());
    System.out.printf("등록일: %s\n", loginUser.getRegisteredDate());
  }
}







