package br.com.al.jho.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class Sucesso
 */
@WebServlet("/Sucesso")
public class Sucesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Sucesso() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		HttpSession session = request.getSession();
		
		session = request.getSession(true);
		//tentando pegar o usuario e email da sessão
		String user = (String) session.getAttribute("usr");
		String email = (String) session.getAttribute("email");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	
		try {
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<head>");
			out.println("<title>Download</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"index\">");
			out.println("<div>");
			out.println("<h1>Seus dados</h1>");
			out.println("<br>");
			out.println("<br>");
			out.println("<form action=\"/project01-dsw/Download\" method=\"POST\">");
			out.println("<p>Nome: " + user + "</p>");
			out.println("<p>Email: " + email + "</p>");
			out.println("<br>");
			out.println("<br>");
			out.println("<input type=\"submit\" value=\"Download\">");
			out.println("</form>");
			out.println("<br>");
			out.println("</div>");
			out.println("</div>");
			out.println();
			out.println("</body>");
			out.println("</html>");
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
