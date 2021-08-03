package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.BoardHandler;

public class BoardUpdateMenu extends Menu {

  BoardHandler boardhandler;

  public BoardUpdateMenu(BoardHandler boardHandler) {
    super("변경");
    this.boardhandler = boardHandler;
  }

  @Override
  public void execute() {
    boardhandler.update();

  }

}
