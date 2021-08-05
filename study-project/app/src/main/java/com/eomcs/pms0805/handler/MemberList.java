package com.eomcs.pms0805.handler;

import com.eomcs.pms0805.domain.Member;

public class MemberList {

  //-----------------------------------------------------
  static final int MAX_LENGTH = 5;
  Member[] members = new Member[MAX_LENGTH];
  int size = 0;


  //-----------------------------------------------------
  public void add(Member member) {
    this.members[this.size++] = member;
  }


  //-----------------------------------------------------
  public Member[] toArray() {
    Member[] arr = new Member[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = members[i];
    }
    return arr; 
  }


  //-----------------------------------------------------
  public Member findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].no == no) {
        return this.members[i];
      }
    }
    return null;
  }


  //-----------------------------------------------------
  private int indexOf (Member member) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i] == member) {
        return i;
      }
    }
    return -1;
  }


  //-----------------------------------------------------
  // boolean 타입으로 만들기
  public boolean remove(Member member) {

    int index = indexOf(member);
    if(index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.members[i - 1] = this.members[i];
    }
    this.members[--this.size] = null;

    return true;
  }


  //-----------------------------------------------------
  // 멤버핸들러에 만든 메서드인 exist
  //  exist는 멤버핸들러에서 사용하지 않고 프로젝트핸들러에서 사용하지만
  //  exist가 사용하는 정보는 멤버이기때문에 멤버 리스트에서 다루도록 옮겨준다
  // 실제 정보를 가지고 있는 클래스로 메서드를 옮기는 것이 유지보수에 더 낫다

  // 프로젝트핸들러는 기존에 exist를 멤버핸들러에서 가져와서 썼지만
  // 이제 멤버리스트에서 exist를 가져다 쓰도록 수정해준다

  // public으로 수정
  public boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.members[i].name.equals(name)) {
        return true;
      }
    }
    return false;
  }

}
