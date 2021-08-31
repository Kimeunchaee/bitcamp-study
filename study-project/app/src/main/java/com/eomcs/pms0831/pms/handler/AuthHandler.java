package com.eomcs.pms0831.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0830.pms.domain.Member;
import com.eomcs.pms0830.util.Prompt;

public class AuthHandler {

  List<Member> memberList;
  //이 객체를 가지고 계속 쓸꺼니까 인스턴스 객체로 추가함
  // 로그인정보를 담을 필드 추가
  static Member loginUser;


  public static Member getLoginUser() {
    return loginUser;
  }


  // 0831 추가
  public AuthHandler(List<Member> memberList) {
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

  public void login() {
    System.out.println("[로그인]");
    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("암호? ");

    Member member = findByEmailPassword(email, password);

    if (member == null) {
      System.out.println("이메일과 암호가 일치하는 회원을 찾을 수 없습니다.");
    } else {
      System.out.printf("%s님 환영합니다!\n", member.getName());
      loginUser = member;
    }
  }


  public void displayLoginUser() {
    System.out.println("[내 정보]");

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


  public void logout() { 
    System.out.println("[로그아웃]");

    this.loginUser = null;      //loginUser 필드를 null로 초기화 시킨다
    System.out.println("로그아웃 하였습니다.");
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







