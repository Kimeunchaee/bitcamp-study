package com.eomcs.pms0805.handler;

import java.sql.Date;
import com.eomcs.pms0805.domain.Member;
import com.eomcs.pms0805.util.Prompt;

public class MemberHandler {

  // 접근이 디폴트로 되어있다
  // 같은 패키지안에서만 접근가능하다
  // APP에서 사용하기위해 public 으로 바꿔주는데
  // 퍼블릭은 호출하는 쪽에서 memberList를 마음대로 바꿀수있기때문에
  // 이를 방지하기위해 getter 메서드로 만들어준다

  // 기존코드
  // public MemberList memberList =  new MemberList();

  // getter 메서드로 바꿔줌
  MemberList memberList =  new MemberList();
  public MemberList getMemberList() {
    return memberList;
  }

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Member[] list = memberList.toArray();

    for (Member member : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.no, 
          member.name, 
          member.email, 
          member.tel, 
          member.registeredDate);
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = memberList.findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("사진: %s\n", member.photo);
    System.out.printf("전화: %s\n", member.tel);
    System.out.printf("등록일: %s\n", member.registeredDate);
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = memberList.findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.name  + ")? ");
    String email = Prompt.inputString("이메일(" + member.email + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.photo + ")? ");
    String tel = Prompt.inputString("전화(" + member.tel + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.photo = photo;
    member.tel = tel;

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    //int index = indexOf(no);
    Member member = memberList.findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(member);

    System.out.println("회원을 삭제하였습니다.");
  }




  // 멤버핸들러에 만든 메서드인 exist
  // 멤버 리스트로 옮기고
  // 프로젝트 핸들러에서 멤버리스트에서 불러서 사용할수 있도록 함
  // 멤버핸들러에는 exist를 호출할 필요없음 (사용하지 않으니까)
  //  boolean exist(String name) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.members[i].name.equals(name)) {
  //        return true;
  //      }
  //    }
  //    return false;



}








