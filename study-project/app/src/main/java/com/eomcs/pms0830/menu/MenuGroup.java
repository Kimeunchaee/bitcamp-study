package com.eomcs.pms0830.menu;

import java.util.Stack;
import com.eomcs.pms0830.pms.handler.AuthHandler;
import com.eomcs.pms0830.util.Prompt;


// 로그인 여부에 따라 메뉴 출력을 제한한다.

public class MenuGroup extends Menu {

  // 메뉴의 bread crumb 목록 보관
  // 모든 메뉴가 공유할 객체이기 때문에 스태틱 멤버로 선언한다.
  static Stack<Menu> breadCrumb = new Stack<>();

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


  //------------------------------------------------------------------
  // MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드를 정의한다.
  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return; // 하위 메뉴를 저장하는 배열이 꽉 찼다면 더이상 저장해서는 안된다.
    }
    this.childs[this.size++] = child; 
  }

  // 배열에 들어 있는 Menu 객체를 찾아 제거한다.
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

  // 배열에 들어 있는 Menu 객체의 인덱스를 알아낸다.
  public int indexOf(Menu child) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  //배열에 들어 있는 Menu 객체를 찾는다.
  public Menu getMenu(String title) { 
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)) {
        return this.childs[i];
      }
    }
    return null;
  }

  @Override // 컴파일러에게 오버라이딩을 제대로 하는지 조사해 달라고 요구한다.
  public void execute() {
    // 현재 실행하는 메뉴를 스택에 보관한다.
    breadCrumb.push(this);


    // 0830 추가
    while (true) {
      // 로그인 여부를 따져야하는경우
      for (int i = 0; i < this.size; i++) {
        if(this.childs[i].enableState == Menu.ENABLE_LOGOUT && AuthHandler.getLoginUser() == null) {
          // 로그인이 되어 있지 않을때만 출력하는 메뉴인데
          // 로그인 되어 있지 않으면 출력하지 않는다
          System.out.printf("%d. %-20s\n", i + 1, this.childs[i].title);
          continue;
        } else if (this.childs[i].enableState == Menu.ENABLE_LOGIN && AuthHandler.getLoginUser() == null) {
          // 로그인이 되어 있을 때만 출력하는 메뉴인데
          // 로그인 되어 있지 않으면 출력하지 않는다
          System.out.printf("%d. %-20s\n", i + 1, this.childs[i].title);
          continue;
        } else {
          // 그 외에는 출력한다
          // 로그인 유무가 상관없을 경우
          System.out.printf("%d. %-20s\n", i + 1, this.childs[i].title);
        }
      }

      if (!disablePrevMenu) {
        System.out.printf("0. %s\n", this.prevMenuTitle);
      }

      try {
        int menuNo = Prompt.inputInt("선택> ");
        if (menuNo == 0 && !disablePrevMenu) {
          // 현재 메뉴에서 나갈 때 스택에서 제거한다.
          breadCrumb.pop();
          return;
        }

        if (menuNo < 0 || menuNo > this.size) {
          System.out.println("무효한 메뉴 번호입니다.");
          continue;
        }

        this.childs[menuNo - 1].execute();

      } catch (Throwable e) {
        // try 블록 안에 있는 코드를 실행하다가 예외가 발생하면
        // 다음 문장을 실행한 후 시스템을 멈추지 않고 실행을 계속한다.
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        System.out.println("--------------------------------------------------------------");
      }
    }
  }

  private String getBreadCrumb() {
    String path = "";

    for (int i = 0; i < breadCrumb.size(); i++) {
      if (path.length() > 0) {
        path += " / ";
      }
      Menu menu = breadCrumb.get(i); 
      path += menu.title;
    }

    return path;
  }

}







