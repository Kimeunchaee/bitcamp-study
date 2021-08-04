package com.eomcs.pms0802.handler;

import java.sql.Date;
import com.eomcs.pms0802.domain.Board;
import com.eomcs.pms0802.util.Prompt;

// 노드 선언, add(), list() 수정
public class BoardHandler3 {


  static final int MAX_LENGTH = 5;

  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;


  //노드 추가 (값은 저장되어있지 않음, 선언만)
  Node head;
  Node tail;

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    //---------------------------------
    // 새 노드를 만든다. 생성자에 호출할때, 노드에 담을 Board 객체 주소를 넘긴다 
    Node node = new Node(board);
    // add 추가하기전까지는 아무것도 없는 상태임
    // 새로 생성한 노드가 비어있어서 넘길게 아무것도 없을때
    if(head == null) {  // 아무런 노드가 없으면
      tail = head = node;
    } else { //무언가 있으면
      tail.next = node; // 기존에 tail이 가리키는 마지막 노드의 next변수에 새 노드를 가리킴
      tail = node; //새로만든 노드를 마지막 노드로 설정한다
    }
    size++; // size증가시킨다(값을 저장)

    // 이제 배열은 안씀
    //    if(this.size == this.boards.length) {
    //      Board[] arr = new Board[ this.boards.length + (this.boards.length >> 1) ];
    //      for(int i =0; i < this.size; i++) {
    //        arr[i] = boards[i];
    //      }
    //      this.boards = arr;
    //      System.out.println("새 Board[]객체를 만듦");
    //    }
    //---------------------------------

    this.boards[this.size++] = board; 
  }




  public void list() {
    System.out.println("[게시글 목록]");

    // 추가
    if(head == null) {
      return;
    }
    //헤드에 주소가 있다면 노드에 저장
    Node node = head;

    //반복문 for를 do-while로 수정
    do {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          //          this.boards[i].no, 
          //          this.boards[i].title, 
          //          this.boards[i].writer,
          //          this.boards[i].registeredDate,
          //          this.boards[i].viewCount, 
          //          this.boards[i].like);
          node.board.no, 
          node.board.title, 
          node.board.writer,
          node.board.registeredDate,
          node.board.viewCount, 
          node.board.like);
      node = node.next;
    } while (node != null);  //반복문을 다시 실행함 System.out.printf위치로 올라감
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

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

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return i;
      }
    }
    return -1;
  }


}







