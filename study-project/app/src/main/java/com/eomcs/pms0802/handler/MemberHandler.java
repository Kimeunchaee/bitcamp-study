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
  //  static final int MAX_LENGTH = 5;
  //  Member[] members = new Member[MAX_LENGTH];

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

    // 5. add기능에 맞게 노드사용 코드작성
    Node node = new Node(member);
    if(head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;


    //    // 1. 배열을 사용하는 경우 배열 증가 시키기
    //    if(size == this.members.length) {
    //      Member[] arr = new Member[ this.members.length + (this.members.length >> 1) ];
    //      for(int i =0; i < this.size; i++) {
    //        arr[i] = members[i];
    //      }
    //      this.members = arr;
    //      System.out.println("새 Member[]객체를 만듦");
    //    }
    //

    //this.members[this.size++] = member;
  }

  public void list() {
    System.out.println("[회원 목록]");

    // 6. list기능에 맞게 노드사용 코드작성 
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

    // detail에서 사용된 메서드를 수정해줌
    // 7. findByNo(no) 메서드 수정
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

    // 9. delete기능을 하는 코드를 노드를 사용해서 작성

    // 삭제 int index = indexOf(no);
    Member member = findByNo(no);

    // 수정 if (index == -1) {
    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    //    for (int i = index + 1; i < this.size; i++) {
    //      this.members[i - 1] = this.members[i];
    //    }
    //    this.members[--this.size] = null;

    //삭제하는 기능 작성
    Node node = head;
    Node prev = null;

    // 10. 중간 노드를 삭제할때 (보통의경우)
    //    while(node != null) {
    //      if(node.member == member) {
    //        prev.next = node.next; //이전노드 연결끊고 그 다음 노드로 연결 (1개 삭제했으니까)
    //        node.next = null; //다음노드와 연결을 끊음
    //        break;
    //      }
    //      // 현재 노드가 아니라면,
    //      prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
    //      node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.
    //    }
    //    size--;



    // 11. 중간노드 삭제 + 마지막노드 삭체하는 경우도 추가
    //    while(node != null) {
    //      if(node.member == member) {
    //        prev.next = node.next;
    //        node.next = null;
    //
    //        //추가
    //        if(node == tail) {
    //          tail = prev;
    //        }
    //        break;
    //      }
    //      prev = node; 
    //      node = node.next; 
    //    }
    //    size--;




    // 12. 중간노드 삭제 + 마지막노드 삭제 + 맨처음노드 삭제 추가
    while(node != null) {
      if(node.member == member) {

        //추가
        if(node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }
        node.next = null;


        if(node == tail) {
          tail = prev;
        }
        break;
      }
      prev = node; 
      node = node.next; 
    }
    size--;
    System.out.println("회원을 삭제하였습니다.");
  }


  // 13. exist메서드는 배열을 사용하고있기때문에
  // 노드로 바꿔줌
  boolean exist(String name) {
    Node node = head;

    while (node != null) {
      if(node.member.name.equals(name)) {
        return true;
      }
      node = node.next;
    }

    return false;
  }

  private Member findByNo(int no) {
    //    for (int i = 0; i < this.size; i++) {
    //      if (this.members[i].no == no) {
    //        return this.members[i];
    //      }
    //    }
    //    return null;


    // 8. for문 사용하지 않고 번호를 찾는 코드를
    // 노드를 사용해서 작성

    Node node = head;
    do {
      if(node.member.no == no) {
        return node.member;
      }
      node = node.next;
    } while(node != null);
    return null;
  }



  //  private Member findByNo(int no) {
  //    Node node = head;
  //
  //    while (node != null) {
  //      if (node.member.no == no) {
  //        return node.member;
  //      }
  //      node = node.next;
  //    }
  //
  //    return null;
  //  }


}



//  private int indexOf(int no) {
//    for (int i = 0; i < this.size; i++) {
//      if (this.members[i].no == no) {
//        return i;
//      }
//    }
//    return -1;
//  }







