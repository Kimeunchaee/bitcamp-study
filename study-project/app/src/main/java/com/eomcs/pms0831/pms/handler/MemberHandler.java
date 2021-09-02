package com.eomcs.pms0831.pms.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms0831.pms.domain.Member;
import com.eomcs.pms0831.util.Prompt;

public class MemberHandler {

  List<Member> memberList;

  public MemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    Member[] list = memberList.toArray(new Member[0]);

    for (Member member : list) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.getNo(), 
          member.getName(), 
          member.getEmail(), 
          member.getTel(), 
          member.getRegisteredDate());
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.getName()  + ")? ");
    String email = Prompt.inputString("이메일(" + member.getEmail() + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.getPhoto() + ")? ");
    String tel = Prompt.inputString("전화(" + member.getTel() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setPhoto(photo);
    member.setTel(tel);

    System.out.println("회원을 변경하였습니다.");
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

  private Member findByNo(int no) {
    Member[] arr = memberList.toArray(new Member[0]);
    for (Member member : arr) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }


  //---------------------------------외부핸들러에서 사용----------------------------------------

  // 파라미터 1개 받는 findByName (ProjectHandler에서 사용)
  protected Member findByName(String name) {
    for (Member member : memberList) {  //인스턴스 변수를 사용해서 스태틱을 붙힐 수 없다
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  // 파라미터 2개 받는 findByName (TaskHandler에서 사용)
  // 인스턴스 멤버를 사용하지 않는 메서드를 스태틱 메서드로 전환.
  protected static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  // 메서드 내에서 인스턴수 변수를 사용하지 않는다면 static을 붙이는 것을 고려한다
  // 메서드의 작업내용 중에 인스턴스 변수를 필요로 한다면, static을 붙일 수 없다.
  // 반대로 인스턴스 변수를 필요로 하지않는다면 static을 붙이자. (메서드 호출시간 짧아지기 때문에 효율 증가)


  //  public boolean exist(String name) {
  //    Member[] arr = memberList.toArray(new Member[0]);
  //    for (Member member : arr) {
  //      if (member.getName().equals(name)) {
  //        return true;
  //      }
  //    }
  //    return false;
  //  }


  // 파라미터 1개 받는 promptMember (ProjectHandler에서 사용)
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

  // 파라미터 2개 받는 promptMember (TaskHandler에서 사용)
  public static Member promptMember (String label, List<Member> memberList) {
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

  // 파라미터 1개 받는 promptMembers , 팀원 확인
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







