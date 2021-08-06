package com.eomcs.pms0806.handler;

import java.sql.Date;
import com.eomcs.pms0806.domain.Board;
import com.eomcs.pms0806.util.Prompt;

public class BoardHandler {

  // 1.BoardList 대신 ArrayList(수퍼클래스) 직접 사용한다
  // 기존 BoardList2 boardList = new BoardList2();
  // 수정 ArrayList boardList = new ArrayList();


  // 6.ArrayList 대신 LinkedList를 사용할수도있다
  // 기존 ArrayList boardList = new ArrayList();
  // 수정 LinkedList boardList = new LinkedList();


  // 7. 같은 타입으로 묶으면(상속) 두 클래스의 객체를 한개의 레퍼런스로 다룰수있다
  // 기존 LinkedList boardList = new LinkedList();
  // List boardList = new LinkedList();     //가능!
  //List boardList = new ArrayList();         //가능!


  // 8. List 객체를 외부에서 주입받는 방식
  // 생성자를 통해 주입받아서 사용할수 있다
  // setter메서드로 만들면 개발자가 까먹고 setter을 사용하지 않을수도 있기때문에
  // 생성자를 통해 주입하는것이 낫다
  // App에 가서 수정해준다

  List boardList;     //의존 객체를 교체하기 쉬워진다
  public BoardHandler(List boardList) {
    this.boardList = boardList;
  }


  // 2.보드리스트에 하나남은 메서드인 findbyNo를 가지고 온다 (맨아래)
  // 3.BoardList는 삭제한다 

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    boardList.add(board);
  }

  public void list() {
    System.out.println("[게시글 목록]");

    Object[] list = boardList.toArray();

    for (Object obj : list) {
      Board board = (Board) obj;
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.no, 
          board.title, 
          board.writer,
          board.registeredDate,
          board.viewCount, 
          board.like);
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    // 5.이제 같은 클래스 안에 있으니까
    // boardList. 필요없음
    // Board board = boardList.findByNo(no);
    Board board = findByNo(no);

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

    // 이제 같은 클래스 안에 있으니까
    // boardList. 필요없음
    // Board board = boardList.findByNo(no);
    Board board = findByNo(no);


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

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    // 이제 같은 클래스 안에 있으니까
    // boardList. 필요없음
    // Board board = boardList.findByNo(no);
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




  // 4.public> private로 바꿔주기
  private Board findByNo(int no) {
    Object[] arr = boardList.toArray();
    // toArray()는 여기서 상속받지 못하고 있기때문에
    //정확히 레퍼런스명을 적어줘야한다
    for (Object obj : arr) {
      Board board = (Board) obj;
      if (board.no == no) {
        return board;
      }
    }
    return null;
  }

}







