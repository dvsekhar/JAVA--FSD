

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
import java.sql.Statement;
import java.util.Properties;

public class InsertUpdateDelete extends HttpServlet {
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
	private static final long serialVersionUID = 1L;
       
    public InsertUpdateDelete() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
			
		try {
			Statement stmt = connection.createStatement();
			
			int count = stmt.executeUpdate("INSERT INTO ORDERS VALUES(null,200.95,'Jalan')");
			
			pw.printf("<b> %s </b> inserted succesfully",count);
			
			int count1 = stmt.executeUpdate("UPDATE ORDERS SET AMOUNT=2635.99 WHERE CUSTOMER_NAME='Phani'");
			
			pw.printf("<b> %s </b> inserted succesfully",count1);
			
			int count2 = stmt.executeUpdate("DELETE FROM ORDERS WHERE CUSTOMER_NAME='Raju'");
			
			pw.printf("<b> %s </b> inserted succesfully",count2);
			
		} catch (SQLException e) {			
			e.printStackTrace();
			pw.printf("Inserted Failed!!");
		}
		
		pw.close();

	}
		
		
		/*try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO ORDERS VALUES(null,200.75,'Mr.Jalan')");
			pw.println("Executed an insert operation<br>");
            
            stmt.executeUpdate("update ORDERS set AMOUNT=2000 where CUSTOMER_NAME = 'Raju'");
            pw.println("Executed an update operation<br>");
            
            stmt.executeUpdate("delete from ORDERS where CUSTOMER_NAME = 'Phani'");
            pw.println("Executed a delete operation<br>");
		
			
		} catch (SQLException e) {			
			e.printStackTrace();
			pw.printf("Inserted Failed!!");
		}
		
		pw.close();
		
	}*/

}
