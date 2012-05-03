<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.math.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="com.csr.billing.dto.*" %>

<style>
.noteMacro { border-style: solid; border-width: 1px; border-color: #F0C000; background-color: #FFFFCE; text-align:left;}
.warningMacro { border-style: solid; border-width: 1px; border-color: #c00; background-color: #fcc; text-align:left; }
.infoMacro { border-style: solid; border-width: 1px; border-color: #3c78b5; background-color: #D8E4F1; text-align:left;}
.tipMacro { border-style: solid; border-width: 1px; border-color: #090; background-color: #dfd; text-align:left;}
.informationMacroPadding { padding: 5px 0 0 5px; }
</style>

<style>
.log {
	padding-left: 25px;
	padding-top:10px;
}

h2 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 22px;
	color: #444;
	background: none;
	font-weight: normal;
	padding-left: 40px;
	padding-bottom: 10px;
	border: none;
background-image: url(images/view.png);
	background-repeat: no-repeat;

/*border-bottom: 1px dotted #ccc;*/
}
h3 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	color: #444;
	background: none;
	font-weight: normal;
	padding-bottom: 0px;
	border: none;
		padding-left: 20px;

	border-bottom: 1px dotted #ccc;
/*background-image: url(images/arrow_opening_active_16.gif);*/
background-image: url(images/arrowdown.gif);
	background-repeat: no-repeat;
	
}
h4 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	color: #444;
	background: none;
	font-weight: normal;
	padding-bottom: 0px;
	border: none;
		padding-left: 20px;

	border-bottom: 1px dotted #ccc;
/*background-image: url(images/arrow_closing_active_16.gif);*/
background-image: url(images/arrowright.gif);
	background-repeat: no-repeat;
	
}
</style>

<%
			Invoice invoice = (Invoice) request.getAttribute("invoice");
			if (invoice==null)
				invoice = new Invoice();

			invoice.name = "Tricia Craig";
			invoice.addr1 = "401 Derby Ct";
			invoice.city = "Oswego";
			invoice.state = "IL";
			invoice.postalCode = "60543";

%>

<form action="/billing/ViewInvoice.do">

<!-- page title -->
<h2>
	View Invoice &nbsp;(#<%=invoice.invoiceNumber%>)
</h2>

<table cellpadding=0 cellspacing=1 border=0 width="100%">
	<td align=right width=100>
	<font color="#999999">
	<b>
	Location: <br>
	Recently Viewed:
	</b>
	</font>
	</td>
	<td>
	<a href="Billing.do">Billing</a> &gt;
	<a href="ListInvoices.do">List Invoices</a> &gt;
	View Invoice #<%=invoice.invoiceNumber%>
	<br>
	<a href="/biz/ViewInvoice.do?invoiceNumber=1526">1605 - Scrabble Word Testers</a>
	</td>
	<td align=right>
<!-- 		<a href="http://localhost:8080/biz/ListInvoices.do"><img src="images/wi0062-24.gif" alt="Add Invoice"></a>
		<a href="http://localhost:8080/biz/ListInvoices.do"><img src="images/delete.gif" alt="Delete Invoice"></a>
		<a href="http://localhost:8080/biz/ListInvoices.do"><img src="images/wi0009-24.gif" alt="Search"></a>
		<a href="http://localhost:8080/biz/ListInvoices.do"><img src="images/mail.png" alt="Mail"></a>
		<a href="http://localhost:8080/biz/ListInvoices.do"><img src="images/refresh.gif" alt="Refresh"></a>

		system security, access rights and menuing based on rights  as a seperate aspect that is totally transparent. 

 -->	</td>
	</tr>
</table>

<br>
<div class="information-block" align='center'>
<div class='informationMacroPadding'>
<table cellpadding='5' width='98%' cellspacing='0' class='noteMacro' border='0'><tr><td width='16' valign='top'><img src="images/warning.gif" width="16" height="16" align="absmiddle" alt="" border="0"></td><td><fongt size="+1">Caution <b><a href="/biz/ViewInvoice.do?invoiceNumber=1525">Invoice #1525</a></b> is past due 93 days. The account will soon be suspended.</td></tr></table>
</div></div>

<br>

<TABLE width="100%" align=center border=0 cellspacing=0 cellpadding=0  style="border: 1px solid #aaaaaa">

<TR bgcolor="#339966">
	<TD width="50%"><b><font color=white>Invoice</b></TD>
	<TD align=right><b><font color=white>#<%=invoice.invoiceNumber%></b></TD>
</TR>

<!-- <TR bgcolor="#eeFFee">
 --><TR bgcolor="#ddeedd">
	<TD width="50%">
		<blockquote>
		<br>Bill To:<br>
		<a href=""><%=invoice.name%></a><br>
		<%=invoice.addr1%><br>
		<%=invoice.city%>, <%=invoice.state%> <%=invoice.postalCode%><br>
		</blockquote>
	</TD>
	<TD>

		<table width="100%" align=center border=0 cellspacing=0 cellpadding=0 >
		<tr>
			<td width=35%><div align=right>Invoice #:</td>
			<td width=5%></td>
			<td><%=invoice.invoiceNumber%></td>
		</tr>
		<tr>
			<td><div align=right>Account #:</td>
			<td width=5%></td>
			<td><a href="ViewAccount.do">54540-5435</a></td>
		</tr>
		<tr>
			<td><div align=right>Invoice Date:</td>
			<td width=5%></td>
			<td><%=invoice.invoiceDate%></td>
		</tr>
		<tr>
			<td><div align=right>Payment Due Date:</td>
			<td width=5%></td>
			<td><%=invoice.invoiceDate%></td>
		</tr>
		<tr>
			<td><div align=right>Terms:</td>
			<td width=5%></td>
			<td><%=invoice.terms%></td>
		</tr>
		</table>

	</TD>
</TR>

<TR bgcolor="#ddeedd" >
	<TD colspan=2>

		&nbsp;&nbsp;&nbsp;Purchase/Work Order#: 525<br>
		&nbsp;&nbsp;&nbsp;Purpose: <%=invoice.purpose%>
		<display:table name="invoice.lineItems" style="width:100%">
			<display:column title=" " 						property="lineItemNumber" />
			<display:column title="Product"			property="productID" />
			<display:column title="Description"	property="description" />
			<display:column title="Units"				property="units" />
			<display:column title="Price"				property="price"  />
			<display:column title="Total"				property="total"  />
		</display:table>

	</TD>
</TR>


<%

	BigDecimal gtotal = new BigDecimal("0");
	List a = invoice.getLineItems();
	String sm = "";

	for (int i=0; i<a.size(); i++)
	{
		InvoiceLineItem lineItem = (InvoiceLineItem) a.get(i);

		BigDecimal bdPrice = new BigDecimal( lineItem.units );
		BigDecimal bdUnits = new BigDecimal( lineItem.price );

		bdPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		bdUnits.setScale(2, BigDecimal.ROUND_HALF_UP);

		BigDecimal total = bdPrice.multiply(bdUnits);
		gtotal = gtotal.add(total);

		NumberFormat n2 = NumberFormat.getCurrencyInstance(Locale.US); 
		double doublePayment2 = gtotal.doubleValue();
		sm = n2.format(doublePayment2);
	}

%>


<TR bgcolor="#ddeedd">
	<TD><br>&nbsp;&nbsp;&nbsp;Notes (non-printed): 
	
<!-- 	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br>
	.. <br> -->
	
	</TD>
	<TD>
	
		<table cellpadding=0 cellspacing=0 border=0 width=100%>
		<tr>
			<td width=60%><div align=right><b>Subtotal:</b></div></td>
			<td width=25%><div align=right><%=sm%></div></td>
			<td width=5%>&nbsp;</td>
		</tr>
		<tr>
			<td width=60%><div align=right><b>Shipping/Handling:</b></div></td>
			<td width=25%><div align=right>N/A</div></td>
			<td width=5%>&nbsp;</td>
		</tr>
		<tr>
			<td width=60%><div align=right><b>Tax:</b></div></td>
			<td width=25%><div align=right>$0.00</div></td>
			<td width=5%>&nbsp;</td>
		</tr>
		<tr>
			<td width=60%><div align=right><b>Balance Due:</b></div></td>
			<td width=25%><div align=right><%=sm%></div></td>
			<td width=5%>&nbsp;</td>
		</tr>
		</table>
	
	</TD>
</TR>


<!-- <TR bgcolor="#eeFFee">
	<td colspan=2>
	<br><br>
	<center>
	If you have any questions concerning this invoice, please contact us at: 630-551-5172<br>
	Make all checks payable to CSR Development, Inc.<br>
	<i>Thank you for your business!</i><br>
	</center>
	</td>
</TR>
 -->
<TR bgcolor="#ddeedd">
	<td colspan=2>
		<br>
	</td>
</TR>

<tr>
	<TD colspan=2  bgcolor=#339966>
	<font color=white>
	
		
		
	</font></TD>
</TR>

</table>

<!-- 		<div align=right>
		<input type="button" class="submit2" value="Add Invoice">
		<input type="button" class="submit2" value="Delete Invoice">
		</div>
 -->
</form>

<br><br>

<table>
<tr>
<td valig=top>

						<h3>Audit Log</h3>

						<table border=0>
						<tr>
						<td valign=top>
						<div class="log">
						<img src="images/bullet_done.gif"> Created by <img align=middle src="images/user_12.gif" width="12" height="12" border="0" alt=""><a href="">gcraig</a><br>
						<img src="images/bullet_done.gif"> Updated by <img align=middle src="images/user_12.gif" width="12" height="12" border="0" alt=""><a href="">jthompson</a> <a href="">[view changes]</a><br>
						<img src="images/bullet_done.gif"> Approved by <img align=middle src="images/user_12.gif" width="12" height="12" border="0" alt=""><a href="">cboss</a> <a href="">[view changes]</a><br>
						<img src="images/bullet_done.gif"> Sent by <a href="">system</a><br>
						&nbsp;&nbsp;&nbsp;&nbsp;<a href="">[more]</a>
						</div>
						</td>
						<td valign=top align=left>
						<div class="log">
						(22-July-2006)<br>
						(22-July-2006)<br>
						(02-Aug-2006)<br>
						(02-Aug-2006)<br>
						</div>
						</td>
						</tr>
						</table>

</td>
<td valign=top>
&nbsp;&nbsp;
</td>
<td valign=top>

						<h3>Comments</h3>

						<div class="log">
						&nbsp;&nbsp;<a href=""><img align=middle src="images/notep_16.gif"> Add a comment</a> (optional)
						</div>

</td>
</tr>
</table>

<br>

<h4>Audit Log</h4>

<br>

<h4>Comments</h4>

<br><br>

<!--

		<br>
			<blockquote>
			CSR Development, Inc.<br>
			401 Derby Ct<br>Oswego, Illinois  60543<br>800-146-4750
		</blockquote>

-->