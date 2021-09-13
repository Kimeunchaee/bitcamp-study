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

public class App {
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
    App app = new App(); 
    app.service();
  }

  public App() {
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


  private void loadBoards() {
    try (FileInputStream in = new FileInputStream("board.data");


        //*추가
        DataInputStream in2 = new DataInputStream(in)) {

      int size = (in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read(); // 읽어서 왼쪽으로 이동
      for (int i = 0; i < size; i++) {

        Board board = new Board();

        // 1) 게시글 번호 읽기
        //        board.setNo((in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read());

        board.setNo(in2.readInt()); // writeInt() 로 출력한 데이터를 읽을 때 사용

        // 2) 게시글 제목 읽기
        //        int strlen = (in.read() << 8) | in.read(); // 제목 문자열의 바이트 수
        //        byte[] buf = new byte[strlen]; // strlen > string length // 문자열의 바이트를 담을 배열 준비
        //        in.read(buf); // 문자열의 바이트를 배열에 담는다.
        //        String str = new String(buf, "UTF-8"); // 바이트 배열을 가지고 String 객체를 만든다.
        //        board.setTitle(str); // Board 객체에 제목을 담는다.

        board.setTitle(in2.readUTF()); // writeUTF() 로 출력한 데이터를 읽을 때 사용


        // 3) 게시글 내용 읽기
        //        buf = new byte[(in.read() << 8) | in.read()]; // 바이트 배열을 알아내려고 배열을 준비함
        //        in.read(buf); // 배열을 가지고 옴
        //        board.setContent(new String(buf, "UTF-8")); // 문자열로 만들어서 저장

        board.setContent(in2.readUTF());

        // 4) 게시글 등록일 읽기
        //        buf = new byte[(in.read() << 8) | in.read()];
        //        in.read(buf);
        //        Date regDate = Date.valueOf(new String(buf, "UTF-8"));
        //        board.setRegisteredDate(regDate);

        board.setRegisteredDate(Date.valueOf(in2.readUTF()));

        // 5) 게시글 조회수 읽기
        //board.setViewCount((in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read());

        board.setViewCount(in2.readInt());

        // 6) 작성자 정보 읽기
        Member writer = new Member();

        // - 작성자 번호 읽기
        // 기존
        //writer.setNo((in.read() << 24) | (in.read() << 16) | (in.read() << 8) | in.read());
        // 변경
        writer.setNo(in2.readInt());

        // - 작성자 이름 읽기
        // 기존
        // buf = new byte[(in.read() << 8) | in.read()]; // 바이트 배열을 알아내려고 배열을 준비함
        // in.read(buf); // 배열을 가지고 옴
        // writer.setName(new String(buf, "UTF-8")); // 문자열로 만들어서 저장
        // 변경
        writer.setName(in2.readUTF());

        // - 게시글에 작성자 정보 저장
        // 기존
        //board.setWriter(writer);
        //변경
        board.setWriter(writer);

        // 목록에 게시글 저장

        boardList.add(board);

      }

      System.out.println("게시글 로딩 완료!");

    } catch (Exception e) {
      System.out.println("파일에서 게시글을 읽어 오는 중 오류 발생!");
      e.printStackTrace();
    }
  }


  private void saveBoards() {
    // 게시글 데이터를 파일로 내보내기(저장하기, 쓰기)
    try (
        // 파일에 바이트를 출력하는 객체
        FileOutputStream out = new FileOutputStream("board.data");

        // DataOutputStream 클래스 사용 추가
        // 파일에 바이트를 풀력하기 전에 바이트 단위로 쪼개는 일을 하는 데코레이터
        DataOutputStream out2 = new DataOutputStream(out)) {   // 생성자에 out을 꼭 넘겨줘야함, try 안에서 마지막 세미콜론은 생략가능


      // 출력할 게시글 개수를 먼저 저장한다.
      out.write(boardList.size() >> 24);
      out.write(boardList.size() >> 16);
      out.write(boardList.size() >> 8);
      out.write(boardList.size());

      for (Board board : boardList) {
        // 1) 게시글 번호 4바이트 출력
        //        out.write(board.getNo() >> 24); // >> 비트 이동
        //        out.write(board.getNo() >> 16);
        //        out.write(board.getNo() >> 8);
        //        out.write(board.getNo());

        //DataOutputStream은 비트 이동을 해줄 필요없다 , 이미 만들어져 있는 ㄱ능!
        out2.writeInt(ACCESS_LOGOUT);

        // 2) 게시글 제목
        //        byte[] bytes = board.getTitle().getBytes("UTF-8");
        //        out.write(bytes.length >> 8); // 바이트의 개수를 2바이트로 먼저 출력한다. >> 8비트 이동
        //        out.write(bytes.length); 
        //        out.write(bytes); // 그런 후에 바이트를 출력한다.
        out2.writeUTF(board.getTitle());

        // 3) 게시글 내용 출력
        //        bytes = board.getContent().getBytes("UTF-8");
        //        out.write(bytes.length >> 8); // 2바이트로 바이트 배열의 크기를 먼저 출력한다. >> 8비트 이동
        //        out.write(bytes.length);
        //        out.write(bytes); // 그런 후에 바이트 배열을 출력한다.

        out2.writeUTF(board.getContent());

        // 4) 게시글 등록일 출력
        //        String dateStr = board.getRegisteredDate().toString(); // "2021-09-07" 형식으로 출력
        //        bytes = dateStr.getBytes("UTF-8");
        //        out.write(bytes.length >> 8);
        //        out.write(bytes.length);
        //        out.write(bytes);

        out2.writeUTF(board.getRegisteredDate().toString());

        // 5) 게시글 조회수 출력
        out.write(board.getViewCount() >> 24); // >> 비트 이동  // > 이 일을 대신해주는 데코레이터 클래스를 사용한다
        out.write(board.getViewCount() >> 16);
        out.write(board.getViewCount() >> 8);
        out.write(board.getViewCount());
        // 데코레이터 패턴은 객체에 독정으로 새로운 서비스를 추가할 수 있게 해주는 설계기법이다

        out2.writeUTF(board.getRegisteredDate().toString());

        // 6) 게시글 작성자 번호 출력
        //        out.write(board.getWriter().getNo() >> 24); // >> 비트 이동
        //        out.write(board.getWriter().getNo() >> 16);
        //        out.write(board.getWriter().getNo() >> 8);
        //        out.write(board.getWriter().getNo());

        out2.write(board.getWriter().getNo());

        // 7) 게시글 작성자의 이름
        //        bytes = board.getWriter().getName().getBytes("UTF-8");
        //        out.write(bytes.length >> 8);
        //        out.write(bytes.length); 
        //        out.write(bytes);

        out2.writeUTF(board.getWriter().getName());
      }

      System.out.println("게시글 저장 완료!");

    } catch (Exception e) {
      System.out.println("게시글을 파일에 저장 중 오류 발생!");
      e.printStackTrace();
    }
    // 이렇게 게시글 데이터를 출력할 때 다음과 같이 나름의 형식에 따라 데이터를 출력한다.
    // - 처음 4바이트는 저장할 게시글의 개수이고,
    // - 그 다음 4바이트는 게시글 번호이고,
    // - 그 다음 4바이트는 제목의 바이트 개수이고 등등
    // 파일의 데이터를 출력할 때 사용하는 규칙을 "파일 포맷(format)"이라 부른다.
    // 당연히 파일에서 데이터를 읽을 때는 저장한 규칙에 맞춰 읽어야 한다.
    // 즉 "파일 포맷"에 맞춰 읽어야 한다.
    // .ppt 파일을 읽을 때는 ppt 파일 포맷에 맞춰 읽어야 하고,
    // .gif 파일을 읽을 때는 gif 파일 포맷에 맞춰 읽어야 한다.
    // 만약 파일 포맷을 모른다면 해당 파일을 제대로 읽을 수가 없다.
  }

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