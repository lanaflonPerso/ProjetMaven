package fr.dawan.reseauSoc.message;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Message;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/mailbox/view")
public class ViewMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em= Dao.createEntityManager("JPA");
		int messageId= 0;
		try {
			messageId= Integer.valueOf(request.getParameter("id"));
			Message message= MessageDao.findById(messageId, em);
			request.setAttribute("message", message);	
		} catch (Exception e) {
			response.sendError(404, "le message n'existe pas");
		}
		
		
		
		request.setAttribute("page", "/WEB-INF/message/ViewMessage.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		Dao.close(em);
	}
}
