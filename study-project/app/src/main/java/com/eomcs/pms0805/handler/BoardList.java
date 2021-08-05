package com.eomcs.pms0805.handler;

import com.eomcs.pms0805.domain.Board;

// 별도의 클래스로 캡슐화
// 복잡한 코드를 감춘다
// 핸들러에서 메서드만 호출해서 간결하게 사용하도록 할수 있고
// 유지보수가 쉬워진다

public class BoardList {

  // 1. 핸들러에서 리스트를 관리하는 코드 가지고오기
  static final int MAX_LENGTH = 5;
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;




  //-----------------------------------------------------
  // 2. 보드 크기를 증가하는 코드를 따로 분리함
  public void add (Board board) {
    this.boards[this.size++] = board;
  } 




  //-----------------------------------------------------
  // 3.  새 배열을 만듦
  public Board[] toArray() {
    Board[] arr = new Board[this.size]; // 배열의 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다
    for(int i = 0; i < this.size; i++) { // 배열에 저장된 값을 새 배열에 복사한다
      arr[i] = boards[i];
    }
    return arr; // 새 배열을 리턴한다
  }




  //-----------------------------------------------------
  //4. findByNo 가지고 오기
  // private > public 으로 수정
  public Board findByNo(int no) {
    //    //추가
    //    Board[] list = boardList.toArray();
    //    //for문 수정 (배열 -> 보드리스트의 변수명으로)
    //    for (Board board : list) {
    //      if (board.no == no) {
    //        return board;
    //      }
    //    }
    //    return null;

    //다시 원래대로 수정
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    }
    return null;
  }


  //-----------------------------------------------------
  // 5. 인덱스를 삭제하는 코드를 보드리스트로 이동 (보드핸들러의 delete안에 있었음)
  // 메서드명 remove로 만들어서 넣기
  // 기존 public Board remove (Board board) > boolean 으로 수정
  public boolean remove (Board board) {

    //새로 작성
    // remove메서드를 보드객체가 존재하지 않을때(무효한값인 -1일때) 사용하려고 하면
    // false로 리턴한다 (remove메서드가 실행되지 않고 사용하지 못하도록)
    int index = indexOf(board);
    if(index == -1) {               
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    //새로 작성
    return true;
  }


  //-----------------------------------------------------
  // 6. indexOf 가지고 오기
  // 기존 private int indexOf(int no) {
  private int indexOf(Board board) {  //이제 번호가 아닌 보드객체 자체를 찾음
    // 메서드를 호출하는 쪽(핸들러)에서 원하는 객체(예. no) 를 선택할수 있음

    for (int i = 0; i < this.size; i++) {
      // 기존코드 if (this.boards[i].no == no) {
      if (this.boards[i] == board) {        // 보드객체 자체를 찾도록 수정
        return i;
      }
    }
    return -1;
  }

}