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
import fr.dawan.reseauSoc.user.UserDao;

@WebServlet("/wall")
public class MurPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MurPublicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em= Dao.createEntityManager("JPA");   
		User user= (User) request.getSession().getAttribute("user");
		
		List<Mur> bricks= UserDao.findBricks(user.getId(), em);
		
		request.setAttribute("bricks", bricks);

		request.setAttribute("page", "/WEB-INF/wall/ViewWallPublic.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		Dao.close(em);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
