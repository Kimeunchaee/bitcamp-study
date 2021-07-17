package com.eomcs.pms.pms0717;

public class TaskHandler {
  static Task[] tasks = new Task[100];
  static int size = 0;

  static void add() {
    Task task = new Task();

    while(true) {
      System.out.println("[작업 등록]");
      task.no = Prompt.inputInt("번호? ");
      task.content = Prompt.inputString("내용? ");
      task.deadLine = Prompt.inputDate("시작일? ");
      task.owner = Prompt.inputString("작성자? ");
      System.out.println("상태? ");
      System.out.println(" 0: 신규\n 1: 진행중\n 2: 완료");
      System.out.print("> ");

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = Prompt.keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();
      tasks[size++] = task;
    }
  }

  static void list() {
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
