package com.eomcs.pms.p0721.handler;

import java.sql.Date;
import com.eomcs.pms.p0721.domain.Board;
import com.eomcs.pms.p0721.util.Prompt;

public class BoardHandler2 {

  static final int MAX_LENGTH = 5;

  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    this.boards[this.size++] = board;
  }

  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer,
          this.boards[i].registeredDate,
          this.boards[i].viewCount, 
          this.boards[i].like);
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int number = Prompt.inputInt("번호? ");

    Board board = new Board();

    if(board.no == number) {
      System.out.printf("제목: $s\n ", board.title);
      System.out.printf("내용: $s\n ", board.content);
      System.out.printf("작성자: $s\n ", board.writer);
      System.out.printf("등록일: $s\n ", board.registeredDate);
      System.out.printf("조회수: $d\n ", board.viewCount);

    } else if (board.no == null) {   //여기서 왜 no에 null하면 안디ㅗ고 board에 해줘야되는지
      System.out.println("해당 번호의 게시글이 없습니다.");
    }






  }



}

