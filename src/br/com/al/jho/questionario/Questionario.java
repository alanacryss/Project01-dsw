package br.com.al.jho.questionario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Questionario
 */
@WebServlet("/Questionario")
public class Questionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Questionario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		try {
			HttpSession session = request.getSession();

			String name = (String) session.getAttribute("jho");

			if (!name.equals(null)) {
				response.setContentType("text/html");
				// response.sendRedirect("/project01-dsw/questionario.html");

				PrintWriter out = response.getWriter();

				request.getAttribute("usr");

				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<meta charset=\"UTF-8\">");
				out.println("<head>");
				out.println("<title>DSW 01</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">");
				out.println("</head>");
				out.println("<body>");
				out.println("<div class=\"index\">");
				out.println("<div>");
				out.println("<h1>Questionário</h1>");
				out.println("<br>");
				out.println("<br>");
				out.println("<form action=\"/project01-dsw/Cadastro\" method=\"POST\">");
				out.println("Qual a linguagem de programação preferida? <select name=\"linguagem\">");
				out.println("<option value=\"C++\">C++</option>");
				out.println("<option value=\"C\">C</option>");
				out.println("<option value=\"C#\">C#</option>");
				out.println("<option value=\"JAVA\">JAVA</option>");
				out.println("<option value=\"JAVASCRIPT\">JAVASCRIPT</option>");
				out.println("<option value=\"PHP\">PHP</option>");
				out.println("<option value=\"ANDROID\">ANDROID</option>");
				out.println("</select>");
				out.println("<br>");
				out.println("<br>");
				out.println("Quais paradigmas de programação você trabalhou? </br>");
				out.println("<input type=\"checkbox\" name=\"paradigmas\" value=\"estruturado\">Estruturado<br>");
				out.println("<input type=\"checkbox\" name=\"paradigmas\" value=\"orientado\">Orientado a objetos<br>");
				out.println("<input type=\"checkbox\" name=\"paradigmas\" value=\"funcional\">Funcional<br>");
				out.println("<input type=\"checkbox\" name=\"paradigmas\" value=\"aspectos\">Aspectos<br>");
				out.println();
				out.println("<br>");
				out.println("<br>");
				out.println();
				out.println("Quantos anos você possui de experiência? <input type=\"text\" name=\"anos_exp\">");
				out.println();
				out.println("<br>");
				out.println("<br>");
				out.println("Possui alguma certificação?");
				out.println("<br><input type=\"radio\" name=\"certificacao\" value=\"sim\">Sim <br>");
				out.println("<input type=\"radio\" name=\"certificacao\" value=\"nao\">Não <br>");
				out.println();
				out.println("<br>");
				out.println("<br>");
				out.println();
				out.println("Descreva suas principais habilidades:");
				out.println("<br>");
				out.println("<textarea name=\"habilidades\" rows=\"3\" cols=\"70\" maxlength=\"500\"></textarea>");
				out.println();
				out.println("<br>");
				out.println("<br>");
				out.println();
				out.println("<input type=\"submit\" value=\"Enviar\">");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				out.println();
				out.println("</body>");
				out.println("</html>");
				out.close();
			}
		} catch (Exception e) {
			response.sendRedirect("/project01-dsw/index.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
