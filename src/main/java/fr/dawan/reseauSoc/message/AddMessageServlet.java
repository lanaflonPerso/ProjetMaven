package fr.dawan.reseauSoc.message;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.ctrl.MessageCtrl;
import fr.dawan.reseauSoc.dao.Dao;

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
		
		EntityManager em= Dao.createEntityManager("JPA");
		MessageCtrl ctrl= new MessageCtrl(user, receiverId, contents, em);
		
		em.close();
		Dao.close();
		if(!ctrl.isError()) {
			EntityManager em1= Dao.createEntityManager("JPA");
			MessageDao.saveOrUpdate(ctrl.getMessage(), em1);
			em1.close();
			Dao.close();
			response.sendRedirect(request.getContextPath()+"/mailbox?status=ok");
			return;
		}
		
		
		doGet(request, response);
	}

}
