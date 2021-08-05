package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Member;

//- 상속 (링크드리스트을 사용한 List)

//1. LinkedList 수퍼클래스 만들기
//2. 공통된 코드 추출하기 (링크드리스트을 사용한 List)
//3. 각각의 List4에서 LinkedList를 상속받고 필요없는 코드 지우고 수정하기

public class MemberList4 extends LinkedList4 {

  //상속받은 수퍼클래스에서 사용할수 있는 공통된 메서드들은 지워준다


  public Member findByNo(int no) {

    // 기존코드 Node를 사용하지 않고
    // toArray() 사용해서 번호찾는거로 수정

    Object[] list = toArray();
    for(Object obj : list) {
      Member member = (Member) obj;
      if(member.no == no) {
        return member;
      }
    }
    return null;

  }


  public boolean exist(String name) {

    // 기존코드
    //    Node node = head;
    //    while (node != null) {
    //      if(node.member.name.equals(name)) {
    //        return true;
    //      }
    //      node = node.next;
    //    }
    //    return false;


    Object[] list = toArray();
    for(Object obj : list) {
      Member member = (Member) obj;
      if(member.name.equals(name)) {
        return true;
      }
    }
    return false;
  }


}








