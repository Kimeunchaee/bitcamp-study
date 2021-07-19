package com.eomcs.pms.pms0717.handler;

import java.sql.Date;
import com.eomcs.pms.pms0717.domain.Board;
import com.eomcs.pms.pms0717.util.Prompt;

public class BoardHandler3 {
  static Board[] boards = new Board[100];
  static int size = 0;

  public static void add() {
    Board board = new Board();

    boards[size++] = board;

    while(true) {
      System.out.println("[게시글 목록3]");
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


  public static void list() {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          boards[i].no, boards[i].title,
          boards[i].writer, boards[i].registeredDate,
          boards[i].viewCount, boards[i].like);
    }
  }
}

