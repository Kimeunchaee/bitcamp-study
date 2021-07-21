package com.eomcs.pms.pms0721.handler;

import com.eomcs.pms.pms0721.domain.Member;
import com.eomcs.pms.pms0721.domain.Project;
import com.eomcs.pms.pms0721.util.Prompt;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;

  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;


  // add()에 if문에서 exist()를 사용하기 위해
  // mh 라는 이름을 가진 파라미터에
  // add(),list(),exist()를 가진 MemberHandler(주소값)을 볼러옴
  public void add(MemberHandler mh) {

    Project project = new Project();
    this.projects[this.size++] = project;

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
        for(int i = 0; i < this.size; i++) {

          if(mh.exist(owner)) {
            project.owner = owner;
            break;
          } else if(owner.length() == 0) {  //owner.equals(" ")와 같음
            System.out.println("등록을 취소합니다");
            return;
          }
        }
        if(!mh.exist(owner)) {
          break;
        }
        System.out.println("등록된 회원이 아닙니다.");
      }
      String owner =  Prompt.inputString("팀원? (완료: 빈 문자열");
      // (MemberHandler.exist(owner)) 를 
      // 파라미터 이름인 mh.exist()로 변경
      if (mh.exist(owner)) {     
        Member.members += "," + owner;      
      } else if (owner.length() == 0) {             
        break;                                      
      } else {                                          
        System.out.println("등록된 회원이 아닙니다.");  
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
      System.out.printf("%d %s %s %s %s %s\n", 
          this.projects[i].no, this.projects[i].title,
          this.projects[i].startDate, this.projects[i].endDate, 
          this.projects[i].owner, this.projects[i].member);
    }
  }






}
