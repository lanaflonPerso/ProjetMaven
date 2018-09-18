package fr.dawan.reseauSoc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.movie.MovieBo;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value= request.getParameter("search");
		
		List<Movie> movies= MovieBo.findByTitle(value);
		request.setAttribute("movies", movies);
		
		request.setAttribute("page", "/WEB-INF/view/Search.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}
