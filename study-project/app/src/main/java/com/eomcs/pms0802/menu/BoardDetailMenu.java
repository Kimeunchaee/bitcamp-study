package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.BoardHandler;

public class BoardDetailMenu extends Menu {

  BoardHandler boardhandler;

  public BoardDetailMenu(BoardHandler boardHandler) {
    super("상세보기");
    this.boardhandler = boardHandler;
  }

  @Override
  public void execute() {
    boardhandler.detail();

  }

}
