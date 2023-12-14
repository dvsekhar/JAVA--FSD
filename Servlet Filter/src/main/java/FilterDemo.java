

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class FilterDemo
 */
public class FilterDemo extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, jakarta.servlet.FilterChain chain) throws IOException, jakarta.servlet.ServletException {


		PrintWriter pw = response.getWriter();
		String agestr = request.getParameter("age");
		int age = Integer.parseInt(agestr);
		if(age<18)
		{
			pw.write("You are not eligible to vote");
		}
		else {
		chain.doFilter(request, response);
	
		}
	}


}
