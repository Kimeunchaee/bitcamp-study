package com.eomcs.pms0827.menu;

import java.util.Stack;
import com.eomcs.pms0827.util.Prompt;



public class MenuGroup extends Menu {

  static Stack breadCrumb = new Stack();

  Menu[] childs = new Menu[100];
  int size;
  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";
  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, boolean disablePrevMenu) {
    super(title);
    this.disablePrevMenu = disablePrevMenu;
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return; 
    }
    this.childs[this.size++] = child; 
  }

  public Menu remove(Menu child) {
    int index = indexOf(child);
    if (index == -1) {
      return null;
    }
    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }
    childs[--this.size] = null;
    return child;
  }

  public int indexOf(Menu child) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  public Menu getMenu(String title) { 
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)) {
        return this.childs[i];
      }
    }
    return null;
  }

  @Override 
  public void execute() {

    breadCrumb.push(this);

    while (true) {
      System.out.printf("\n[%s]\n", getBreadCrumb());
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
      }

      if (!disablePrevMenu) {
        System.out.printf("0. %s\n", this.prevMenuTitle);
      }

      int menuNo = Prompt.inputInt("선택> ");


      //예외 처리 문법 적용
      try {
        if (menuNo == 0 && !disablePrevMenu) {
          breadCrumb.pop();
          return;
        }

        if (menuNo < 0 || menuNo > this.size) {
          System.out.println("무효한 메뉴 번호입니다.");
          continue;
        }

        this.childs[menuNo - 1].execute();

      } catch(Throwable e) {
        // try 블록 안에 있는 코드를 실행하다가 예외가 발생하면
        // 다음 문장을 실행한 후 시스템을 멈추지 않고 실행을 계속한다
        System.out.println("-----------------------------------------");
        System.out.printf("오류 발생 : %s\n", e.getClass().getName());
        System.out.println("-----------------------------------------");
      }
    }
  }

  private String getBreadCrumb() {
    String path = "";

    for (int i = 0; i < breadCrumb.size(); i++) {
      if (path.length() > 0) {
        path += " / ";
      }
      Menu menu = (Menu) breadCrumb.get(i); 
      path += menu.title;
    }

    return path;
  }

}






