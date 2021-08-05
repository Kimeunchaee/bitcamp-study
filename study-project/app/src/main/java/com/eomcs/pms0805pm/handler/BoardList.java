package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Board;

// 09-a에서 해줬던 작업 (배열크기 변경)
// 여기에 추가
// 이제 핸들러를 직접 변경할 필요없이
// 리스트에서 바꿔주면 유지보수가 쉬워진다
// 즉 High Cohesion의 이점을 이해할수있다

public class BoardList {

  static final int MAX_LENGTH = 5;
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  public void add(Board board) {

    // 배열크기 자동으로 늘리는 코드 추가 (배열사용)
    if(size == boards.length) {
      Board[] arr = new Board[boards.length + (boards.length >> 1)];
      for(int i = 0; i <size; i++) {
        arr[i] = boards[i];
      }
      boards = arr;
    }
    this.boards[this.size++] = board;  //기존코드

  }

  public Board[] toArray() {
    Board[] arr = new Board[this.size];
    for (int i = 0; i < this.size; i++) { 
      arr[i] = boards[i];
    }
    return arr;
  }

  public Board findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (boards[i].no == no) {
        return boards[i];
      }
    }
    return null;
  }

  public boolean remove(Board board) {
    int index = indexOf(board);
    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    return true;
  }

  private int indexOf(Board board) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i] == board) {
        return i;
      }
    }
    return -1;
  }
}








