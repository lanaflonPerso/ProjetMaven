package fr.dawan.reseauSoc.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.ctrl.MessageCtrl;

@WebServlet("/message")
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int receiverId= 0;
		try {
			receiverId= Integer.valueOf(request.getParameter("id"));
		} catch (Exception e) {
			response.sendError(404, "Utilisateur inconnue");
		}
		
		request.setAttribute("receiverId", receiverId);
		request.setAttribute("page", "/WEB-INF/message/FormMessage.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contents= request.getParameter("contents");
		User user= (User) request.getSession().getAttribute("user");
		int receiverId= 0;
		try {
			receiverId= Integer.valueOf(request.getParameter("id"));
		} catch (Exception e) {
			response.sendError(404, "Utilisateur inconnue");
		}
		
		MessageCtrl ctrl= new MessageCtrl(user, receiverId, contents);
		
		if(!ctrl.isError()) {
			MessageDao.saveOrUpdate(ctrl.getMessage());
			response.sendRedirect(request.getContextPath()+"/mailbox?status=ok");
			return;
		}
		
		doGet(request, response);
	}
}
