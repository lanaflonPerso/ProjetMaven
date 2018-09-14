package fr.dawan.reseauSoc.servlet.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.bo.MovieBo;
import fr.dawan.reseauSoc.ctrl.MovieCtrl;

@WebServlet("/movie/add")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddMovieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "/WEB-INF/form/movie/AddMovie.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int releaseDate= 0;
		Movie movie= new Movie();
		movie.setTitle(request.getParameter("title"));
		movie.setReleaseDate(releaseDate);
		movie.setSynopsis(request.getParameter("synopsis"));
		movie.setPicture(request.getParameter("picture"));
		try {
			releaseDate= Integer.valueOf(request.getParameter("releaseDate"));
		} catch (Exception e) {	}
		
		MovieCtrl ctrl= new MovieCtrl(movie);
		if(!ctrl.isError()) {
			MovieBo.save(movie);
			response.sendRedirect(request.getContextPath()+"/movie?id="+movie.getId());
			return;
		}		
		
		request.setAttribute("error", ctrl);
		request.setAttribute("movie", movie);
		doGet(request, response);
	}
}
