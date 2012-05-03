package com.csr.clients.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;
import com.csr.common.dao.DAO;
import com.csr.common.dao.DAOFactory;
import com.csr.common.util.*;

import org.apache.log4j.Logger;

public class ListClientsAction extends Action 	// basepagingaction
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
		Logger log = Logger.getLogger(ListClientsAction.class);
		String result = SUCCESS;

		try
		{
			String pgPtr = (String) request.getParameter("pgPtr");
			if (pgPtr==null || "".equals(pgPtr))
				pgPtr = "1";

			DAO dao = DAOFactory.obtain("client");
			// getServlet().log("client dao: " + dao);
			log.info("client dao: " + dao);

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