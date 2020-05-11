package hu.alkfejl.filters;

import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {

    private List<String> exclusions;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.exclusions = Arrays.asList(filterConfig.getServletContext().getInitParameter("login-filter-exclusion").split(","));
        this.exclusions.replaceAll(String::trim);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String path = ((HttpServletRequest) request).getServletPath();

        if (exclusions.stream().filter(path::equals).findAny().isPresent()) {
            chain.doFilter(request, response);
            return;
        }

        Orokbefogado currentUser = (Orokbefogado) ((HttpServletRequest) request).getSession().getAttribute("currentUser");

        if (currentUser == null) {
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/pages/login.jsp");
        }
        else{
            chain.doFilter(request, response);
        }


    }
}
