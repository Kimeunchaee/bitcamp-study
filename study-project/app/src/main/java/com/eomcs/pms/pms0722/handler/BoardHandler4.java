package com.eomcs.pms.pms0722.handler;

import java.sql.Date;
import com.eomcs.pms.pms0722.domain.Board;
import com.eomcs.pms.pms0722.util.Prompt;

public class BoardHandler4 {


  //메소드끼리 공유하는 변수 MAX_LENGTH / boards / size
  // 그 중에 boards와 size 두가지 변수는 개별적으로 관리하기위해
  // 인스턴스 필드로 선언한다
  //개별적 관리라는 뜻은 (=) add, list 등을 딱 한번이 아닌
  // 여러번 사용한다는 뜻

  // 모든 게시판의 최대 배열 개수가 같기 때문에 다음 변수는 
  // 그냥 static 필드로 남겨둔다.
  // 공동으로 사용하는 값은 스태틱 필드로 선언한다.
  static final int MAX_LENGTH = 5;

  // 게시판 마다 따로 관리해야 하기 때문에 인스턴스 필드로 전환한다.
  // 개별적으로 관리해야 하는 값은 인스턴스 필드로 선언한다.
  // => static 옵션을 뺀다.
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
    //    board.viewCount = 0; // 인스턴스 변수는 생성되는 순간 기본 값이 0으로 설정된다.

    this.boards[this.size++] = board;
    System.out.println("게시글을 등록하였습니다.");
  }



  //-----------------------------------------------------------------------
  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {

      Board b = this.boards[i]; 
      //this.boards[i] 를 변수명 b로 지정

      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          b.no, 
          b.title, 
          b.writer,
          b.registeredDate,
          b.viewCount, 
          b.like);
    }
  }


  //-----------------------------------------------------------------------
  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = null;
    // 디테일 메소드에서 board 변수를 만들어서 실행결과들을 저장
    // 변수 사용전 null 비워주기

    for (int i = 0; i < this.size; i++) {    //BoardHandler클래스의 size 인스턴스 변수
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break; // if문이 중단되고 for문을 빠져나간뒤 나머지 코드를 실행함
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return; // 메소드의 모든 실행을 끝냄
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

    // Board 인스턴스가 들어있는 배열을 뒤져서
    //게시글 번호와 일치하는  Board인스턴스를 찾는다
    for (int i = 0; i < this.size; i++) {           // i는 0부터 배열개수(배열 크키만큼)만큼 반복한다 
      if (this.boards[i].no == no) {    //this 는 메소드사 사용한 변수 
        // 여기서는 BoardHandler의 변수인 boards 와 size 를 가리킴
        board = this.boards[i];   // board 안에 no,title ... 각각의 변수들이 있으므로 인스턴스라고 생각하면 된다
        break;
      }
    }

    if (board == null) {  //boar에 주소가 저장되지 않았을 경우
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String label = String.format("제목(%s)? ", board.title);
    String title = Prompt.inputString(label);

    label = String.format("내용(%s)? ", board.content);
    String content = Prompt.inputString(label);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {  // input.length() == 0 빈문자열이면
      System.out.println("게시글 변경을 취소하였습니다.");
      return; // 메소드의 모든 실행을 종료시킴
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }


  // 2 에서는 반복문을 2번사용해야했는데
  // 배열의 시작점을 다른방법으로 지정해줘서
  // 작성하는방법

  //-----------------------------------------------------------------------
  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int boardIndex = -1;
    Board board = null;

    for (int i = 0; i < this.size; i++) { 
      if (this.boards[i].no == no) {  
        boardIndex = i; 
        break;
      }
    } 
    System.out.println("해당 번호의 게시글이 없습니다.");
    return;

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n")) {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }

    for(int i = boardIndex + 1; < this.size; i++ ) { 
      this.boards[i - 1] = this.boards[i];
    } this.boards[--this.size] = null; 

    System.out.println("게시글을 삭제하였습니다.");
    return;
  }

}

