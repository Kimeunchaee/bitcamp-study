package com.eomcs.pms0902.pms.handler;

import java.util.List;
import com.eomcs.pms0902.pms.domain.Board;

public abstract class AbstractBoardHandler {

  protected List<Board> boardList;

  public AbstractBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  protected Board findByNo(int no) {
    for (Board board : boardList) {
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}






