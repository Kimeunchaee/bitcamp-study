package com.eomcs.pms0820.pms.handler;

import java.sql.Date;
import com.eomcs.pms0820.pms.domain.Board;
import com.eomcs.pms0820.util.List;
import com.eomcs.pms0820.util.Prompt;

public class BoardHandler {

  //List boardList;
  List<Board> boardList;

  //public BoardHandler(List boardList) {
  public BoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  public void add() {
    System.out.println("[새 게시글]");


    Board board = new Board();

    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(board);
  }

  public void list() {
    System.out.println("[게시글 목록]");

    //기존
    //Object[] list = boardList.toArray();
    //현재 BoardList에 보관된 값을 담을 수 있는 만큼 크기의 배열을 생성한다
    Board[]  boards = new Board[boardList.size()];

    // 배열을 파라미터로 넘겨서 값을 받아 온다
    // => 넘겨주는 배열의 크기가 충분하지 않기 때문에 toArray()는 새 배열을 만들지 않을것ㄱ이다
    boardList.toArray(boards);

    // 이렇게 제네릭이 적용된 List를 사용하면
    //List에서 값을 꺼낼때다마 형변환 할 필요어가 없어 프로그래밍이 편리하다

    //----기존 (형변환 상태)
    //for (Object obj : list) {
    //Board board = (Board) obj;

    //----변경 (형변환 안함)
    for(Board board : boards) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());

    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
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

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    boardList.remove(board);

    System.out.println("게시글을 삭제하였습니다.");
  }



  private Board findByNo(int no) {
    // 일부러 BoardList에 들어있는 배열보다 작은 배열을 넘겨준다
    // 그러면 toArray()는 새 배열을 만들어 값을 저장한 후 리턴할것이다
    //Object[] arr = boardList.toArray();

    Board[] arr = boardList.toArray(new Board[0]);

    for (Board board : arr) {
      //for (Object obj : arr) {
      //Board board = (Board) obj;
      if (board.getNo() == no) {
        return board;
      }
    }
    return null;
  }
}






