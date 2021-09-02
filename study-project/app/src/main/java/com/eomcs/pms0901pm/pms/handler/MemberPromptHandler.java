package com.eomcs.pms0901pm.pms.handler;

import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms0901pm.pms.domain.Member;
import com.eomcs.pms0901pm.util.Prompt;

// 외부에서 사용하는 promptXX 메서드들을 모아두는 클래스
// AbstractMemberHandler 를 상속받는다

// ProjectAddHandler , ProjectUpdateHandler , TaskAddHandler , TaskUpdateHandler
// 4개의 클래스에서 사용하므로 가서 수정해주기

public class MemberPromptHandler extends AbstractMemberHandler {

  //protected List<Member> memberList;

  public MemberPromptHandler (List<Member> memberList) {
    //this.memberList = memberList;
    super(memberList);
  }

  // 내부에서 사용하므로 삭제한다
  //  protected Member findByNo(int no) {
  //    for (Member member : memberList) {
  //      if (member.getNo() == no) {
  //        return member;
  //      }
  //    }
  //    return null;
  //  }



  // 주어진 인스턴스에서 값을 다루는 메서드
  protected Member findByName(String name) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }


  // 파라미터로 값을 받아서 다루는 메서드
  // 그래서 스태틱이다!
  protected static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  public boolean exist(String name) {
    for (Member member : memberList) {
      if (member.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public Member promptMember(String label) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName);
      if (member != null) {
        return member;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public static Member promptMember(String label, List<Member> memberList) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName, memberList);
      if (member != null) {
        return member;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public List<Member> promptMembers(String label) {
    ArrayList<Member> members = new ArrayList<>();

    while (true) {
      String memberName = Prompt.inputString(label);
      Member member = findByName(memberName);
      if (member != null) {
        members.add(member);
        continue;
      } else if (memberName.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members;
  }
}







