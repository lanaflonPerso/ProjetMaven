package fr.dawan.reseauSoc.people;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Function;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.movie.MovieBo;

@WebServlet("/people/add")
public class SavePeopleContentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public SavePeopleContentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("function", request.getParameter("function"));
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("type", request.getParameter("type"));
		
		
		
		request.setAttribute("page", "/WEB-INF/people/AddPeople.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName= request.getParameter("lastName");
		String lastName= request.getParameter("firstName");
		String biography= request.getParameter("biography");
		String picture= request.getParameter("picture");
		int birthday = 0;
		try {
			if(request.getParameter("birthday") != null)
			birthday= Integer.valueOf(request.getParameter("birthday"));
		} catch (Exception e) {
		}
		
		PeopleContentCtrl ctrl= new PeopleContentCtrl(firstName, lastName, picture, biography, birthday);
	
		if(!ctrl.isError()) {
			PeopleContent people= ctrl.getPeople();
			if(request.getParameter("type") != null && request.getParameter("function") != null) {
				String type= request.getParameter("type");
				String function= request.getParameter("function");
				int id= 0;
				try {
					id= Integer.valueOf(request.getParameter("id"));
				} catch (Exception e) {
					// TODO: Rajouter une exception si l'id n'est pas convertible en Integer!!!
				}
				
				if(function.equals("actor")) {
					if(type.equals("movie")) {
						Function func= new Function("actor");
						people.setFunction(func);
						Movie movie= MovieBo.findById(Movie.class, id);
						movie.setActor(people);
						MovieBo.saveOrUpdate(movie);
						response.sendRedirect(request.getContextPath()+"/movie?id="+movie.getId());
						return;
					}
				}	
			} else {			
				PeopleContentBo.saveOrUpdate(people);
				response.sendRedirect(request.getContextPath()+"/people?id="+people.getId());
				return;
			}
		}
		
		request.setAttribute("error", ctrl);
		doGet(request, response);
	}

}
