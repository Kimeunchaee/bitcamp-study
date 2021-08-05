package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Board;

// *- 상속 (Generalization 일반화)
// *각각의 List들의 메서드들이 다 같은 코드를 사용하고 있으므로
// *공통된 부분을 추출해서 수퍼클래스로 정의해준다

//- 상속
//서브클래스의 공통필드들을 수퍼클래스로 정의한다

// 1. ArrayList 수퍼클래스 만들기
// 2. 공통된 코드 추출하기 (배열을 사용한 List)
// 3.각각의 List3에서 ArrayList를 상속받고 필요없는 코드 지우고 수정하기



// 상속받았으니까 extends ArrayList 추가
public class BoardList3 extends ArrayList3 {

  //*필요없음 상속클래스꺼 사용
  //  static final int MAX_LENGTH = 5;
  //  Board[] boards = new Board[MAX_LENGTH];
  //  int size = 0;

  //*필요없음 상속클래스꺼 사용
  //  public void add(Board board) {
  //    if(size == boards.length) {
  //      Board[] arr = new Board[boards.length + (boards.length >> 1)];
  //      for(int i = 0; i <size; i++) {
  //        arr[i] = boards[i];
  //      }
  //      boards = arr;
  //    }
  //    this.boards[this.size++] = board; 
  //
  //  }

  //*필요없음 상속클래스꺼 사용
  //  public Board[] toArray() {
  //    Board[] arr = new Board[this.size];
  //    for (int i = 0; i < this.size; i++) { 
  //      arr[i] = boards[i];
  //    }
  //    return arr;
  //  }


  // BoardList3에서 다뤄줘야하는 데이터만 남는다
  // 공통된게 아니라 board 객체에 대해서만
  // 해당되는 코드이기때문에 BoardList에서 그대로 사용
  // boards[i] 배열을 board변수로 수정해준다
  public Board findByNo(int no) {
    //기존코드
    //    for (int i = 0; i < this.size; i++) {
    //      if (board.no == no) {
    //        return board;
    //      }
    //    }
    //    return null;

    // board.no 를 찾기위해 필요한 코드를
    // 상속받은 메서드중에서 가져온다
    Object[] arr = toArray();

    //실제 객체가 있는곳을 가리켜주기위해 형변환이 필요하다
    for(Object obj : arr) {
      Board board = (Board) obj; //형변환을 해주기위해 미리 형변환을 선언하고
      if(board.no == no) { //obj를 Board로 형변환한 변수명 : board
        return board;
      }
    }
    return null;
  }


  //*필요없음 상속클래스꺼 사용
  //  public boolean remove(Board board) {
  //    int index = indexOf(board);
  //    if (index == -1) {
  //      return false;
  //    }
  //
  //    for (int i = index + 1; i < this.size; i++) {
  //      this.boards[i - 1] = this.boards[i];
  //    }
  //    this.boards[--this.size] = null;
  //
  //    return true;
  //  }

  //*필요없음 상속클래스꺼 사용
  //  private int indexOf(Board board) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.boards[i] == board) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }
}
