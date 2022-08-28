package com.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UpperCaseTag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//super.doTag();
		JspWriter out = getJspContext().getOut();
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw); // passing String writer to invoke so that the passed value
		// can be trapped to body content
		
		out.print("<b> " + sw.toString().toUpperCase() + "</b>");
		
	}

}
