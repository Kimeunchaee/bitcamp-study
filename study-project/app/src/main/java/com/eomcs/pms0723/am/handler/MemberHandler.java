package com.eomcs.pms0723.am.handler;

import java.sql.Date;
import com.eomcs.pms0723.am.domain.Member;
import com.eomcs.pms0723.am.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;

  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

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

    this.members[this.size++] = member;
  }

  public void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s\n", 
          this.members[i].no, 
          this.members[i].name, 
          this.members[i].email,
          this.members[i].photo, 
          this.members[i].tel, 
          this.members[i].registeredDate);
    }
  }

  boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].name.equals(name)) {
        return true;
      }
    }
    return false;
  }


  public void detail() {

    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = null;


    for (int i = 0; i < this.size; i++) { 
      if (this.members[i].no == no) {
        member = this.members[i];
        break; 
      }
    }

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return; 
    }

    //    System.out.println("[회원 상세보기]");
    //    int no = Prompt.inputInt("번호? ");
    //
    //    // 다른방법
    //    // 배열자체로 비교
    //    int index = -1;
    //    //회원정보를 저장할 레퍼런스
    //
    //    for (int i = 0; i < this.size; i++) {    
    //      if (this.members[i].no == no) {
    //        // member = this.members[i];
    //        index = i;
    //        break; 
    //        //i번째 회원정보(인스턴스)와 사용자가 입력한 넘버가 같은지
    //        // 비교해서 member에 저장
    //        // (배열그대도써서 배열에 저장해도 상관은 없지만
    //        // int index = -1; / int = i;
    //        // 를 추가ㅐㅎ서 배열을 찾도록 해줘야하기때문에
    //        // 코드가 추가됨
    //
    //      }
    //    }
    //
    //    if (index == this.size) {
    //      System.out.println("해당 번호의 회원이 없습니다.");
    //      return;
    //    }

    System.out.printf("번호: %s\n", member.no);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("사진: %s\n", member.photo);
    System.out.printf("전화: %s\n", member.tel);
    System.out.printf("등록일: %s\n", member.registeredDate);

  }



  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = null;

    for(int i = 0; i < this.size; i++) {
      if (this.members[i].no == no) {

        member = this.members[i];
        break;
      } 
    }

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    // 임시변수 String name 에 담는다 > 최종 변경하시겠습니까? 에 y를 입력하면 그때 바꾸기위해
    String label = String.format("이름(%s)? ", member.name);
    String name = Prompt.inputString(label);

    //한줄로 작성
    String email = Prompt.inputString(String.format("이메일(%s)? ", member.email));

    // 다른방법 : + 때문에 코드읽기가 어려워져서 format 방법을 더 선호
    String password = Prompt.inputString("암호("+ member.password +")?");

    String photo = Prompt.inputString(String.format("사진(%s)? ", member.photo));

    String tel = Prompt.inputString(String.format("전화(%s)? ", member.tel));

    String input = Prompt.inputString("정말 변경하시겠습니까? (y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    member.name = name;
    member.email = email;
    member.password = password;
    member.photo = photo;
    member.tel = tel;
    System.out.println("회원 정보를 변경하였습니다.");

  }


  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    //배열과 관계가 있기때문에 Member객체는 받지 않음
    // Member member = null;
    int index = -1; 

    for (int i = 0; i < this.size; i++) { 
      if (this.members[i].no == no) {  
        // members 주소에서 i번째 객체를
        // 꺼내서 사용자가 입력한 no와 비교함
        index = i; //일치하는 값을 찾았으면 Index에 저장함
        break;
      }
    }

    if(index == -1) { 
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    // 인덱스의 앞번호에서 시작해서
    for(int i = index + 1; i < this.size; i++ ) { 
      // i번째 회원을 앞 배열로 이동
      this.members[i - 1] = this.members[i];
      // 빈 마지막칸을 null로 지정
      // 메모리를 효울적으로 관리하기위해
      // 한칸 줄이고 null을 넣어줌
    } this.members[--this.size] = null; 

    // 한칸씩 땡겨주지 않으면 사용하지 않는 배열이지만
    // 주소가 그래도 남아있기 때문에 
    // 가비지가 되지 않고, 사용도 하지 않는 메모리로 남게됨
    // 

    System.out.println("회원을 삭제하였습니다.");
    return;
  }

}
