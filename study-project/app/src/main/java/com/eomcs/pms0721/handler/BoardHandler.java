package com.eomcs.pms0721.handler;

import java.sql.Date;
import com.eomcs.pms0721.domain.Board;
import com.eomcs.pms0721.util.Prompt;

public class BoardHandler {

  static final int MAX_LENGTH = 5; 
  Board[] boards = new Board[MAX_LENGTH]; 
  int size = 0;

  public void add() { 
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


  public void list() {
    System.out.println("----------------출력----------------");
    for(int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, this.boards[i].title,
          this.boards[i].writer, this.boards[i].registeredDate,
          this.boards[i].viewCount, this.boards[i].like);
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = null;
    // 디테일 메소드에서 board 변수를 만들어서 실행결과들을 저장
    // 변수 사용전 null 비워주기

    for (int i = 0; i < this.size; i++) {    //BoardHandler클래스의 size 인스턴스 변수
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break; // if문이 중단되고 for문을 빠져나간다
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


  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = null;

    for (int i = 0; i < this.size; i++) {
      if (boards[i].no == no) {
        board = boards[i];
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






}
