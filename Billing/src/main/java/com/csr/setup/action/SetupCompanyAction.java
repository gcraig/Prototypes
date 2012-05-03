package com.csr.setup.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SetupCompanyAction extends Action 
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
		return mapping.findForward(result);
    }
}