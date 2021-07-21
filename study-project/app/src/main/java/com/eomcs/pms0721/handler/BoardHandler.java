package com.eomcs.pms0721.handler;

import java.sql.Date;
import com.eomcs.pms.pms0719.domain.Board;
import com.eomcs.pms.pms0719.util.Prompt;

public class BoardHandler {

  static final int MAX_LENGTH = 5; 
  Board[] boards = new Board[MAX_LENGTH]; 
  int size = 0;

  public void add(BoardHandler this) { 
    // BoardHandler that 파라미터를 받지않고
    // 인스턴스 변수로 바꿔줌
    // that > this 로 수정
    Board board = new Board();
    this.boards[this.size++] = board;

    while(true) {
      System.out.println("[새 게시글]");
      board.no = Prompt.inputInt("번호? ");  
      board.title =  Prompt.inputString("제목? ");    
      board.content = Prompt.inputString("내용? ");    
      board.writer = Prompt.inputString("작성자? ");
      System.out.println("게시글을 등록하였습니다.");

      board.registeredDate = new Date(System.currentTimeMillis());

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = Prompt.keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();



    }
  }


  public void list(BoardHandler this) {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, this.boards[i].title,
          this.boards[i].writer, this.boards[i].registeredDate,
          this.boards[i].viewCount, this.boards[i].like);
    }
  }




}
