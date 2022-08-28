package com.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomDate extends SimpleTagSupport{
	// this will be date based on an attribute
	private String format;

	public void setFormat(String format) {
		this.format = format;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//super.doTag();
		JspWriter out = getJspContext().getOut();
		out.print("<h3> Custom date is : " 
		+ new SimpleDateFormat(format).format(new Date()) + "</h3>");
		// this custom tag will simply print the date in the format above
		
		// we are allowing user to set the format for the date and with that format date will be set
		
		
	}
}
