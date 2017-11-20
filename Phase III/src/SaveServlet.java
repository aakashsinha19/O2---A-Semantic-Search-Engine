

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esearch.SearchClient;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String docName = request.getParameter("docName");
		String content = request.getParameter("content");
		String authorName = request.getParameter("authorName");
		
		String filePath = request.getParameter("uploadFile");
		System.out.println("path: " + filePath);

		boolean indexed = SearchClient.indexDoc(docName, content, authorName, false);
		
		if (indexed) {
			System.out.println("Indexed :)");
			response.sendRedirect("index.jsp");
		}
		else
			System.out.println("Not indexed :(");
	}

}
