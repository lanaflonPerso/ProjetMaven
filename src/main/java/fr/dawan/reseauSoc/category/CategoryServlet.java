package fr.dawan.reseauSoc.category;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em= Dao.createEntityManager("JPA");
		
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "Categorie Inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			
			Category category= Dao.findById(Category.class, id, em);
			if(category != null) {
				request.setAttribute("error", false);
				request.setAttribute("category", category);
				request.setAttribute("titlePage", category.getName());	
			}
		}
		
		request.setAttribute("page", "/WEB-INF/category/ViewCategory.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		em.close();
		Dao.close();
	}
}
