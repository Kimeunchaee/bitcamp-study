package com.eomcs.pms0902.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0902.pms.domain.Board;
import com.eomcs.pms0902.util.Prompt;

public class BoardAddHandler extends AbstractBoardHandler implements Command {

  public BoardAddHandler(List<Board> boardList) {
    super(boardList);
  }

  //public void add() {
  @Override
  public void  execute() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));

    board.setWriter(AuthLoginHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
  }
}






