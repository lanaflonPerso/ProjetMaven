package fr.dawan.reseauSoc.user;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.ctrl.UserCtrl;
import fr.dawan.reseauSoc.dao.Dao;

@WebServlet("/user/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InscriptionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "/WEB-INF/form/user/Inscription.jsp");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user= new User();
		user.setLastName(request.getParameter("lastName"));
		user.setFirstName(request.getParameter("firstName"));
		user.setEmail(request.getParameter("email"));
		String pass1= request.getParameter("passwordC");
		String pass2= request.getParameter("password");
		
		UserCtrl ctrl= new UserCtrl(user, pass1, pass2);
		if (!ctrl.isError()) {
			user.setPassword(pass1);
			EntityManager em= Dao.createEntityManager("JPA");
			UserBo.saveOrUpdate(user, em);
			user.setPassword("");
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/");
			return;
		}
		request.setAttribute("user", user);
		request.setAttribute("error", ctrl);
		doGet(request, response);
	}
}
