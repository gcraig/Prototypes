package com.csr.billing.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.csr.common.dao.DAO;
import com.csr.common.dao.DAOFactory;

import com.csr.billing.dto.Invoice;
import java.util.List;

public class ViewInvoiceAction extends Action
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
			//InvoiceDAO dao = new InvoiceDAO();
			DAO dao = DAOFactory.obtain("invoice");

			String invoiceNumber = request.getParameter("invoiceNumber");
			if (null==invoiceNumber || invoiceNumber.equals(""))
			{
					result = "nonexist";
			}
			else
			{
					// findByID
					Invoice invoice = (Invoice) dao.view(invoiceNumber);
					if (null==invoice.getInvoiceNumber())
					{
						result = "nonexist";
					}
					else
					{
						request.setAttribute("invoice", invoice);
					}
			}

		}
		catch (Exception e)
		{
			result = FAIL;
		}

		return mapping.findForward(result);
    }
}