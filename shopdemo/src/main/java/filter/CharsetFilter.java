package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharsetFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletResponse resp=(HttpServletResponse) servletResponse;

        HttpServletRequest req=(HttpServletRequest)servletRequest;

        req.setCharacterEncoding("utf-8");

        resp.setCharacterEncoding("utf-8");

        filterChain.doFilter(req,resp);

    }
}
