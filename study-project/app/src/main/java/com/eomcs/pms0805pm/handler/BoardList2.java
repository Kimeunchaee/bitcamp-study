package com.eomcs.pms0805pm.handler;

import com.eomcs.pms0805pm.domain.Board;

// 09-a,b에서 해줬던 작업
// 여기에 추가
// 이제 핸들러를 직접 변경할 필요없이
// 리스트에서 바꿔주면 유지보수가 쉬워진다
// 즉 High Cohesion의 이점을 이해할수있다

public class BoardList2 {

  //Node 사용해서 작성하는거 추가
  static class Node {
    Board board;
    Node next;
    public Node(Board board) {
      this.board = board;
    }
  }

  int size = 0;
  Node head;
  Node tail;

  public void add(Board board) {

    //배열크기 자동으로 늘리는 코드 추가 (Node 사용)
    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }

  public Board[] toArray() {

    Board[] arr = new Board[this.size];

    //    if (head == null) {
    //      //기존코드 return
    //      return arr;  //아무것도 없을때 null일때 빈배열이라도 리턴해줘야함 그래야 오류안생김
    //    }
    // 이 코드는 경국 아래 while문에서도 실행되는 내용이기때문에 필요없음


    // while문 사용
    //    Node node = head;
    //    int i = 0;
    //    while (node != null) {      // 노드가 null일때 
    //      arr[i++] = node.board;    //노드의 보드객체를 새 배열에 담고 i++ 증가시킨다
    //      node = node.next; //다음노드 주소를 현재노드에 담는다
    //    }
    //    return arr; //새배열을 리턴한다 


    // 위에 똑같은 코드를 for문으로 작성할수있음
    Node node = head;
    for(int i = 0; i <this.size; i++) {
      arr[i] = node.board;
      node = node.next;
    }
    return arr;
  }

  public Board findByNo(int no) {
    Node node = head;
    while (node != null) {
      if(node.board.no == no) { //no값이 현재 노드의no와 같다면
        return node.board;
      }
      node = node.next; // 같지 않다면 다음 노드를 현재노드로 바꾼다
    } 
    return null;
  }

  public boolean remove(Board board) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if(node.board == board) { //노드에 들어있는 개체와 같다면
        if(node == head) {     // 삭제할 노드가 첫번째 노드일때
          head = node.next;     //헤드가 두번째 노드를 가리키게 한다
        } else {             // 삭제할 노드가 첫번째노드가 아닐때
          prev.next = node.next;   //이전 노드를 다음 노드와 연결한다
        }
        node.next = null; // 삭제할 노드가 더이상 다음 노드를 가리키지 않게 한다

        if(node == tail){ //삭제할 노드가 마지막노드일때
          tail = prev; // tail이 이전노드를 가리키게 한다
        }
        //break; 말고 boolean타입에 맞게 바꿔줌
        size--;      // 삭제했으니까 size를 감소시킨다
        return true;
      }

      // 현재 노드가 아니라면
      prev = node;      // 현재 노드는 prev에 저장하고
      node = node.next; // node는 다음 노드를 가리킨다
    }

    //추가
    return false; //반복문(while)이 끝날때까지 못찾으면 false한다
  }
}


// 인덱스는 배열일경우만 사용하기때문에
// 링크드리스트에서는 필요없다
//  private int indexOf(Board board) {
//    for (int i = 0; i < this.size; i++) {
//      if (this.boards[i] == board) {
//        return i;
//      }
//    }
//    return -1;
//  }
//}








