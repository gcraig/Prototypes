package com.csr.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.commons.beanutils.PropertyUtils;

//import org.apache.commons.beanutils.PropertyUtils;

//import com.csr.billing.dao.InvoiceDAO;
import com.csr.common.util.*;
import com.csr.common.dto.*;
import com.csr.common.dao.*;

import java.util.*;

public class DynamicViewFormAction extends Action
{
    public static String SUCCESS = "success";
    public static String FAIL = "fail";

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception
	{
		String result = SUCCESS;

		try
		{
			String title = (String) mapping.getParameter();
			String id = (String) request.getParameter("id");

			Class clazz = Class.forName( title );

			DAO dao = DAOFactory.obtain("dao");
			//GenericDAO dao = new GenericDAO(clazz, HibernateUtil.currentSession());

			title = clazz.getName();
			int idx = title.lastIndexOf(".");
			title = title.substring(idx+1);

			// 1.5, real db
			// Object o = dao.findByID(id);
			Object o = dao.view(id);

			Orderable or = (Orderable) o;

			Map order = or.getOrder();
			Map props = or.getValues();

			request.setAttribute("title", title);
			request.setAttribute("order", order);
			request.setAttribute("props", props);
		}
		catch (Exception e)
		{
			e.printStackTrace(); // log
			result = FAIL;
			throw e;
		}

		return mapping.findForward(result);
    }
}