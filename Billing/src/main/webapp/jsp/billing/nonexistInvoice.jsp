<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>

<%
	String invoiceNumber = (String) request.getParameter("invoiceNumber");
%>

<!-- page title -->
<h1>
	View Invoice
</h1>

<!-- breadcrumbs -->
<font color="#999999">
<b>Location: <a href="Billing.do">Billing</a> / <a href="ListInvoices.do">List Invoices</a> / <a href="ViewInvoice.do">View Invoice #</a></b>
</font>

<br>
<br>

<h2>
<%
	if (null==invoiceNumber || invoiceNumber.equals(""))
	{
%>
		<b>Invoice #<%=invoiceNumber%> cannot be blank.</b>
<%
	} else {
%>
		<b>Invoice #<%=invoiceNumber%> does not exist.</b>
<%
	}
%>
</h2>
<br>
<br>