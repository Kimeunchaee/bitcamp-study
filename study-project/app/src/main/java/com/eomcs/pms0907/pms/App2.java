package com.eomcs.pms0907.pms;

import static com.eomcs.pms0907.menu.Menu.ACCESS_ADMIN;
import static com.eomcs.pms0907.menu.Menu.ACCESS_GENERAL;
import static com.eomcs.pms0907.menu.Menu.ACCESS_LOGOUT;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.pms0907.menu.Menu;
import com.eomcs.pms0907.menu.MenuGroup;
import com.eomcs.pms0907.pms.domain.Board;
import com.eomcs.pms0907.pms.domain.Member;
import com.eomcs.pms0907.pms.domain.Project;
import com.eomcs.pms0907.pms.handler.AuthLoginHandler;
import com.eomcs.pms0907.pms.handler.AuthLogoutHandler;
import com.eomcs.pms0907.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms0907.pms.handler.BoardAddHandler;
import com.eomcs.pms0907.pms.handler.BoardDeleteHandler;
import com.eomcs.pms0907.pms.handler.BoardDetailHandler;
import com.eomcs.pms0907.pms.handler.BoardListHandler;
import com.eomcs.pms0907.pms.handler.BoardSearchHandler;
import com.eomcs.pms0907.pms.handler.BoardUpdateHandler;
import com.eomcs.pms0907.pms.handler.Command;
import com.eomcs.pms0907.pms.handler.MemberAddHandler;
import com.eomcs.pms0907.pms.handler.MemberDeleteHandler;
import com.eomcs.pms0907.pms.handler.MemberDetailHandler;
import com.eomcs.pms0907.pms.handler.MemberListHandler;
import com.eomcs.pms0907.pms.handler.MemberPrompt;
import com.eomcs.pms0907.pms.handler.MemberUpdateHandler;
import com.eomcs.pms0907.pms.handler.ProjectAddHandler;
import com.eomcs.pms0907.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms0907.pms.handler.ProjectDetailHandler;
import com.eomcs.pms0907.pms.handler.ProjectListHandler;
import com.eomcs.pms0907.pms.handler.ProjectPrompt;
import com.eomcs.pms0907.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms0907.pms.handler.TaskAddHandler;
import com.eomcs.pms0907.pms.handler.TaskDeleteHandler;
import com.eomcs.pms0907.pms.handler.TaskDetailHandler;
import com.eomcs.pms0907.pms.handler.TaskListHandler;
import com.eomcs.pms0907.pms.handler.TaskUpdateHandler;
import com.eomcs.pms0907.util.Prompt;

// 0907 파일 입출력 API
// 데코레이터 패턴 적용

public class App2 {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();

  HashMap<String,Command> commandMap = new HashMap<>();

