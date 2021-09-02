package com.eomcs.pms0719.handler;


import java.sql.Date;
import com.eomcs.pms0722.domain.Board;
import com.eomcs.pms0722.util.Prompt;

public class BoardHandler {

  static final int MAX_LENGTH = 5;

  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  // -----------------------------------------------------------------------
  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    this.boards[this.size++] = board;
    System.out.println("게시글을 등록하였습니다.");
  }



  //-----------------------------------------------------------------------
  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {

      Board b = this.boards[i]; 

      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          b.no, 
          b.title, 
          b.writer,
          b.registeredDate,
          b.viewCount, 
          b.like
          );
    }
  }


  //-----------------------------------------------------------------------
  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = null;


    for (int i = 0; i < this.size; i++) { 
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break; 
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return; 
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }




  //-----------------------------------------------------------------------
  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = null;


    for (int i = 0; i < this.size; i++) {     
      if (this.boards[i].no == no) {   

        board = this.boards[i]; 
        break;
      }
    }

    if (board == null) {  
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String label = String.format("제목(%s)? ", board.title);
    String title = Prompt.inputString(label);

    label = String.format("내용(%s)? ", board.content);
    String content = Prompt.inputString(label);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {  
      System.out.println("게시글 변경을 취소하였습니다.");
      return; 
    }



    board.title = title; 
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  //-----------------------------------------------------------------------
  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");


    int boardIndex = -1; 

    for (int i = 0; i < this.size; i++) { 
      if (this.boards[i].no == no) {  
        boardIndex = i;
        break;
      }
    }

    if(boardIndex == -1) { 
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for(int i = boardIndex + 1; i < this.size; i++ ) { 
      this.boards[i - 1] = this.boards[i];
    } this.boards[--this.size] = null; 

    System.out.println("게시글을 삭제하였습니다.");
    return;
  }
}
