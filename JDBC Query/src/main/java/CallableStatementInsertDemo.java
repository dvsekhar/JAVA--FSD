

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbcutil.JDBCUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class CallableStatementInsertDemo extends HttpServlet {
	private Connection connection = null;
	
	public void init(ServletConfig config) {

		try {
			InputStream in = config.getServletContext().getResourceAsStream("/WEB-INF/database.properties");
			Properties props = new Properties();
			props.load(in);
			String url = props.getProperty("url");
			String userid = props.getProperty("userid");
			String password = props.getProperty("password");

			JDBCUtil dbUtil = new JDBCUtil(url, userid, password);

			connection = dbUtil.getConnection();

		} catch (ClassNotFoundException | SQLException | IOException  e) {			e.printStackTrace(); 		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		String amtStr = request.getParameter("amount");
		float amount = Float.parseFloat(amtStr);
		
		String customerName =  request.getParameter("customer");
		
		try {
			CallableStatement callableStatement = connection.prepareCall("{ call add_product(?, ?) }");
			
			callableStatement.setFloat(1, amount);
			callableStatement.setString(2, customerName);
			
			int count = callableStatement.executeUpdate();
			pw.printf("<b> %s row(s) </b> inserted succesfully",count);
			
		} catch (SQLException e) {			
			e.printStackTrace();
			pw.printf("Inserted Failed!!");
		}
		
		pw.close();
		
	}

}