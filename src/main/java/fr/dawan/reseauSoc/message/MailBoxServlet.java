package fr.dawan.reseauSoc.message;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Message;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/mailbox")
public class MailBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MailBoxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= (User) request.getSession().getAttribute("user");
		
		EntityManager em= Dao.createEntityManager("JPA");
		if(request.getParameter("status") != null) {
			if(request.getParameter("status").equals("ok")) {
				request.setAttribute("status", true);
			} else if(request.getParameter("status").equals("delete")) {
				try {
					int id= Integer.valueOf(request.getParameter("id"));
					Message message= MessageDao.findById(id, em);
					MessageDao.delete(message, em);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		List<Message> messages= MessageDao.findAll(user.getId(), em);
		request.setAttribute("messages", messages);
		
		request.setAttribute("page", "/WEB-INF/message/ViewMailBox.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		Dao.close(em);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
