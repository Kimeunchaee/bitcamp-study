package com.eomcs.pms.pms0719.handler;

import com.eomcs.pms.pms0719.domain.Member;
import com.eomcs.pms.pms0719.domain.Project;
import com.eomcs.pms.pms0719.util.Prompt;

//`ProjectHandler.add()`에서 `MemberHandler.exist()` 메서드를 사용하여
//이름의 유효 여부를 검사한다.
// : String owner = 내용

//1. 이름이 유효할 경우에는 다음 입력으로 넘어간다.
//2. 담당자의 이름이 무효할 경우에는 오류를 알리고 다시 입력 받는다.
//3. 담당자의 이름이 빈 문자열일 경우에는 등록을 취소한다.

public class ProjectHandler {

  static final int MAX_LENGTH = 5;
  static Project[] projects = new Project[MAX_LENGTH];
  static int size = 0;

  public static void add() {
    Project project = new Project();
    projects[size++] = project;

    while(true) {
      System.out.println("[프로젝트 등록]");
      project.no = Prompt.inputInt("번호? ");
      project.title = Prompt.inputString("프로젝트명? ");
      project.content = Prompt.inputString("내용? ");
      project.startDate = Prompt.inputDate("시작일? ");
      project.endDate = Prompt.inputDate("종료일? ");

      //회원 정보를 조회하여 등록
      while(true) {
        String owner = Prompt.inputString("만든이? (취소:엔터)");
        for(int i = 0; i < MemberHandler.size; i++) {

          if(MemberHandler.exist(owner)) {
            project.owner = owner;
            break;
          } else if(owner.length() == 0) {  //owner.equals(" ")와 같음
            System.out.println("등록을 취소합니다");
            return;
          }
        }
        if(!MemberHandler.exist(owner)) {
          break;
        }
        System.out.println("등록된 회원이 아닙니다.");
      }
      String owner =  Prompt.inputString("팀원? (완료: 빈 문자열");
      if (MemberHandler.exist(owner)) {     //1. 팀원의 이름이 유효한 경우
        Member.members += "," + owner;      //이름을 추가한다
      } else if (owner.length() == 0) {             //2. 팀원의 이름이 빈 문자열일 경우
        break;                                      // 입력을 완료한다
      } else {                                          // 3. 팀원의 이름이 무효할 경우
        System.out.println("등록된 회원이 아닙니다.");  //오류를 알린다
      }
      projects[size++] = project;
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
      System.out.printf("%d %s %s %s %s %s\n", 
          projects[i].no, projects[i].title,
          projects[i].startDate, projects[i].endDate, 
          projects[i].owner, projects[i].member);
    }
  }






}
