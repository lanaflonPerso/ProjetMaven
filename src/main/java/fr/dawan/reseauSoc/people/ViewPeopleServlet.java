package fr.dawan.reseauSoc.people;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/people")
public class ViewPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewPeopleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em= Dao.createEntityManager("JPA");
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "Personalité inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			
			PeopleContent people= Dao.findById(PeopleContent.class, id, em);
			if(people != null) {
				request.setAttribute("error", false);
				request.setAttribute("people", people);
				request.setAttribute("titlePage", people.getFirstName()+" "+people.getLastName());	
			}
		}
		
		request.setAttribute("page", "/WEB-INF/people/ViewPeople.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		em.close();
		Dao.close();
	}
}
