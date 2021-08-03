package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.handler.BoardHandler;

public class BoardDeleteMenu extends Menu {

  BoardHandler boardhandler;

  public BoardDeleteMenu(BoardHandler boardHandler) {
    super("삭제");
    this.boardhandler = boardHandler;
  }

  @Override
  public void execute() {
    boardhandler.delete();

  }

}
