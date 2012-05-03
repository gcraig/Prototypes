package com.csr.billing.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.csr.common.util.*;
import com.csr.common.dao.*;
import java.util.List;

public class ListProductsAction extends Action
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
			String pgPtr = (String) request.getParameter("pgPtr");
			if (pgPtr==null || "".equals(pgPtr))
				pgPtr = "1";

			DAO dao = DAOFactory.obtain("product");
			ValueListHandler handler = new ValueListHandler(dao, 15);  //appconfig
			List products = handler.page(toInt(pgPtr));

			request.setAttribute("products", products);
			request.setAttribute("handler", handler); // product_pager
		}
		catch (Exception e)
		{
			e.printStackTrace(); // log
			result = FAIL;
		}

		return mapping.findForward(result);

    }

	public int toInt(String strValue)
	{
		return
			(strValue==null|| strValue.trim().length() < 1 ) ?
				-1: Integer.parseInt(strValue) ;
	 }

}