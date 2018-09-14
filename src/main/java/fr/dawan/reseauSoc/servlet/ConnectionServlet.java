package fr.dawan.reseauSoc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.bo.UserBo;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/user/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConnectionServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("type") != null) {
			if (request.getParameter("type").equals("off")) {
				session.invalidate();
				response.sendRedirect(request.getContextPath()+"/");
				return;
			}
		}
		request.setAttribute("page", "/WEB-INF/form/user/Connection.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= Dao.MySQLPassword(request.getParameter("password"));
		
		User user= UserBo.findByEmail(email);
		if(user != null) {
			if (password.equals(user.getPassword())) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/");
				return;
			}
		}
		request.setAttribute("error", "Erreur sur le formulaire de connection");
		doGet(request, response);
	}
}
