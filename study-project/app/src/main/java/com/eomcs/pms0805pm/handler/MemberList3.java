package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Member;

//- 상속
// 서브클래스의 공통필드들을 수퍼클래스로 정의한다

//extends ArrayList 상속 추가
public class MemberList3 extends ArrayList{

  // MemberList3에서 다뤄줘야하는 데이터만 남는다
  // findByNo는 형변환이 각각 다르기때문에
  // 중복될수 밖에 없다(각각 넣어줘야한다)

  public Member findByNo(int no) {

    Object[] arr = toArray();

    for(Object obj : arr) {
      Member member = (Member) obj; //형변환 미리선언
      if(member.no == no) { 
        return member;
      }
    }
    return null;
  }


  public boolean exist(String name) {
    Object[] arr = toArray();

    for(Object obj : arr) {
      Member member = (Member) obj; 
      if(member.name == name) { 
        return true;
      }
    }
    return false;
  }
}
