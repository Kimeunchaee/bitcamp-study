package com.eomcs.pms0802.handler;

import java.sql.Date;
import com.eomcs.pms0802.domain.Board;
import com.eomcs.pms0802.util.Prompt;

// detail() , delete(), findByNo() 수정
public class BoardHandler5 {

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



    Node node = head;
    Node prev = null;

    while (node != null) {

      // 1단계 - 마지막노드(테일노드)를 삭제할때 코드 작성
      // <방법1>
      //      if(node.board == board) {
      //        prev.next = node.next; 
      //      }
      //
      //      //기존코드 수정 및 추가
      //      if(node.next != null) {   //현재노드가 null이 아니라면
      //        node.next = null;       // 다음 노드와의 연결을 끊는다
      //      } 
      //
      //      else {                //삭제할 노드가 마지막 노드라면
      //        tail = prev;        //이전 노드를 마지막 노드로 설정한다
      //      } 
      //      break;
      //    }
      //
      //    
      //    

      // <방법2> - 마지막 노드 삭제했을때
      //      if(node.board == board) {
      //        prev.next = node.next; 
      //        node.next = null;


      //        //추가
      //        if(node == tail){ // 노드가 테일이라면
      //          tail = prev; //이전노드를 마지막노드로 설정한다
      //        }
      //        break;
      //      }



      // 2단계 - 맨처음노드(헤드노드)를 삭제했을때 코드 작성
      if(node.board == board) {

        if(node == head) {      //노드가 헤드라면
          head = node.next;     // 현재 노드를 헤드노드에 넣는다
        } else {                // 그렇지 않으면
          prev.next = node.next;    // 이전노드를 다음 노드와 연결한다
        }
        node.next = null;

        if(node == tail){ 
          tail = prev; 
        }

        break;
      }
      // 다음단계 - 헤드와 테일이 같을때 = 노드가 한개일때는
      // if(node == head) 이 코드에서 걸러지고
      // if(node == tail) 이 코드에서 걸러지기때문에
      // 따로 작성해줄 필요없음


      prev = node;   
      node = node.next; 
    }
    size--;
    System.out.println("게시글을 삭제하였습니다.");
  }



  //-------------------------------------------------------

  private Board findByNo(int no) {
    Node node = head;
    while (node != null) {
      if(node.board.no == no) {
        return node.board;
      }
      node = node.next;
    } 
    return null;
  }


}







