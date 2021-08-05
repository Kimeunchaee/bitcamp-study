package com.eomcs.pms0805.handler;

import java.sql.Date;
import com.eomcs.pms0805.domain.Board;
import com.eomcs.pms0805.util.Prompt;

public class BoardHandler {

  // 1. 보드리스트 클래스로 빼준다
  //  static final int MAX_LENGTH = 5;
  //  Board[] boards = new Board[MAX_LENGTH];
  //  int size = 0;

  // 3. 보드리스트를 불러오기
  BoardList boardList =  new BoardList();



  //-----------------------------------------------------
  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    //2. 보드리스트로 옮기기
    //this.boards[this.size++] = board;

    // 4. 보드리스트에 add불러와서 사용
    boardList.add(board);

  }




  //-----------------------------------------------------
  public void list() {
    System.out.println("[게시글 목록]");

    // 5. toArrat메서드 사용
    Board[] list = boardList.toArray();

    // 6 for문의 조건,증가문을 수정한다
    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          // 기존코드 this.boards[i].no, 
          //수정
          board.no, 
          board.title, 
          board.writer,
          board.registeredDate,
          board.viewCount, 
          board.like);
    }
  }




  //-----------------------------------------------------
  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    // 7. findByNo 메서드로 가서 수정
    // 앞에 boardList. 클래스명 써주기
    Board board = boardList.findByNo(no);

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




  //-----------------------------------------------------
  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    // boardList. 추가
    Board board = boardList.findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }




  //-----------------------------------------------------
  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");


    // 수정
    // 기존코드 int index = indexOf(no);
    Board board = boardList.findByNo(no);

    //기존코드 if (index == -1) {
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    //추가
    boardList.remove(board);

    //보드리스트로 이동
    //    for (int i = index + 1; i < this.size; i++) {
    //      this.boards[i - 1] = this.boards[i];
    //    }
    //    this.boards[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }





  //-----------------------------------------------------
  //  private Board findByNo(int no) {
  // *findByNo 메서드를 핸들러에서 사용할 경우
  //    //추가
  //    Board[] list = boardList.toArray();
  //
  //    //for문 수정 (배열 -> 보드리스트의 변수명으로)
  //    for (Board board : list) {
  //      if (board.no == no) {
  //        return board;
  //      }
  //    }
  //    return null;
  //  }


  //-----------------------------------------------------
  // 리스트로 옮김
  //  private int indexOf(int no) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.boards[i].no == no) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }


}







