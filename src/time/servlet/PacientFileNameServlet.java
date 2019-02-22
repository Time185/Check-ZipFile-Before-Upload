package time.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PacientFileNameServlet
 */
@WebServlet("/PacientFileNameServlet")
public class PacientFileNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("收到了请求");
		
		File file = new File("E:\\asd\\011");
		
		File[] fileList = file.listFiles();
		
		String pacientFileName = " ";
		
		List<String> list = new ArrayList<String>();
		
		
		for (int i = 0; i < fileList.length; i++) {
			if(fileList[i].isDirectory()) {
				list.add(fileList[i].getName());
			}
		}
		for (String string : list) {
			System.out.println(string);
			pacientFileName = pacientFileName + string + " ";
		}
		System.out.println(pacientFileName);
		HttpSession session = request.getSession();
		session.setAttribute("patientName", pacientFileName);
		
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
