package quizze;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ans1 = request.getParameter("q1");
		String ans2 = request.getParameter("q2");
		String ans3 = request.getParameter("q3");
		String ans4 = request.getParameter("q4");
		String ans5 = request.getParameter("q5");
		String ans6 = request.getParameter("q6");
		String ans7 = request.getParameter("q7");
		String ans8 = request.getParameter("q8");
		String ans9 = request.getParameter("q9");
		String ans10 = request.getParameter("q10");
		
		int score = 0;
		if(ans1 != null && ans1.equals("a")) {
			score++;
		}
		if(ans2 != null && ans2.equals("c")) {
			score++;
		}
		if(ans3 != null && ans3.equals("c")) {
			score++;
		}
		if(ans4 != null && ans4.equals("b")) {
			score++;
		}
		if(ans5 != null && ans5.equals("a")) {
			score++;
		}
		if(ans6 != null && ans6.equals("b")) {
			score++;
		}
		if(ans7 != null && ans7.equals("c")) {
			score++;
		}
		if(ans8 != null && ans8.equals("a")) {
			score++;
		}
		if(ans9 != null && ans9.equals("b")) {
			score++;
		}
		if(ans10 != null && ans10.equals("a")) {
			score++;
		}
		//System.out.println(score);
		
		response.getWriter().print("You scored "+score+" out of 10.");
		
	}

}
