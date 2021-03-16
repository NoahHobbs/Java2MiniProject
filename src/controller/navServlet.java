package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
/**
 * Servlet implementation class navServlet
 */
@WebServlet("/navServlet")
public class navServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navServlet() {
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
		String act = request.getParameter("doThisToItem");
		
		String path = "";
		OwnerHelper oh = new OwnerHelper();
		PetsHelper ph = new PetsHelper();
		if(act.equals("deleteO")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				oh.deleteOwner(tempId);
				path = "/ownersServlet";
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select an Owner");
			}
		} 
		else if(act.equals("deleteP")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ph.deletePet(tempId);
				path = "/viewAllPetsServlet";
			}catch (NumberFormatException e) {
				System.out.println("Forgot to select a Pet");
			}
		} 
		else if(act.equals("addO")) {
			try {
				Owner ownerToAdd = new Owner(request.getParameter("nameO"));
				oh.insertOwner(ownerToAdd);
				path = "/ownersServlet";
			}catch (Exception e) {
				System.out.println("Invalid Owner name");
			}
		}else path = "/index.html";
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
