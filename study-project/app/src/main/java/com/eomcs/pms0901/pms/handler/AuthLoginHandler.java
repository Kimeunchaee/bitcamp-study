package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.util.Prompt;

// 상속 추가
public class AuthLoginHandler extends AbstractAuthHandler {

  // 기존
  //  List<Member> memberList;
  //
  //  public AuthLoginHandler(List<Member> memberList) {
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

  //수정
  public AuthLoginHandler(List<Member> memberList) {
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

  public void login() {
    System.out.println("[로그인]");

    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("암호?");

    Member member = findByEmailPassword(email, password);

    if (member == null) {
      System.out.println("이메일과 암호가 일치하는 회원을 찾을 수 없습니다.");
    } else {
      System.out.printf("%s님 환영합니다!\n", member.getName());
      loginUser = member;
    }
  }

  private Member findByEmailPassword(String email, String password) {
    for (Member member : memberList) {
      if (member.getEmail().equalsIgnoreCase(email) &&
          member.getPassword().equals(password)) {
        return member;
      }
    }
    return null;
  }

}







