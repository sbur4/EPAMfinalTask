package com.epam.trainingcenter.eshop.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * The {@code EpamCustomTag} class represents price tag as price sign
 *
 * @author sburch
 * @version 1.0
 */

public class EpamCustomTag extends SimpleTagSupport {
    private static final String EPAM = "2021 epam training center";

    /**
     * Make tag on page
     *
     * @throws JspException
     * @throws IOException
     */
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println(EPAM);
    }
}
