

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JDBCQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			
		    Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM ORDERS");

			pw.write("QUERY RESULTS <hr>");
			pw.write("<table border=1>");
			pw.write("<th>ID<th>AMOUNT<th>CUSTOMER NAME");
			while (rs.next()) {

				int orderId = rs.getInt("ORDER_ID");
				float amount = rs.getFloat("AMOUNT");
				String customerName = rs.getString("CUSTOMER_NAME");

				pw.printf("<tr> <td> %s <td> %s <td> %s", orderId, amount, customerName);
			}
			pw.write("</table>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
