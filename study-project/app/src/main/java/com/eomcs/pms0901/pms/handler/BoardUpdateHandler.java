package com.eomcs.pms0901.pms.handler;

import java.util.List;
import com.eomcs.pms0901.pms.domain.Board;
import com.eomcs.pms0901.util.Prompt;

public class BoardUpdateHandler extends AbstractBoardHandler {

  List<Board> boardList;

  //기존
  //  public BoardUpdateHandler(List<Board> boardList) {
  //    this.boardList = boardList;
  //  }

  // 수정
  // AbstractBoardHandler에는 기본생성자가 없고
  // list를 받는 생성자만 있다
  public BoardUpdateHandler(List<Board> boardList) {
    super(boardList);
  }
  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    if(board.getWriter().getNo() != AuthHandler.getLoginUser().getNo()) {
      System.out.println("변경 권한이 없습니다");
      return;
    }


    String title = Prompt.inputString(String.format("제목(%s)? ", board.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.getContent()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.setTitle(title);
    board.setContent(content);
    System.out.println("게시글을 변경하였습니다.");
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







