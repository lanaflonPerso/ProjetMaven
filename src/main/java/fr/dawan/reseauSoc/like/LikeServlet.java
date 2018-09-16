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
import fr.dawan.reseauSoc.movie.MovieBo;
import fr.dawan.reseauSoc.mur.MurBo;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LikeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= 0;
		if(request.getParameter("like").equals("1") || request.getParameter("like").equals("-1")) {
			User user= (User) request.getSession().getAttribute("user");
			Likable likable= new Likable();
			try {
				id= Integer.valueOf(request.getParameter("id"));
				likable.setId(id);
			} catch (Exception e) {
				response.sendError(403, "le numéro n'est pas cohérent");
				return;
			}
			
			int vote= Integer.valueOf(request.getParameter("like"));
			Like like= new Like(user, likable, vote);
			
			switch (request.getParameter("type")) {
			case "movie":
				like.setType("movie");
				LikeBo.save(like);
				MurBo mBo= new MurBo();
				mBo.setMovie(MovieBo.findById(likable.getId()), user);
				response.sendRedirect(request.getContextPath()+"/movie?id="+id);
				return;
			default:
				break;
			}
		}else {
			response.sendError(403, "le numéro n'est pas cohérent");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}