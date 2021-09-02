package com.eomcs.pms0901.pms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.pms0901.pms.domain.Board;
import com.eomcs.pms0901.util.Prompt;

// AbstractBoardHandler를 상속받는다
public class BoardAddHandler extends AbstractBoardHandler {

  List<Board> boardList;

  // 기존
  //  public BoardAddHandler(List<Board> boardList) {
  //    this.boardList = boardList;
  //  }

  // 수정
  // AbstractBoardHandler에는 기본생성자가 없고
  // list를 받는 생성자만 있다
  public BoardAddHandler(List<Board> boardList) {
    super(boardList);
  }

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(AuthHandler.getLoginUser());
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
  }

}







