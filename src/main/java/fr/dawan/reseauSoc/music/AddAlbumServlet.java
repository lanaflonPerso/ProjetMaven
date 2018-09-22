package fr.dawan.reseauSoc.music;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Album;
import fr.dawan.reseauSoc.dao.Dao;

public class AddAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAlbumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "/WEB-INF/music/AddAlbum.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title= request.getParameter("title");
		String releaseDate= request.getParameter("releaseDate");
		String bandName= request.getParameter("bandName");
		String picture= request.getParameter("picture");
		
		AlbumCtrl ctrl= new AlbumCtrl(title, releaseDate, bandName, picture);
		if(!ctrl.isError()) {
			Album album= ctrl.getAlbum();
			Dao.saveOrUpdate(album);
			response.sendRedirect(request.getContextPath()+"/album?id="+album.getId());
			return;
		}

		request.setAttribute("error", ctrl);
		doGet(request, response);
	}

}
