package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Board;

public class BoardListHandler extends AbstractBoardHandler {

  List<Board> boardList;

  //기존
  //  public BoardListHandler(List<Board> boardList) {
  //    this.boardList = boardList;
  //  }

  // 수정
  // AbstractBoardHandler에는 기본생성자가 없고
  // list를 받는 생성자만 있다
  public BoardListHandler(List<Board> boardList) {
    super(boardList);
  }

  public void list() {
    System.out.println("[게시글 목록]");

    Board[] boards = new Board[boardList.size()];

    boardList.toArray(boards);

    for (Board board : boards) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter().getName(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }
  }

}







