package fr.dawan.reseauSoc.filter;

import java.io.IOException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.like.LikeBo;

public class FollowersFilter implements Filter {

    public FollowersFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        EntityManager em= Dao.createEntityManager("JPA");
        int id= 0;
        
        if(req.getParameter("id") != null) {
			try {
				id= Integer.valueOf(request.getParameter("id"));	
				Set<User> followers= LikeBo.findByType(id, em);
				request.setAttribute("followers", followers);
			} catch (Exception e) {
				res.sendError(404, "Contenu introuvable");
			}
        }
        
		em.close();
		Dao.close();
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
