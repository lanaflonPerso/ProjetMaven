package fr.dawan.reseauSoc.user;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em= Dao.createEntityManager("JPA");
		
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "Utilisateur Inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			List<Mur> bricks= UserBo.findMyBricks(id, em );
	
			User searchedUser= bricks.get(0).getUser();
				request.setAttribute("error", false);
				request.setAttribute("searchedUser", searchedUser);
				request.setAttribute("bricks", bricks);
			request.setAttribute("titlePage", searchedUser.getFirstName()+" "+searchedUser.getLastName());	

		}		
		request.setAttribute("page", "/WEB-INF/user/ViewUser.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		
		em.close();
		Dao.close();
	}
}
