package com.eomcs.pms.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.csv.CsvValue;

public class Project implements CsvValue{
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members = new ArrayList<>();
  private List<Task> tasks = new ArrayList<>();

  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }

  @Override
  public String toCsvString() {

    // 프로젝트 정보를 CSV로 출력할 때 멤버 정보와 작업 정보를 포함한다
    StringBuilder strBuilder = new StringBuilder();

    // 1) 프로젝트 기본 정보를 저장한다.
    strBuilder.append(String.format("%d,%s,%s,%s,%s,%d,%s,", // ,는 빈문자열 출력하려고
        this.getNo(),
        this.getTitle(),
        this.getContent(),
        this.getStartDate(),
        this.getEndDate(),
        this.getOwner().getNo(),
        this.getOwner().getName()));

    // 2) 프로젝트 멤버 정보를 저장한다
    // 프로젝트 멤버의 수를 저장한다
    strBuilder.append(String.format("%d,", this.getMembers().size()));

    // 프로젝트 멤버들의 정보를 저장한다
    for (Member m : this.getMembers()) {
      strBuilder.append(String.format("%d,%s,", m.getNo(), m.getName()));
    }

    // 3) 프로젝트 작업 정보를 저장한다
    // 작업의 수를 저장한다
    strBuilder.append(String.format("%d,", this.getTasks().size()));

    // 작업들의 정보를 저장한다
    for (Task t : this.getTasks()) {
      strBuilder.append(String.format("%d,%s,%s,%d,%d,%s,",
          t.getNo(),
          t.getContent(),
          t.getDeadline(),
          t.getStatus(),
          t.getOwner().getNo(),
          t.getOwner().getName()));
    }

    return strBuilder.toString();
  }

  @Override
  public void loadCsv(String csv) {

    String [] values = csv.split(",");   

    // CSV 문자열에서 추출한 값을 객체의 필드에 저장한다

    // 1) 프로젝트 기본 정보를 로딩
    this.setNo(Integer.valueOf(values[0]));
    this.setTitle(values[1]);
    this.setContent(values[2]);
    this.setStartDate(Date.valueOf(values[3]));
    this.setEndDate(Date.valueOf(values[4]));

    // 2) 프로젝트 관리자 정보를 로딩
    Member owner = new Member();
    owner.setNo(Integer.valueOf(values[5]));
    owner.setName(values[6]);

    this.setOwner(owner);

    // 3) 프로젝트 멤버 정보를 로딩
    // 프로젝트 멤버가 몇 명인지 읽어 온다.
    int memberSize = Integer.valueOf(values[7]);
    int last = 0;

    for(int i = 0, offset = 8; i < memberSize; i++, offset += 2) {            // 왜 2씩 증가? 번호,이름 으로 출력되기때문에 첫번째 멤버는 8,9번째에 들어가야하고 두번째 멤버는 10,11에 들어가고.... 2개씩 필요하다

      // 파일에서 멤버 번호와 이름을 로딩한다
      Member m = new Member();
      m.setNo(Integer.valueOf(values[offset]));     // 번호는 8,10,12...에 표시됨
      m.setName(values[offset + 1]);                // 이름은 9,11,13...에 표시됨

      // 프로젝트 멤버에 추가한다
      this.getMembers().add(m);

      // 작업 데이터를 읽을 때 사용할 마지막 인덱스 번호를 저장해 둔다.
      last = offset +1;
    }

    // 4) 작업 로딩
    // 작업의 개수를 읽어온다
    int taskSize = Integer.valueOf(values[last + 1]);       // 마지막 인덱스  + 1 가 작업 시작부분 (작업갯수가 출력되고 시작해야하니까
    for(int i = 0, offset = last + 2; i < taskSize; i++, offset += 6) {         // last + 2 값이 offset  //하나의 작업의 정보는 6개씩 저장됨

      // 파일에서 작업 데이터를 로딩한다
      Task t = new Task();
      t.setNo(Integer.valueOf(values[offset]));
      t.setContent(values[offset + 1]);
      t.setDeadline(Date.valueOf(values[offset + 2]));
      t.setStatus(Integer.valueOf(values[offset + 3]));

      // 작업자 데이터를 로딩한다
      Member worker = new Member();
      worker.setNo(Integer.valueOf(values[offset + 4]));
      worker.setName(values[offset + 5]);

      // 작업에 작업자 정보를 등록한다
      t.setOwner(worker);

      // 프로젝트 멤버에 추가한다
      this.getTasks().add(t);
    }
  }



  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public List<Member> getMembers() {
    return members;
  }
  public void setMembers(List<Member> members) {
    this.members = members;
  }
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public String getMemberNames() {
    if (this.members == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();
    for (Member member : this.members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  public Task findTaskByNo(int taskNo) {
    for (Task task : this.tasks) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}
