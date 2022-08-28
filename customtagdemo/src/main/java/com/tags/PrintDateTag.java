package com.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintDateTag extends SimpleTagSupport{
	// this is customer tag we are trying to generate
	
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		//super.doTag();
		JspWriter out = getJspContext().getOut();
		out.print("<h3> Current date is : " 
		+ new SimpleDateFormat("dd-mm-yyyy hh:mm:ss EEE").format(new Date()) + "</h3>");
		// this custom tag will simply print the date in the format above
		
		
	}

}
