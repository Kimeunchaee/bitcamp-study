package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/member/list")

// GenericServlet 상속
// Servlet, ServletConfig, java.io.Serializable 을 구현해놓은? 메서드인 GenericServlet를 사용하면 편하다

public class MemberListHandler extends GenericServlet {

  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.print("<html>");
    out.print("<head>");
    out.println("   <title>회원 목록</title>");
    out.print("</head>");

    out.print("<body>");
    out.println("<h1>[회원 목록]</h1>");
    out.print("<a href = 'form'>새회원</a><br>");
    try {
      Collection<Member> memberList = memberDao.findAll();

      for (Member member : memberList) {
        out.printf("%d, <a href ='detail?no=%1$d'>%s</a>, %s, %s, %s</br>", 
            member.getNo(), 
            member.getName(), 
            member.getEmail(), 
            member.getTel(), 
            member.getRegisteredDate());
      }
    }catch (Exception e) {
      //out.println("회원 목록 조회 오류!");
      throw new ServletException(e);
    }

    out.print("</body>");
    out.print("</html>");
  }
}



