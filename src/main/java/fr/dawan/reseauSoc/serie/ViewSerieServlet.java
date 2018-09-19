package fr.dawan.reseauSoc.serie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Serie;

public class ViewSerieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewSerieServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "Serie Inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			
			Serie serie= SerieBo.findById(id);
			if(serie != null) {
				request.setAttribute("error", false);
				request.setAttribute("serie", serie);
				request.setAttribute("titlePage", serie.getTitle());	
			}
		}
		
		request.setAttribute("page", "/WEB-INF/serie/ViewSerie.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}
}
