package fr.dawan.reseauSoc.movie;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/movie")
public class ViewMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMovieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		EntityManager em= Dao.createEntityManager("JPA");
		
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "Film Inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			
			Movie movie= MovieBo.findById(Movie.class, id, em);
			if(movie != null) {
				request.setAttribute("error", false);
				request.setAttribute("movie", movie);
				request.setAttribute("actors", movie.getActors());
				request.setAttribute("categorys", movie.getCategorys());
				request.setAttribute("titlePage", movie.getTitle());	
			}
		}
		
		request.setAttribute("page", "/WEB-INF/movie/ViewMovie.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		em.close();
	}
}
