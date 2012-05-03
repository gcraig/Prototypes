package com.csr.clients.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.csr.common.util.*;
import com.csr.common.dao.*;

import java.util.List;

/**
 * Dispatch control to the "success" forward.
 *
 * @version $Rev: 54929 $ $Date: 2004-10-16 17:38:42 +0100 (Sat, 16 Oct 2004) $
 */

public class TestClientsAction extends Action {

    public static String SUCCESS = "success";
    public static String FAIL = "fail";

    /**
     * Dispatch control to the "success" forward.
     */
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

		String result = SUCCESS;

		try
		{
			String pgPtr = (String) request.getParameter("pgPtr");
//			String pageSize = (String) request.getParameter("pageSize");

			if (pgPtr==null || "".equals(pgPtr))
				pgPtr = "1";

//			if (pageSize==null || "".equals(pageSize))
//				pageSize = "3";

			DAO dao = DAOFactory.obtain("client");
			ValueListHandler handler = new ValueListHandler(dao, 15);  //appconfig
			List clients = handler.page(toInt(pgPtr));

			request.setAttribute("clients", clients);
			request.setAttribute("handler", handler);
		}
		catch (Exception e)
		{
			e.printStackTrace();
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