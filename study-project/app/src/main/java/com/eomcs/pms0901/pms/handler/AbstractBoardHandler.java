package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Board;

// 추상클래스로 만들기
//직접 인스턴스 생성X
// 상속받는 자식클래스에서 인스턴스를 만들어서 사용한다
public abstract class AbstractBoardHandler {

  // 자식클래스까지 접근가능
  protected List<Board> boardList;

  public AbstractBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  // 내부적으로 사용 (protected 접근범위 : 자식클래스까지만 사용할수 있다)
  protected Board findByNo(int no) {
    for (Board board : boardList) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}







