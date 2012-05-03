package com.csr.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.commons.beanutils.PropertyUtils;

//import com.csr.billing.dao.InvoiceDAO;
import com.csr.common.util.*;
import com.csr.common.dao.*;
import com.csr.common.dto.*;

import java.util.*;

// Add
public class DynamicFormAction extends Action
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
			DynaActionForm frm = (DynaActionForm) form;	// reset frm
			System.out.println("\nfrm: " + frm + "\n");
			Map frmProps = (frm!=null) ? frm.getMap() : null;
			String title = (String) mapping.getParameter();

			/* /////////////////// */
			/* cache instance, todo make static maps */
			Object obj = Class.forName(title).newInstance();
			Orderable ord = (Orderable) obj;
			Map order = ord.getOrder();
			/* /////////////////// */

			title = obj.getClass().getName();
			int idx = title.lastIndexOf(".");
			title = title.substring(idx+1);

			String sub = "/Add" + title + "Submit";

			request.setAttribute("title", title);
			request.setAttribute("frmProps", frmProps);
			request.setAttribute("order", order);
			request.setAttribute("sub", sub);
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