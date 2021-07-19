package com.eomcs.pms.pms0717.handler;

import java.sql.Date;
import com.eomcs.pms.pms0717.domain.Board;
import com.eomcs.pms.pms0717.util.Prompt;

public class BoardHandler {
  static Board[] boards = new Board[100];
  static int size = 0;

  public static void add() {
    Board board = new Board();

    while(true) {
      System.out.println("[새 게시글]");
      board.no = Prompt.inputInt("번호? ");  
      board.title =  Prompt.inputString("제목? ");    
      board.content = Prompt.inputString("내용? ");    
      board.writer = Prompt.inputString("작성자? ");
      System.out.println("게시글을 등록하였습니다.");

      board.registeredDate = new Date(System.currentTimeMillis());
      board.viewCount = new int();

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = Prompt.keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();
      boards[size++] = board;

      /* 네가 작성하던거
      for(int i = 0; i < size; i++) {
        System.out.println(board.registeredDate);
        System.out.println(board.viewCount);
      }
       */
    }
  }


  public static void list() {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < size; i++) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n", 
          boards[i].no, boards[i].title, boards[i].content, boards[i].writer, boards[i].registeredDate);
    }
  }








}
