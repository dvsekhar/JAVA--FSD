

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		HttpSession httpSession = request.getSession(false);
		
		String userid =null;
				
		if(httpSession!=null) {
			userid = (String) httpSession.getAttribute("userid");
			pw.printf("Welcome %s", userid);
			pw.println("<div align='center'> <a href='LogoutServlet'>Logout</a> </div>");
		}
		else {
			pw.printf("Welcome %s, there was no http session object <br>", userid);

			pw.println("<div align='center'> <a href='LogoutServlet'>Logout</a> </div>");
		}
		
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
