package com.eomcs.pms0802.handler;
import java.sql.Date;
import com.eomcs.pms0802.domain.Project;
import com.eomcs.pms0802.util.Prompt;
public class ProjectHandler {


  static class Node{
    Project project;
    Node next;

    public Node(Project project) {
      this.project = project;
    }
  }

  int size = 0;
  Node head;
  Node tail;


  MemberHandler memberHandler;
  public ProjectHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    project.owner = promptOwner("만든이?(취소: 빈 문자열) ");
    if (project.owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }
    project.members = promptMembers("팀원?(완료: 빈 문자열) ");


    //    if(size == this.projects.length) {
    //      Project[] arr = new Project[ this.projects.length + (this.projects.length >> 1) ];
    //      for(int i =0; i < this.size; i++) {
    //        arr[i] = projects[i];
    //      }
    //      this.projects = arr;  //이걸 왜 넣지?........ arr[i] = projects[i] 얘랑 무슨차이?
    //      System.out.println("새 Project[]객체를 만듦");
    //    }

    Node node = new Node(project);
    if(head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;

  }


  public void list() {
    System.out.println("[프로젝트 목록]");

    if(head ==  null) {
      return;
    }
    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          node.project.no, 
          node.project.title, 
          node.project.startDate, 
          node.project.endDate, 
          node.project.owner,
          node.project.members);
      node = node.next;
    }  while (node != null);
  }


  public void detail() {
    System.out.println("[프로젝트 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("만든이: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);
  }

  public void update() {
    System.out.println("[프로젝트 변경]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

    String owner = promptOwner(String.format(
        "만든이(%s)?(취소: 빈 문자열) ", project.owner));
    if (owner == null) {
      System.out.println("프로젝트 변경을 취소합니다.");
      return;
    }

    String members = promptMembers(String.format(
        "팀원(%s)?(완료: 빈 문자열) ", project.members));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.title = title;
    project.content = content;
    project.startDate = startDate;
    project.endDate = endDate;
    project.owner = owner;
    project.members = members;

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    Node node = head;
    Node prev = null;

    while(node != null) {
      if(node.project == project) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }
        node.next = null;

        if(node == tail) {
          tail = prev;
        }
        break;
      }

      prev = node;
      node = node.next;
    }
    size--;
    System.out.println("프로젝트를 삭제하였습니다.");
  }

  private Project findByNo(int no) {
    Node node = head;
    do {
      if(node.project.no == no) {
        return node.project;
      }
      node = node.next;
    } while(node != null);
    return null;
  }

  private String promptOwner(String label) {
    while (true) {
      String owner = Prompt.inputString(label);

      if (this.memberHandler.exist(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private String promptMembers(String label) {
    String members = "";
    while (true) {
      String member = Prompt.inputString(label);
      if (this.memberHandler.exist(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;
        continue;
      } else if (member.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members;
  }

}




