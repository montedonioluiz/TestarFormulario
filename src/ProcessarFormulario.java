

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessarFormulario
 */
@WebServlet("/processar")
public class ProcessarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome"); //yyyy-mm-dd
		String nomeCompleto = nome + " " + sobrenome;
		Calendar data = Calendar.getInstance();
		
		int year = Integer.parseInt(request.getParameter("niver").substring(0,4));
		int month = Integer.parseInt(request.getParameter("niver").substring(5, 7));
		int day = Integer.parseInt(request.getParameter("niver").substring(8));
		
		int age = 2018 - year;
		if(month > (data.get(Calendar.MONTH) + 1)) {
			age--;
		} else if(month == (data.get(Calendar.MONTH) + 1)) {
			if(day > data.get(Calendar.DATE)) {
				age--;
			}
		}
		
		out.println("<html>"
				  	+ "<head>"
				  		+ "<title>Resposta</title>"
				  	+ "</head>"
				  	+ "<body>"
				  		+ "<h1>Seu nome completo é: " + nomeCompleto + "</h1>"
				  		+ "<h2>Sua idade é: " + age + "</h2>"
				  	+ "</body>"
				  + "</html>");
	}

}
