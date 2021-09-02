package com.eomcs.pms0901pm2.pms.handler;

import java.util.List;
import com.eomcs.pms0901pm.pms.domain.Board;
import com.eomcs.pms0901pm2.util.Prompt;

public class BoardSearchHandler extends AbstractBoardHandler {

  public BoardSearchHandler(List<Board> boardList) {
    super(boardList);
  }

  public void search() {
    System.out.println("[게시글 검색]");

    String input = Prompt.inputString("검색어?");

    for (Board board : boardList) {
      if (!board.getTitle().contains(input) &&
          !board.getContent().contains(input) &&
          !board.getWriter().getName().contains(input)) {
        continue;
      }
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






