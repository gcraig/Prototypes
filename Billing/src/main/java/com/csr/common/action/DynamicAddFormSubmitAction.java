package com.csr.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.*;
import org.apache.struts.validator.*;

import com.csr.common.dao.*;
import com.csr.common.dto.*;

import org.hibernate.*;
import java.util.*;
import java.io.*;

public class DynamicAddFormSubmitAction extends Action 
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
			DynaActionForm frm = (DynaActionForm) form;
			String title = (String) mapping.getParameter();

			// add generic dao
			//"com.csr.product.dto.Product"
			Object obj = Class.forName( title ).newInstance();
			BeanUtils.populate( obj, BeanUtils.describe(frm) );
			Map frmProps = BeanUtils.describe(frm);

			Orderable ord = (Orderable) obj;
			Map order = ord.getOrder();

//			System.out.println("\nobj: " + obj);
			System.out.println("\ndescribed frm: " + BeanUtils.describe(frm));
			System.out.println("\norder: " + order);
			System.out.println("\ntitle: " + title);

			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			HibernateUtil.closeSession();

			MessageBean msg = new MessageBean();
			//msg.setMessage("Product: " /*+ prod.getProductID()*/ + " saved successfully.");
			msg.setMessage("Save Successful");

			title = obj.getClass().getName();
			int idx = title.lastIndexOf(".");
			title = title.substring(idx+1);
			String sub = "/Add" + title + "Submit";
			
			request.setAttribute("messageBean", msg);
			request.setAttribute("title", title);
			request.setAttribute("frmProps", frmProps);
			request.setAttribute("order", order);
			request.setAttribute("sub", sub);
		}
		catch (Exception e)
		{
			result = FAIL;
			System.err.println("\nERROR: " + e + "\n");
			//throw e;
		}

		return mapping.findForward(result);
    }
}