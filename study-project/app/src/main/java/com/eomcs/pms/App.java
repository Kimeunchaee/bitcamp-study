//package com.eomcs.pms;
//
//import static com.eomcs.menu.Menu.ACCESS_ADMIN;
//import static com.eomcs.menu.Menu.ACCESS_GENERAL;
//import static com.eomcs.menu.Menu.ACCESS_LOGOUT;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import com.eomcs.menu.Menu;
//import com.eomcs.menu.MenuGroup;
//import com.eomcs.pms.domain.Board;
//import com.eomcs.pms.domain.Member;
//import com.eomcs.pms.domain.Project;
//import com.eomcs.pms.handler.AuthLoginHandler;
//import com.eomcs.pms.handler.AuthLogoutHandler;
//import com.eomcs.pms.handler.AuthUserInfoHandler;
//import com.eomcs.pms.handler.BoardAddHandler;
//import com.eomcs.pms.handler.BoardDeleteHandler;
//import com.eomcs.pms.handler.BoardDetailHandler;
//import com.eomcs.pms.handler.BoardListHandler;
//import com.eomcs.pms.handler.BoardSearchHandler;
//import com.eomcs.pms.handler.BoardUpdateHandler;
//import com.eomcs.pms.handler.Command;
//import com.eomcs.pms.handler.MemberAddHandler;
//import com.eomcs.pms.handler.MemberDeleteHandler;
//import com.eomcs.pms.handler.MemberDetailHandler;
//import com.eomcs.pms.handler.MemberListHandler;
//import com.eomcs.pms.handler.MemberPrompt;
//import com.eomcs.pms.handler.MemberUpdateHandler;
//import com.eomcs.pms.handler.ProjectAddHandler;
//import com.eomcs.pms.handler.ProjectDeleteHandler;
//import com.eomcs.pms.handler.ProjectDetailHandler;
//import com.eomcs.pms.handler.ProjectListHandler;
//import com.eomcs.pms.handler.ProjectPrompt;
//import com.eomcs.pms.handler.ProjectUpdateHandler;
//import com.eomcs.pms.handler.TaskAddHandler;
//import com.eomcs.pms.handler.TaskDeleteHandler;
//import com.eomcs.pms.handler.TaskDetailHandler;
//import com.eomcs.pms.handler.TaskListHandler;
//import com.eomcs.pms.handler.TaskUpdateHandler;
//import com.eomcs.util.Prompt;
//
//
//public class App {
//  List<Board> boardList = new ArrayList<>();
//  List<Member> memberList = new LinkedList<>();
//  List<Project> projectList = new ArrayList<>();
//
//  HashMap<String,Command> commandMap = new HashMap<>();
//
//  MemberPrompt memberPrompt = new MemberPrompt(memberList);
//  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);
//
//  class MenuItem extends Menu {
//    String menuId;
//
//    public MenuItem(String title, String menuId) {
//      super(title);
//      this.menuId = menuId;
//    }
//
//    public MenuItem(String title, int accessScope, String menuId) {
//      super(title, accessScope);
//      this.menuId = menuId;
//    }
//
//    @Override
//    public void execute() {
//      Command command = commandMap.get(menuId);
//      command.execute();
//    }
//  }
//
//  public static void main(String[] args) {
//    App app = new App(); 
//    app.service();
//  }
//
//  public App() {
//    commandMap.put("/board/add", new BoardAddHandler(boardList));
//    commandMap.put("/board/list", new BoardListHandler(boardList));
//    commandMap.put("/board/detail", new BoardDetailHandler(boardList));
//    commandMap.put("/board/update", new BoardUpdateHandler(boardList));
//    commandMap.put("/board/delete", new BoardDeleteHandler(boardList));
//    commandMap.put("/board/search", new BoardSearchHandler(boardList));
//
//    commandMap.put("/member/add", new MemberAddHandler(memberList));
//    commandMap.put("/member/list", new MemberListHandler(memberList));
//    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
//    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
//    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));
//
//    commandMap.put("/project/add", new ProjectAddHandler(projectList, memberPrompt));
//    commandMap.put("/project/list", new ProjectListHandler(projectList));
//    commandMap.put("/project/detail", new ProjectDetailHandler(projectList));
//    commandMap.put("/project/update", new ProjectUpdateHandler(projectList, memberPrompt));
//    commandMap.put("/project/delete", new ProjectDeleteHandler(projectList));
//
//    commandMap.put("/task/add", new TaskAddHandler(projectPrompt));
//    commandMap.put("/task/list", new TaskListHandler(projectPrompt));
//    commandMap.put("/task/detail", new TaskDetailHandler(projectPrompt));
//    commandMap.put("/task/update", new TaskUpdateHandler(projectPrompt));
//    commandMap.put("/task/delete", new TaskDeleteHandler(projectPrompt));
//
//    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
//    commandMap.put("/auth/logout", new AuthLogoutHandler());
//    commandMap.put("/auth/userinfo", new AuthUserInfoHandler());
//  }
//
//  void service() {
//    // CSV 형식으로 저장된 객체를 한 줄의 문자열으로 다룬다
//    //    try(FileReader in = new FileReader("board.csv", Charset.forName("UTF-8"));
//    //        BufferedReader in2 = new BufferedReader(in)) {
//
//    // 위에 두 줄을 한번에 작성 (in2 > in 으로 다시 수정)
//    try( BufferedReader in = new BufferedReader
//        (new FileReader("board.csv", Charset.forName("UTF-8")))) {
//
//      // * BufferedReader 사용하면 아래 필요없음 (한줄씩 읽는 코드)
//      //    *  StringBuilder strBuilder = new StringBuilder();
//      //    *  int c;
//
//      //      while ((c = in.read()) != -1) {
//      //        // CSV 파일에서 줄바꿈을 의미하는 코드 중에서 CR 코드는 무시한다.
//      //        if (c == 0x0D) continue;
//      //
//      //        // CSV 파일에서 줄바꿈을 의미하는 코드 중에서 LF코드는 만나면 데이터를 읽기를 시작한다.
//      //        // 데이터를 객체로 바꾸는 읽을 시작한다.
//      //        // 즉 한줄을 읽었으면 값
//      //
//      //        if (c == 0x0A) { // 한 줄을 읽었으면 값을 해석하여 객체에 담는다.
//      //          // 1) strBUilder 객체에 보관된 문자열을 꺼낸다.
//      //          String csvStr = strBuilder.toString();
//
//      String csvStr = null;
//      while ((csvStr = in.readLine()) != null) {
//
//        // 보드 객체를 직접 만들지 않고 메서드를 사용한다
//        // 클래스명.스태틱메서드 호출
//        // ex) Date d = Date.valueOf("2021-1-1");
//        // ex) Integer i = Integer.valueOf(100);
//        // Board b = Board.valueOfCsv(csvStr);      // 아래 코드와 합쳐서 한줄로 써줌
//
//
//        //---------------------------
//        // 보드 객체를 만드는 코드 (Board로 옮겨서 메서드로 만듦)
//        //        // 2) 한 줄의 문자열을 콤마(,)로 분리한다.
//        //        String [] values = csvStr.split(",");   
//        //
//        //        // 3) 콤마로 분리한 값을 Board 객체에 담는다.
//        //        Board b = new Board();
//        //        b.setNo(Integer.valueOf(values[0]));
//        //        b.setTitle(values[1]);
//        //        b.setContent(values[2]);
//        //        b.setRegisteredDate(Date.valueOf(values[3]));
//        //        b.setViewCount(Integer.valueOf(values[4]));
//        //        b.setLike(Integer.valueOf(values[5]));
//        //
//        //        // 4) 게시글을 작성한 회원 정보를 Member 객체에 담는다.
//        //        Member m = new Member();
//        //        m.setNo(Integer.valueOf(values[6]));
//        //        m.setName(values[7]);
//        //
//        //        // 5) Member 객체를 Board 객체의 작성자 필드에 저장한다.
//        //        b.setWriter(m);
//        //----------------------------------------
//
//        // 6) 게시글 객체를 boardList에 저장한다.
//        //boardList.add(b);
//        boardList.add(Board.valueOfCsv(csvStr));
//
//        // 7) 기존의 한 줄 데이터를 보관하고 있는 StringBuilder의 내용물을 바꾼다.
//        // strBuilder.setLength(0);  //BufferedReader 사용해서 필요없어짐
//        continue;
//      }
//
//      // 일반적인 문자일 때는 StringBuilder에 보관한다.
//      // strBuilder.append((char) c);
//      System.out.println("게시글 데이터 로딩 완료!");
//    }
//    catch(Exception e) {
//      System.out.println("게시글 데이터 로딩 오류!");
//    }
//
//    createMainMenu().execute();
//    Prompt.close();
//
//    // 게시글 데이터를 CSV형식으로 출력한다.
//    //    try(FileWriter out = new FileWriter("board.csv", Charset.forName("UTF-8"));
//    //        PrintWriter out2 = new PrintWriter(out)) {
//
//    // 위에 두 줄을 합쳐서 한 줄로 작성 (out2 > out 으로 다시 수정)
//    try (PrintWriter out = new PrintWriter(
//        new BufferedWriter(
//            new FileWriter("board.csv", Charset.forName("UTF-8"))))) {
//
//      for (Board board : boardList) {   
//
//
//        // 보드 클래스에서 값을 꺼내는것을 직접하지 않고 메서드를 사용한다
//        out.println(board.toCsvString());
//
//        //---------------------------
//        // 보드 객체를 꺼내는 코드 (Board로 옮겨서 메서드로 만듦)
//        // 게시글 데이터를 갖고 있는 객체가 CSV 문자열을 만들도록 책임을 위임한다.
//        //out.printf(String.format("%d,%s,%s,%s,%d,%d,%d,%s\n",
//        //out2.printf(String.format("%d,%s,%s,%s,%d,%d,%d,%s\n",
//        //out.write(String.format("%d,%s,%s,%s,%d,%d,%d,%s\n",
//        //System.out.printf("%d,%s,%s,%s,%d,%d,%d,%s\n",
//        //            board.getNo(),
//        //            board.getTitle(),
//        //            board.getContent(),
//        //            board.getRegisteredDate(),
//        //            board.getViewCount(),
//        //            board.getLike(),
//        //            board.getWriter().getNo(),
//        //            board.getWriter().getName()));
//        //---------------------------
//      }
//      System.out.println("게시글 데이터 출력 완료!");
//    } catch(Exception E) {
//      System.out.println("게시글 데이터 출력 오류!");
//    }
//  }
//
//  private void loadBoards() {
//    // 이 단계부터 App2
//  }
//
//  Menu createMainMenu() {
//    MenuGroup mainMenuGroup = new MenuGroup("메인");
//    mainMenuGroup.setPrevMenuTitle("종료");
//
//    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT , "/auth/login"));
//    mainMenuGroup.add(new MenuItem("내정보", ACCESS_GENERAL, "/auth/userinfo"));
//    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_GENERAL, "/auth/logout"));
//
//    mainMenuGroup.add(createBoardMenu());
//    mainMenuGroup.add(createMemberMenu());
//    mainMenuGroup.add(createProjectMenu());
//    mainMenuGroup.add(createTaskMenu());
//    mainMenuGroup.add(createAdminMenu());
//
//    return mainMenuGroup;
//  }
//
//  private Menu createBoardMenu() {
//    MenuGroup boardMenu = new MenuGroup("게시판");
//    boardMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/board/add"));
//    boardMenu.add(new MenuItem("목록", "/board/list"));
//    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
//    boardMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/board/update"));
//    boardMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/board/delete"));
//    boardMenu.add(new MenuItem("검색", "/board/search"));
//    return boardMenu;
//  }
//
//  private Menu createMemberMenu() {
//    MenuGroup memberMenu = new MenuGroup("회원");
//    memberMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/member/add"));
//    memberMenu.add(new MenuItem("목록", "/member/list"));
//    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
//    memberMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/member/update"));
//    memberMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/member/delete"));
//    return memberMenu;
//  }
//
//  private Menu createProjectMenu() {
//    MenuGroup projectMenu = new MenuGroup("프로젝트");
//    projectMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/project/add"));
//    projectMenu.add(new MenuItem("목록", "/project/list"));
//    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
//    projectMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/project/update"));
//    projectMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/project/delete"));
//    return projectMenu;
//  }
//
//  private Menu createTaskMenu() {
//    MenuGroup taskMenu = new MenuGroup("작업");
//    taskMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/task/add"));
//    taskMenu.add(new MenuItem("목록", "/task/list"));
//    taskMenu.add(new MenuItem("상세보기", "/task/detail"));
//    taskMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/task/update"));
//    taskMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/task/delete"));
//    return taskMenu;
//  }
//
//  private Menu createAdminMenu() {
//    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
//    adminMenu.add(new MenuItem("회원 등록", "/member/add"));
//    adminMenu.add(new MenuItem("프로젝트 등록", "/project/add"));
//    adminMenu.add(new MenuItem("작업 등록", "/task/add"));
//    adminMenu.add(new MenuItem("게시글 등록", "/board/add"));
//    return adminMenu;
//  }
//}
//
//
//
//
//
//
//
//
//
//
//
//
