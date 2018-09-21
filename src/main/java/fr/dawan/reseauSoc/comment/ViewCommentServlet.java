package fr.dawan.reseauSoc.comment;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.mur.MurBo;

@WebServlet("/comment")
public class ViewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em= Dao.createEntityManager("JPA");
		int id= 0;
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
		}
		Mur brick= MurBo.findById(id, em);
		
		if(brick == null) {
			response.sendError(404, "élément incounnue");	
		}
		
		request.setAttribute("brick", brick);
		
		request.setAttribute("page", "/WEB-INF/comment/ViewComment.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		em.close();
		Dao.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= (User) request.getSession().getAttribute("user");
		String contenu= request.getParameter("comment");
		EntityManager em= Dao.createEntityManager("JPA");
		int id= 0;
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
		}
		Mur brick= MurBo.findById(id, em);
		
		if(brick == null) {
			response.sendError(404, "élément incounnue");	
		}
		
		CommentCtrl ctrl= new CommentCtrl(contenu, user, brick);
		if(!ctrl.isError()) {
			CommentDao.saveOrUpdate(ctrl.getComment(), em);
			response.sendRedirect(request.getContextPath()+"/comment?id="+id);
			return;
		}
		
		request.setAttribute("error", ctrl);
		request.setAttribute("page", "/WEB-INF/comment/ViewComment.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		em.close();
		Dao.close();
	}
}
