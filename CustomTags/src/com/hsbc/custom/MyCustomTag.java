package com.hsbc.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyCustomTag extends BodyTagSupport {
	
	int counter;
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public int doStartTag() throws JspException {
		
		// TODO Auto-generated method stub
		System.out.println("Start Tag encountered");
		try {
			pageContext.getOut().println("<h2>Demo Custom Tag");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	
	int i=0;
	@Override
	public int doAfterBody() throws JspException {
		i++;
		if(i<counter) {
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("End Tag encountered");
		try {
			pageContext.getOut().println("</h2>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
