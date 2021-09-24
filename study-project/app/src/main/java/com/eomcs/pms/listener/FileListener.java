package com.eomcs.pms.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String, Object> params) {
    List<Board> boardList = (List<Board>) params.get("boardList");
    List<Member> memberList = (List<Member>) params.get("memberList");
    List<Project> projectList = (List<Project>) params.get("projectList");

    // 애플리케이션을 시작할 때 파일에서 데이터를 읽어 온다.
    loadObjects("board.json", boardList, Board.class);
    loadObjects("member.json", memberList, Member.class);
    loadObjects("project.json", projectList, Project.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void contextDestroyed(Map<String, Object> params) {
    List<Board> boardList = (List<Board>) params.get("boardList");
    List<Member> memberList = (List<Member>) params.get("memberList");
    List<Project> projectList = (List<Project>) params.get("projectList");

    // 애플리케이션을 종료할 때 데이터를 파일로 저장한다.
    saveObjects("board.json", boardList);
    saveObjects("member.json", memberList);
    saveObjects("project.json", projectList);

  }

  private <E> void loadObjects(
      String filepath,
      List<E> list,
      Class<E> domainType
      ) {

    try (BufferedReader in = new BufferedReader(
        new FileReader(filepath, Charset.forName("UTF-8")))) {

      StringBuilder strBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) {
        strBuilder.append(str);
      }

      Type type = TypeToken.getParameterized(Collection.class, domainType).getType();
      Collection<E> collection = new Gson().fromJson(strBuilder.toString(), type);

      list.addAll(collection);

      System.out.printf("%s 데이터 로딩 완료!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s 데이터 로딩 오류!\n", filepath);
    }
  }

  private void saveObjects(String filepath, List<?> list) {
    try (PrintWriter out = new PrintWriter(
        new BufferedWriter(
            new FileWriter(filepath, Charset.forName("UTF-8"))))) {

      out.print(new Gson().toJson(list));

      System.out.printf("%s 데이터 출력 완료!\n", filepath);

    } catch (Exception e) {
      System.out.printf("%s 데이터 출력 오류!\n", filepath);
      e.printStackTrace();
    }
  }
}
