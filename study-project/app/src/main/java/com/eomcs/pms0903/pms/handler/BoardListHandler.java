package com.eomcs.pms0903.pms.handler;

import java.util.List;
import com.eomcs.pms0903.pms.domain.Board;

public class BoardListHandler extends AbstractBoardHandler implements Command {

  public BoardListHandler(List<Board> boardList) {
    super(boardList);
  }

  //public void list() {
  @Override
  public void execute() {
    System.out.println("[게시글 목록]");

    for (Board board : boardList) {
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







