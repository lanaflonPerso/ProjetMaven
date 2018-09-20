package fr.dawan.reseauSoc.mur;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.user.UserBo;

@WebServlet("/mur/public")
public class MurPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MurPublicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= (User) request.getSession().getAttribute("user");
		EntityManager em= Dao.createEntityManager("JPA");
		List<Mur> bricks= UserBo.findBricks(user.getId(), em);
		
		request.setAttribute("bricks", bricks);
		System.out.println("ici");
		for (Mur mur : bricks) {
			System.out.println("id= "+mur.getId());
			System.out.println("html= "+mur.getHtml());
		}		

		request.setAttribute("page", "/WEB-INF/wall/ViewWallPublic.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		em.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
