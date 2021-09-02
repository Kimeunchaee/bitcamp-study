package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.util.Prompt;

//상속 추가
public class MemberDeleteHandler extends AbstractMemberHandler {

  // 기존
  //  static List<Member> memberList;
  //
  //  public MemberAddHandler(List<Member> memberList) {
  //    this.memberList = memberList;
  //  }

  //수정
  static List<Member> memberList; // 삭제 가능

  public MemberDeleteHandler(List<Member> memberList) {
    super(memberList);
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

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
  //수퍼클래스에 있으므로 필요없다
  //  @Override
  //  protected Member findByNo(int no) {
  //    Member[] arr = memberList.toArray(new Member[0]);
  //    for (Member member : arr) {
  //      if (member.getNo() == no) {
  //        return member;
  //      }
  //    }
  //    return null;
  //  }
}







