package fr.dawan.reseauSoc.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.beans.Serie;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.movie.MovieBo;
import fr.dawan.reseauSoc.people.PeopleContentBo;
import fr.dawan.reseauSoc.serie.SerieBo;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value= request.getParameter("search");
		EntityManager em= Dao.createEntityManager("JPA");
		
		List<Movie> movies= MovieBo.findByTitle(value, em);
		List<PeopleContent> peoples= PeopleContentBo.findByLastName(value, em);
		List<Serie> series= SerieBo.findByTitle(value, em);
		request.setAttribute("movies", movies);
		request.setAttribute("peoples", peoples);
		request.setAttribute("series", series);
		
		request.setAttribute("page", "/WEB-INF/view/Search.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		System.out.println("on ferme la connection");
		em.close();
		Dao.close();
	}	
}
