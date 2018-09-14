package fr.dawan.reseauSoc.like;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Likable;
import fr.dawan.reseauSoc.beans.Like;
import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LikeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("like").equals("1") || request.getParameter("like").equals("-1")) {
			Likable likable= new Likable();
			int id= 0;
			try {
				id= Integer.valueOf(request.getParameter("id"));
				likable.setId(id);
			} catch (Exception e) {
				response.sendError(403, "le numéro n'est pas cohérent");
				return;
			}
			
			int vote= Integer.valueOf(request.getParameter("like"));
			System.out.println("(User) "+request.getSession().getAttribute("user")+", "+likable+", "+vote);
			Like like= new Like((User) request.getSession().getAttribute("user"), likable, vote);
			
			if(vote == 1) {
				System.out.println("on aime");
				LikeBo.like(id);
			} else if(vote== -1) {
				System.out.println("on n'aime pas!");
				LikeBo.dislike(id);
			}
			Dao.save(like);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}