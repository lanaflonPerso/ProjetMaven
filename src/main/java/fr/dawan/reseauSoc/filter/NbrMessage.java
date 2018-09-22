package fr.dawan.reseauSoc.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import fr.dawan.reseauSoc.beans.User;
import fr.dawan.reseauSoc.dao.Dao;
import fr.dawan.reseauSoc.message.MessageDao;

public class NbrMessage implements Filter {

    public NbrMessage() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        
        if(req.getSession().getAttribute("user") != null) {
        	EntityManager em= Dao.createEntityManager("JPA");
        	
        	User user= (User) req.getSession().getAttribute("user");
        	long nbrMessage= MessageDao.countMessage(user.getId(), em);
        	req.getSession().setAttribute("nbrMessage", nbrMessage);
        	em.close();
    		Dao.close();	
        }
        chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
