package com.eomcs.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@WebServlet("/member/detail")
public class MemberDetailHandler extends GenericServlet {

  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    memberDao = (MemberDao) 웹애플리케이션공용저장소.getAttribute("memberDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException { // 오직 ServletException, IOException만 던진다!!

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("   <title>회원상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세</h1>");

    // no를 받아서 오겠습니다
    // 브라우저에게 넘겨 주기
    int no = Integer.parseInt(request.getParameter("no"));

    try {
      Member member = memberDao.findByNo(no);


      if (member == null) {
        out.println("해당 번호의 회원이 없습니다.");

      } else {
        out.println("<form cation='update'>");
        out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", member.getNo());
        out.printf("이름: <input type='text' name='name' value='%s'><br>\n", member.getName());
        out.printf("이메일: <input type='text' name='email' value='%s'><br>\n", member.getEmail());
        out.println("암호: <input type='text' name='password'><br>\n");
        out.printf("사진: <input type='text' name='photo' value='%s'><br>\n", member.getPhoto());
        out.printf("전화: <input type='text' name='tel' value='%s'><br>\n", member.getTel());
        out.printf("등록일: %s<br>", member.getRegisteredDate());
        out.println();

        out.println("<a href='delete?no=%d'><button>[변경]</button></a>");
        out.printf(" <a href='delete?no=%d'>[삭제]</a>", member.getNo());
        out.println(" <a href='list'>[목록]</a>");
        out.print("</form>");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }

}








