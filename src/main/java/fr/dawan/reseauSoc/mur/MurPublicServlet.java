package fr.dawan.reseauSoc.mur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.Mur;
import fr.dawan.reseauSoc.beans.User;

@WebServlet("/mur/public")
public class MurPublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MurPublicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		User user= new User();
//		user.setId(1);
//		MurBo.findByFollower(user);// request.getSession().getAttribute("user")
//		
//		for (Mur follower : followers) {
//			System.out.println("mur 1");
//			System.out.println(follower.toString());
//		}
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
