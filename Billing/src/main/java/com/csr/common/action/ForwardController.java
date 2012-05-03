package com.csr.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.csr.common.dao.DAO;
import com.csr.common.dao.DAOFactory;
import com.csr.common.util.*;

import java.util.List;

public class ForwardController implements Controller {

	private String viewName;

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

    public ModelAndView handleRequest(
        HttpServletRequest request,
        HttpServletResponse response)
    throws Exception {

		ModelAndView mav = new ModelAndView("error.jsp");

		try
		{
			mav = new ModelAndView( viewName );
		}
		catch (Exception e)
		{
			e.printStackTrace(); // todo:log
			throw e;
		}

        return mav;        
    }
}