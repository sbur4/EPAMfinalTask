package com.epam.trainingcenter.eshop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author sburch
 * @version 1.0
 * This filter makes encoding with charset utf-8.
 */

public class LanguageFilter implements Filter {
    private String encoding;
    private ServletContext context;

    /**
     * Default constructor
     */
    public LanguageFilter() {
    }

    /**
     * Method cleans resource
     */
    public void destroy() {
    }

    /**
     * Method makes filter by chain on request and response
     *
     * @param request
     * @param response
     * @param chain
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        this.context.log("charset set");
        chain.doFilter(request, response);
    }

    /**
     * Method calls to indicate a filter config
     *
     * @param fConfig
     */
    public void init(FilterConfig fConfig) throws ServletException {
        this.encoding = fConfig.getInitParameter("characterEncoding");
        this.context = fConfig.getServletContext();
    }
}