  MemberPrompt memberPrompt = new MemberPrompt(memberList);
  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);

  class MenuItem extends Menu {
    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      Command command = commandMap.get(menuId);
      command.execute();
    }
  }

  public static void main(String[] args) {
    App2 app = new App2(); 
    app.service();
  }

  public App2() {
    commandMap.put("/board/add", new BoardAddHandler(boardList));
    commandMap.put("/board/list", new BoardListHandler(boardList));
    commandMap.put("/board/detail", new BoardDetailHandler(boardList));
    commandMap.put("/board/update", new BoardUpdateHandler(boardList));
    commandMap.put("/board/delete", new BoardDeleteHandler(boardList));
    commandMap.put("/board/search", new BoardSearchHandler(boardList));

    commandMap.put("/member/add", new MemberAddHandler(memberList));
    commandMap.put("/member/list", new MemberListHandler(memberList));
    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));

    commandMap.put("/project/add", new ProjectAddHandler(projectList, memberPrompt));
    commandMap.put("/project/list", new ProjectListHandler(projectList));
    commandMap.put("/project/detail", new ProjectDetailHandler(projectList));
    commandMap.put("/project/update", new ProjectUpdateHandler(projectList, memberPrompt));
    commandMap.put("/project/delete", new ProjectDeleteHandler(projectList));

    commandMap.put("/task/add", new TaskAddHandler(projectPrompt));
    commandMap.put("/task/list", new TaskListHandler(projectPrompt));
    commandMap.put("/task/detail", new TaskDetailHandler(projectPrompt));
    commandMap.put("/task/update", new TaskUpdateHandler(projectPrompt));
    commandMap.put("/task/delete", new TaskDeleteHandler(projectPrompt));

    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
    commandMap.put("/auth/logout", new AuthLogoutHandler());
    commandMap.put("/auth/userinfo", new AuthUserInfoHandler());
  }

  // ** 저장한 포맷에 맞춰 읽어야 함 **
  void service() {
    // 파일에서 게시글 데이터를 가져오기(로딩하기, 읽기)
    // => 저장할 때 사용한 규칙에 따라 읽어야 한다.
    // => 즉 파일 포맷에 맞춰 읽는다.
    loadBoards();

    createMainMenu().execute();
    Prompt.close();

    saveBoards();
  }

  //------------------------------------------------------------------------
  private void loadBoards() {
    try (
        // 파일에서 바이트를 읽어 오는 일을 하는 객체
        FileInputStream in = new FileInputStream("board.data");

        // 읽어 바이트를 가공하여 primitive 타입의 값이나 String 객체로 가공하는 일을 하는 객체
        DataInputStream in2 = new DataInputStream(in)) {

      // 게시글 개수를 먼저 읽는다.
      int size = in2.readInt();

      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setNo(in2.readInt()); // writeInt()로 출력한 데이터를 읽을 때 사용
        board.setTitle(in2.readUTF()); // writeUTF()로 출력한 문자열을 읽을 때 사용 
        board.setContent(in2.readUTF());
        board.setRegisteredDate(Date.valueOf(in2.readUTF()));
        board.setViewCount(in2.readInt());

        // 6) 작성자 정보 읽기
        Member writer = new Member();
        writer.setNo(in2.readInt());
        writer.setName(in2.readUTF());

        board.setWriter(writer);

        boardList.add(board);
      }

      System.out.println("게시글 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 게시글을 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }
  }

  private void saveBoards() {
    try (
        // 파일에 바이트를 출력하는 객체
        FileOutputStream out = new FileOutputStream("board.data");

        // 파일에 바이트를 출력하기 전에 바이트 단위로 쪼개는 일을 하는 데코레이터
        DataOutputStream out2 = new DataOutputStream(out)) {

      // 출력할 게시글 개수를 먼저 저장한다.
      out2.writeInt(boardList.size());

      for (Board board : boardList) {
        out2.writeInt(board.getNo());
        out2.writeUTF(board.getTitle());
        out2.writeUTF(board.getContent());
        out2.writeUTF(board.getRegisteredDate().toString());
        out2.writeInt(board.getViewCount());
        out2.writeInt(board.getWriter().getNo());
        out2.writeUTF(board.getWriter().getName());
      }

      System.out.println("게시글 저장 완료!");

    } catch (Exception e) {
      System.out.println("게시글을 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }
  //------------------------------------------------------------------------
  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT , "/auth/login"));
    mainMenuGroup.add(new MenuItem("내정보", ACCESS_GENERAL, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_GENERAL, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());
    mainMenuGroup.add(createAdminMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/board/add"));
    boardMenu.add(new MenuItem("목록", "/board/list"));
    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
    boardMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/board/update"));
    boardMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/board/delete"));
    boardMenu.add(new MenuItem("검색", "/board/search"));
    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/member/add"));
    memberMenu.add(new MenuItem("목록", "/member/list"));
    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
    memberMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/member/update"));
    memberMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/member/delete"));
    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("프로젝트");
    projectMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/project/add"));
    projectMenu.add(new MenuItem("목록", "/project/list"));
    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
    projectMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/project/update"));
    projectMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/project/delete"));
    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("작업");
    taskMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/task/add"));
    taskMenu.add(new MenuItem("목록", "/task/list"));
    taskMenu.add(new MenuItem("상세보기", "/task/detail"));
    taskMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/task/update"));
    taskMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/task/delete"));
    return taskMenu;
  }

  private Menu createAdminMenu() {
    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    adminMenu.add(new MenuItem("회원 등록", "/member/add"));
    adminMenu.add(new MenuItem("프로젝트 등록", "/project/add"));
    adminMenu.add(new MenuItem("작업 등록", "/task/add"));
    adminMenu.add(new MenuItem("게시글 등록", "/board/add"));
    return adminMenu;
  }
}