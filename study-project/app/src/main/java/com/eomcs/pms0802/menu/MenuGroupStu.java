package com.eomcs.pms0802.menu;

import com.eomcs.pms0802.util.Prompt;

public class MenuGroupStu extends Menu {

  Menu[] childs = new Menu[100];
  int size;
  String prevMenuTitle =  "이전메뉴";


  public MenuGroupStu(String title) {
    super(title);
  }


  public void add(Menu childMenu) {
    if(this.size == this.childs.length) {
      return;
    }
    this.childs[this.size++] = childMenu;

  }

  public int indexOf (Menu childindex) {
    for(int i = 0; i < this.size; i++) {
      if(childs[i] == childindex) {
        return i;
      }
    }
    return -1;
  }

  public Menu remove(Menu child) {

    int index = indexOf(child);

    if(index == -1) {
      return null;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }
    this.childs[--this.size] = null;
    return child;
  }



  public Menu getMenu(String title) {

    for(int i = 0; i < this.size; i++) {
      if(this.childs[i].title.equals(title)) {
        return childs[i];
      }
    }
    return null;
  }


  public void prevMenuTitle (String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;  
  }

  @Override
  public void execute() {

    while(true) {
      System.out.printf("[%s]\n", this.title);
      for(int i = 0; i < this.size; i++) {           
        System.out.printf("%d. %s\n", i+1, this.childs[i].title);

      }
      System.out.printf("0. %s" , this.prevMenuTitle);


      int menuNo = Prompt.inputInt("선택> ");

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo - 1].execute();

    }
  }




}
