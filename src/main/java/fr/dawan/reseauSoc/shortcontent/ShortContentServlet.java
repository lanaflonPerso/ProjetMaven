package fr.dawan.reseauSoc.shortcontent;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.ctrl.ShortContentCtrl;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/shortcontent")
public class ShortContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShortContentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "/WEB-INF/wall/ViewWallPublic.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= (User) request.getSession().getAttribute("user");
		String shortContent= request.getParameter("shortContent");
		
		EntityManager em= Dao.createEntityManager("JPA");
		ShortContentCtrl ctrl= new ShortContentCtrl(shortContent, user, em);
		em.close();
		if(!ctrl.isError()) {
			response.sendRedirect(request.getContextPath()+"/wall");
			return;			
		}
		request.setAttribute("error", ctrl);
		
		doGet(request, response);
	}
}
