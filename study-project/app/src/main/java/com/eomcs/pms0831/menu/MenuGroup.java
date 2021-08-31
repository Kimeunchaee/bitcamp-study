package com.eomcs.pms0831.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.eomcs.pms0830.pms.handler.AuthHandler;
import com.eomcs.pms0831.util.Prompt;


// 로그인 여부에 따라 메뉴 출력을 제한한다.

public class MenuGroup extends Menu {

  //메뉴의 bread crumb 목록 보관
  // 모든 메뉴가 공유할 객체이기 때문에 스태틱 멤버로 선언한다.
  static Stack<Menu> breadCrumb = new Stack<Menu>();

  Menu[] childs = new Menu[100];
  int size;
  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";



  // 0831 추가
  // 이전으로 이동시키는 메뉴를 표현하기 위해 만든 클래스
  private static class PrevMenu extends Menu {
    public PrevMenu() {
      super("");
    }
    @Override
    public void execute() {
    }
  }
  static PrevMenu prevMenu = new PrevMenu();



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
      // 0831 추가
      // 한줄인데 왜 메서드 사용?
      // 주석으로 코드 설명하는것을 줄이기 위해!
      // System.out.printf("\n[%s]\n", getBreadCrumb());
      printBreadCrumbMenuTitle();

      // 0831 추가
      // 메서드로 묶음 (getMenuList())
      //    ArrayList<Menu> menuList = new ArrayList<>();
      //    for (int i = 0; i < this.size; i++) {
      //      if (this.childs[i].enableState == Menu.ENABLE_LOGOUT && 
      //          AuthHandler.getLoginUser() == null) {
      //        menuList.add(this.childs[i]);
      //
      //      } else if (this.childs[i].enableState == Menu.ENABLE_LOGIN && 
      //          AuthHandler.getLoginUser() != null) {
      //        menuList.add(this.childs[i]);
      //      } else if (this.childs[i].enableState == Menu.ENABLE_ALL) {
      //        menuList.add(this.childs[i]);
      //      }
      //    }
      List<Menu> menuList = getMenuList();

      //0831 추가
      printMenuList(menuList);

      try {
        Menu menu = selectMenu(menuList);
        if (menu == null) {
          System.out.println("무효한 메뉴 번호입니다.");
          continue;
        }
        if (menu instanceof PrevMenu) {
          breadCrumb.pop();
          return;
        }

        menu.execute();

      } catch (Exception e) {
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

  // 0831 추가
  //출력될 메뉴 목록 준비
  // => 왜?
  // - 메뉴 출력 속도를 빠르게 하기 위함.
  // - 메뉴를 출력할 때 마다 매번 출력할 메뉴와 출력하지 말아야 할 메뉴를 구분해야 한다면
  //   시간이 오래 걸린다.
  private List<Menu> getMenuList() {
    ArrayList<Menu> menuList = new ArrayList<>();
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].enableState == Menu.ENABLE_LOGOUT && 
          AuthHandler.getLoginUser() == null) {
        menuList.add(this.childs[i]);

      } else if (this.childs[i].enableState == Menu.ENABLE_LOGIN && 
          AuthHandler.getLoginUser() != null) {
        menuList.add(this.childs[i]);

      } else if (this.childs[i].enableState == Menu.ENABLE_ALL) {
        menuList.add(this.childs[i]);
      } 
    }
    return menuList;
  }



  // 0831 추가
  private void printBreadCrumbMenuTitle() {
    System.out.printf("\n[%s]\n", getBreadCrumb());
  }


  //0831 추가
  private void printMenuList(List<Menu> menuList) {
    int i = 1;
    for (Menu menu : menuList) {
      System.out.printf("%d. %-20s\n", i++, menu.title);
    }

    if (!disablePrevMenu) {
      System.out.printf("0. %s\n", this.prevMenuTitle);
    }
  }


  private Menu selectMenu(List<Menu> menuList) {
    int menuNo = Prompt.inputInt("선택> ");

    if (menuNo < 0 || menuNo > menuList.size()) {
      return null;
    }

    if (menuNo == 0 && !disablePrevMenu) {
      return prevMenu; // 호출한 쪽에 '이전 메뉴' 선택을 알리게 위해 
    } 

    return menuList.get(menuNo - 1);
  }


}







