package com.csr.billing.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.csr.common.dao.DAO;
import com.csr.common.dao.DAOFactory;
import com.csr.common.util.*;
import java.util.List;

//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import com.csr.services.billing.BillingService;
//import org.apache.log4j.*;

public class ListInvoicesAction extends Action
{
    public static String SUCCESS = "success";
    public static String FAIL = "fail";

//	private ApplicationContext ctx = 
//		WebApplicationContextUtils.
//			getRequiredWebApplicationContext( 
//				getServlet().
//					getServletContext());

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception
	{
		String result = SUCCESS;
//		Category log = Category.getInstance("billing");

		try
		{
			String pgPtr = (String) request.getParameter("pgPtr");
			if (pgPtr==null || "".equals(pgPtr))
				pgPtr = "1";

			//BillingService service = (BillingService) ctx.getBean("BillingService");
			//List invoices = service.getInvoices(Str.toInt(pgPtr));
			
			DAO dao = DAOFactory.obtain("invoice");
//			log.info("invoice dao: " + dao);

			//DAO dao = (DAO) ctx.getBean("invoiceDAO");
			ValueListHandler handler = new ValueListHandler(dao, 15);  //appconfig
			List invoices = handler.page(Str.toInt(pgPtr));

			request.setAttribute("invoices", invoices);
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