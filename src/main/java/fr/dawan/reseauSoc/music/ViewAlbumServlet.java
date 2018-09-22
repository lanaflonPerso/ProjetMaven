package fr.dawan.reseauSoc.music;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Album;
import fr.dawan.reseauSoc.dao.Dao;

public class ViewAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAlbumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= 0;
		request.setAttribute("error", true);
		request.setAttribute("titlePage", "Album Inconnue");
		
		if(request.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
			} catch (Exception e) {
				
			}
			
			Album album= Dao.findById(Album.class, id);
			if(album != null) {
				request.setAttribute("error", false);
				request.setAttribute("album", album);
				request.setAttribute("titlePage",album.getBand().getBandName()+" "+album.getTitle());	
			}
		}
		
		request.setAttribute("page", "/WEB-INF/music/ViewAlbum.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

}
