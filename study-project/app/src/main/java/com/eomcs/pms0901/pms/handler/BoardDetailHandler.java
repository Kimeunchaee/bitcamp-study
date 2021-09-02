package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Board;
import com.eomcs.pms0901.util.Prompt;

public class BoardDetailHandler extends AbstractBoardHandler {

  List<Board> boardList;

  //기존
  //  public BoardDetailHandler(List<Board> boardList) {
  //    this.boardList = boardList;
  //  }

  // 수정
  // AbstractBoardHandler에는 기본생성자가 없고
  // list를 받는 생성자만 있다
  public BoardDetailHandler(List<Board> boardList) {
    super(boardList);
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter().getName());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  //부모클래스인 AbstractBoardHandler에 있기 때문에 삭제
  //  @Override
  //  private Board findByNo(int no) {
  //    for (Board board : boardList) {
  //      if (board.getNo() == no) {
  //        return board;
  //      }
  //    }
  //    return null;
  //  }
}







