package com.eomcs.pms0901.pms.handler;

import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Member;
import com.eomcs.pms0901.util.Prompt;

// 추상클래스로 변경
public abstract class AbstractMemberHandler {

  List<Member> memberList;

  public AbstractMemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  //접근 범위 변경
  protected Member findByNo(int no) {
    Member[] arr = memberList.toArray(new Member[0]);
    for (Member member : arr) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }

  // static 빼주기
  protected /*static*/ Member findByName(String name) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  // static 그대로
  protected static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }


  //  public boolean exist(String name) {
  //    Member[] arr = memberList.toArray(new Member[0]);
  //    for (Member member : arr) {
  //      if (member.getName().equals(name)) {
  //        return true;
  //      }
  //    }
  //    return false;
  //  }


  //static 그대로
  public static Member promptMember(String label, List<Member> memberList) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName, memberList);
      if(member != null) {
        return member;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public /*static*/ ArrayList<Member> promptMembers(String label) {
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







