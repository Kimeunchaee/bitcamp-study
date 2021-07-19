package com.eomcs.pms.pms0719.handler;

import com.eomcs.pms.pms0719.domain.Task;
import com.eomcs.pms.pms0719.util.Prompt;


// `TaskHandler.add()`에서 `MemberHandler.exist()` 메서드를 사용하여
// 이름의 유효 여부를 검사한다.
// 1. 이름이 유효할 경우에는 다음 입력으로 넘어간다.
// 2. 담당자의 이름이 무효할 경우에는 오류를 알리고 다시 입력 받는다.
// 3. 담당자의 이름이 빈 문자열일 경우에는 등록을 취소한다.

public class TaskHandler {
  static final int MAX_LENGTH = 5;
  static Task[] tasks = new Task[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    Task task = new Task();
    tasks[size++] = task;
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
        } else if (MemberHandler.exist(name)) {
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

  public static void list() {
    System.out.println("-------------출력------------");
    for(int i = 0; i < size; i++) {
      String statusinput = null;
      if(tasks[i].status == 0) {
        statusinput = "신규";
      } else if (tasks[i].status == 1) {
        statusinput = "진행중";
      } else if (tasks[i].status == 2) {
        statusinput = "완료";
      }
      System.out.printf("%d %s %s %s %s\n", 
          tasks[i].no, tasks[i].content, tasks[i].deadLine, tasks[i].owner, statusinput);
    }
  }
}
