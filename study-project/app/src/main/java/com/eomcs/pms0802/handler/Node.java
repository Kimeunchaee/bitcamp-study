package com.eomcs.pms0802.handler;

import com.eomcs.pms0802.domain.Board;

// 이제 필요없는 파일 (각자핸들러에 넣어줌)
public class Node {
  Board board;
  Node next;

  public Node(Board board) { //생성자만듦
    this.board = board;
  }
}