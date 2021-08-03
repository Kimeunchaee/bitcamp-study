package com.eomcs.pms0802.menu;


//MenuItem과 리스너

//ActionListener 규칙에 따라 리스너 객체를 실행하는 코드를 추가한다.
//- 리스너를 보관할 배열 준비
//- 리스너를 등록하는 메서드 추가
public class MenuItem2 extends Menu {

  //--------------------------------------------

  //객체 추가
  //리스너를 보관하는 배열을 준비한다.
  ActionListener[] listeners = new ActionListener[10];
  int size;

  //--------------------------------------------

  public MenuItem2(String title) {
    super(title);
  }

  //--------------------------------------------

  //리스너를 등록하는 메서드 추가
  public void addActionListener(ActionListener listener) {
    if (this.size == this.listeners.length) {
      return;
    }
    this.listeners[this.size++] = listener;
  }



  //--------------------------------------------

  @Override
  public void execute() {

    // 메뉴를 실행하면 이 메뉴에 등록된 모든 리스너에게 알린다.
    for (int i = 0; i < this.size; i++) {
      // 배열에 보관된 각각의 리스너 객체에 대해 
      // ActionListener 규칙에 따라 메서드를 호출한다.
      // => 이것이 리스너에게 알린다는 의미다.
      this.listeners[i].doAction();

    }
  }
}
