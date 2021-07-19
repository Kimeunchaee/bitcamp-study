package com.eomcs.pms.pms0719.handler;

import java.sql.Date;
import com.eomcs.pms.pms0719.domain.Board;
import com.eomcs.pms.pms0719.util.Prompt;

public class BoardHandler {
  static final int MAX_LENGTH = 5; //static 메소드area에 만들어짐 딱 하나
  Board[] boards = new Board[MAX_LENGTH]; // //static없는 변수는 여러개 만들수있음 heap(?)
  int size = 0;

  public static void add(BoardHandler that) {  //static 없으면 공유할수 없기때문에 that 인스턴스 주소가 있어야한다
    Board board = new Board();
    that.boards[that.size++] = board;

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


  public static void list(BoardHandler that) {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < that.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          that.boards[i].no, that.boards[i].title,
          that.boards[i].writer, that.boards[i].registeredDate,
          that.boards[i].viewCount, that.boards[i].like);
    }
  }




}
