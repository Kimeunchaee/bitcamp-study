package com.eomcs.pms.pms0721.handler;

import com.eomcs.pms.pms0721.domain.Task;
import com.eomcs.pms.pms0721.util.Prompt;



public class TaskHandler {

  static final int MAX_LENGTH = 5;

  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  // add()에 if문에서 exist()를 사용하기 위해
  // mh 라는 이름을 가진 파라미터에
  // add(),list(),exist()를 가진 MemberHandler(주소값)을 볼러옴

  public void add (MemberHandler mh) {
    Task task = new Task();
    this.tasks[this.size++] = task;
    while(true) {
      System.out.println("[작업 등록]");
      task.no = Prompt.inputInt("번호? ");
      task.content = Prompt.inputString("내용? ");
      task.deadLine = Prompt.inputDate("시작일? ");
      task.owner = Prompt.inputString("작성자? ");
      System.out.println("상태? ");
      System.out.println(" 0: 신규\n 1: 진행중\n 2: 완료\n>");



      while (true) {
        String name = Prompt.inputString("담당자?(취소: 빈 문자열) ");
        if (name.length() == 0) {
          System.out.println("작업 등록을 취소합니다.");
          return;
        } else if (mh.exist(name)) {
          task.owner = name;
          break;
        } else {
          System.out.println("등록된 회원이 아닙니다.");
        }
      }




      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = Prompt.keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();

    }
  }

  public void list() {
    System.out.println("-------------출력------------");
    for(int i = 0; i < this.size; i++) {
      String statusinput = null;
      if(this.tasks[i].status == 0) {
        statusinput = "신규";
      } else if (this.tasks[i].status == 1) {
        statusinput = "진행중";
      } else if (this.tasks[i].status == 2) {
        statusinput = "완료";
      }
      System.out.printf("%d %s %s %s %s\n", 
          this.tasks[i].no, this.tasks[i].content, this.tasks[i].deadLine, this.tasks[i].owner, statusinput);
    }
  }
}
