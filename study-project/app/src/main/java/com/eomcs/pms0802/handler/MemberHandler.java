package com.eomcs.pms0802.handler;

import java.sql.Date;
import com.eomcs.pms0802.domain.Member;
import com.eomcs.pms0802.util.Prompt;
public class MemberHandler {

  //2. 각 핸들러에 노트 중첩클래스 작성
  static class Node{
    Member member;
    Node next;

    public Node(Member member) {
      this.member = member;
    }
  }

  //4. 배열 안쓸꺼니까 삭제
  static final int MAX_LENGTH = 5;
  Member[] members = new Member[MAX_LENGTH];

  int size = 0;
  //3. 노드 필드 추가
  Node head;
  Node tail;

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

    // 4. add기능에 맞게 노드사용 코드작성
    Node node = new Node(member);
    if(head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;


    //    // 1. 배열일때 추가
    //    if(size == this.members.length) {
    //      Member[] arr = new Member[ this.members.length + (this.members.length >> 1) ];
    //      for(int i =0; i < this.size; i++) {
    //        arr[i] = members[i];
    //      }
    //      this.members = arr;
    //      System.out.println("새 Member[]객체를 만듦");
    //    }
    //

    this.members[this.size++] = member;
  }

  public void list() {
    System.out.println("[회원 목록]");

    // 5. list기능에 맞게 노드사용 코드작성 
    if(head == null) {
      return;
    }
    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          node.member.no, 
          node.member.name, 
          node.member.email, 
          node.member.tel, 
          node.member.registeredDate);
      node = node.next;
    } while(node != null);
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

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

    Member member = findByNo(no);

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

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.members[i - 1] = this.members[i];
    }
    this.members[--this.size] = null;

    System.out.println("회원을 삭제하였습니다.");
  }

  boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].name.equals(name)) {
        return true;
      }
    }
    return false;
  }

  private Member findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].no == no) {
        return this.members[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].no == no) {
        return i;
      }
    }
    return -1;
  }

}







