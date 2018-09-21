package fr.dawan.reseauSoc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectionUser implements Filter {

    public ConnectionUser() {
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        if(req.getSession().getAttribute("user") == null) {
        	res.sendRedirect(req.getContextPath()+"/user/connection");
        	return;
        } else {
        	chain.doFilter(request, response);
        }
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
