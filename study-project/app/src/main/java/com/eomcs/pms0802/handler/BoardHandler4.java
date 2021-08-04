package com.eomcs.pms0802.handler;

import java.sql.Date;
import com.eomcs.pms0802.domain.Board;
import com.eomcs.pms0802.util.Prompt;

// detail() , delete(), findByNo() 수정
public class BoardHandler4 {

  static final int MAX_LENGTH = 5;

  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  Node head;
  Node tail;


  //----------------------------------------------------------
  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }


  //----------------------------------------------------------
  public void list() {
    System.out.println("[게시글 목록]");
    if (head == null) {
      return;
    }

    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          node.board.no, 
          node.board.title, 
          node.board.writer,
          node.board.registeredDate,
          node.board.viewCount, 
          node.board.like);
      node = node.next;
    } while (node != null);
  }


  //----------------------------------------------------------
  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);
    // findByNo 메서드로 가서 코드 수정해줌


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



  //----------------------------------------------------------
  public void update() {         // 업데이트는 수정할거 없음
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


  //----------------------------------------------------------
  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    // indexOf 대신 findByNo 사용
    //int index = indexOf(no);  //기존코드
    Board board = findByNo(no); //추가

    //if (index == -1) 를 (board == null)로 변경
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    // indexOf 대신에 findByNo메서드 사용했으므로 이 부분은 이제 필요없음
    //    for (int i = index + 1; i < this.size; i++) {
    //      this.boards[i - 1] = this.boards[i];
    //    }
    //    this.boards[--this.size] = null;


    //추가 (보통 중간의 노드의 연결을 끊을때 (삭제)와 만약 마지막노드를 삭제할때 코드를 같이 작성)
    Node node = head;
    Node prev = null;

    while (node != null) {
      if(node.board == board) {
        prev.next = node.next; // 전 노드에 넥스트의 값을 현재노드에 넥스트의 값으로 교체한다
        // 이전노드의 연결을 끊고 다음 노드와 연결한다  
        node.next = null; // 현재 노트의 넥스트 값을 비워준다 (다음노드와 연결을 끊는다)
        break;
      }
      // 현재 노드가 아니라면,
      prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
      node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.
    }
    size--;
    //

    System.out.println("게시글을 삭제하였습니다.");
  }



  //-------------------------------------------------------

  private Board findByNo(int no) {
    //    for (int i = 0; i < this.size; i++) {
    //      if (this.boards[i].no == no) {
    //        return this.boards[i];
    //      }
    //    }
    //    return null;


    // do-while사용코드
    // do 실행문: 조건과 상관 없이 무조건 한 번 작업을 수행한다.
    // while 조건문 : 그 다음 조건이 참(true)이면 반복해서 작업을 수행 한다.

    if (head == null) {
      return null;
    }

    Node node = head;
    do {
      if(node.board.no == no) {
        return node.board;
      }
      node = node.next;
    } while (node != null);
    return null;



    // while 사용코드 (위랑 내용은 같음)
    //    Node node = head;
    //    while (node != null) {
    //      if(node.board.no == no) {
    //        return node.board;
    //      }
    //      node = node.next;
    //    } 
    //    return null;
  }

  // -------------------------------------------------------

  // 이제 이 메서드 사용안함 
  //  private int indexOf(int no) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.boards[i].no == no) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }
  //-------------------------------------------------------

}







