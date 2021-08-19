package com.eomcs.pms0819.menu;

import com.eomcs.pms0809.util.Prompt;
import com.eomcs.pms0819.handler.Stack;

public class MenuGroup extends Menu {

  // 메뉴가 bread crumb 목록 보관
  // 모든 메뉴가 공유할 객체이기 때문에 스태틱으로 선언한다
  static Stack breadCrumd = new Stack();


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

  // 메뉴를 실행(execute())할때 breadCrumd 에 대해서 추가
  @Override 
  public void execute() {

    // 현재 실행하는 메뉴를 스택에 저장한다
    breadCrumd.push(this);

    while (true) {
      //System.out.printf("\n[%s]\n", this.title);
      System.out.printf("\n[%s]\n", getBreadCrumd());
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
      }

      if (!disablePrevMenu) {
        System.out.printf("0. %s\n", this.prevMenuTitle);
      }

      int menuNo = Prompt.inputInt("선택> ");
      if (menuNo == 0 && !disablePrevMenu) {
        //현재 메뉴에서 나갈 때 스택에서 제거한다.
        breadCrumd.pop();
        return;
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo - 1].execute();
    }
  }

  //추가
  private String getBreadCrumd() {
    String path = "";

    for(int i = 0; i < breadCrumd.size(); i++) {
      if(path.length() > 0) {
        path += "/";
      }
      Menu menu = (Menu) breadCrumd.get(i);
      path += menu.title;
    }
    return path;
  }


}
