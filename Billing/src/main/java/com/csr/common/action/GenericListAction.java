package com.csr.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.csr.common.util.*;
import com.csr.common.dao.*;
import com.csr.common.dto.*;

import java.util.*;

public class GenericListAction extends Action
{
	//<set-property property="minCount" value="1" />

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

			DAO dao = DAOFactory.obtain("generic");
			ValueListHandler handler = new ValueListHandler(dao, 15);

			int page = Integer.parseInt(pgPtr);
			int start = -1;

			if (page==1)
			{
				start = 1;
			}
			else
			{
				start = ((page - 1) * 15) + 1;
			}




					//appconfig

			List records = handler.page(Str.toInt(pgPtr));
			for (int k=0; k<records.size();k++)
			{
				Object o = (Object) records.get(k);
				if (o instanceof Listable)
				{
					Listable ord = (Listable) o;
					int ss = start + k;
					ord.setRownumber(ss + ".");
				}
				System.out.println(o);
			}



			request.setAttribute("records", records);
			request.setAttribute("handler", handler); // product_pager
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