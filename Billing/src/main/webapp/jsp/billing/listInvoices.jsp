<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/paginator.tld" prefix="pager" %>

<style>

div.exportlinks {
	background-color: #FFFFCE;
	border: 1px dotted #999;
	padding: 2px 8px 2px 4px;
}

span.export {
	padding: 0 0px 5px 20px;
/*	display:inline; */
/*	display:inline-block;*/
	cursor: pointer;
}
/*
span.excel {
	background-image:  url(images/export2/ico_file_excel.png);
	background-repeat: no-repeat;
}
span.csv {
	background-image: url(images/export2/ico_file_csv.png);
	background-repeat: no-repeat;
}
span.xml {
	background-image: url(images/export2/ico_file_xml.png);
	background-repeat: no-repeat;
}
span.pdf {
	background-image: url(images/export2/ico_file_pdf.png);
	background-repeat: no-repeat;
}
*/
span.excel {
	background-image:  url(images/export/excel.gif);
	background-repeat: no-repeat;
}
span.csv {
	background-image: url(images/export/text.gif);
	background-repeat: no-repeat;
}
span.xml {
	background-image: url(images/export/xml.gif);
	background-repeat: no-repeat;
}
span.pdf {
	background-image: url(images/export/pdf.gif);
	background-repeat: no-repeat;
}


#bodyColumn2 {
  margin-right: 1.5em;
  margin-left: 197px;
}


#bodyColumn2 {
	margin-right: 1.5em;
	margin-left: 197px;
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
background-image: url(images/list_pages_32.gif);
	background-repeat: no-repeat;

/*	border-bottom: 1px dotted #ccc;*/
}




</style>

<form name="frmInvoices" method="post" action="#" onSubmit="return ValidateForm(this,'cb')">

<!-- page title -->
<h2>
	List Invoices
</h2>

<table cellpadding=0 cellspacing=1 border=0 width="100%">
	<td align=left width=100>
	<font color="#999999">
	<b>
	Location: <br>
	Recently Viewed:
	</b>
	</font>
	</td>
	<td>
	<b>
	<a href="Billing.do">Billing</a> / <a href="ListInvoices.do">List Invoices</a></b><br>
	<a href="/biz/ViewInvoice.do?invoiceNumber=1526">1605 - Scrabble Word Testers</a>
	</td>
	<td align=right>
		<!-- <img src="images/wi0062-24.gif" border="1">
		<img src="images/wi0009-24.gif" border="1">
		<img src="images/refresh.gif" border="1">
		<img src="images/mail.png" border="1"> -->
	</td>
	</tr>
</table>

<br>
<br>

<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td align=right valign=top>

			<table cellpadding=0 cellspacing=0 border=0 width=100%>
			<tr>
				<td>
					<input type="button" value="Select All" class="submit3" onClick="javascript:SetChecked(1,'cb')">
					<input type="button" value="Clear All" class="submit3" onClick="javascript:SetChecked(0,'cb')">
				</td>
				<td align=right>
						<pager:pageNumber href="ListInvoices.do" />  <!-- key='' to preserve separate session instances -->
				</td>
				<td width="110" align="right">
					Records:
					<select name="">
					<option>All
					<option>25
					<option>	15
					<option>	10
					</select>
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60" align="right">
						<pager:prevButton href="ListInvoices.do" />
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60">
						<pager:nextButton href="ListInvoices.do" />
				</td>
			</tr>
			</table>

	</td>
</tr>

<%

%>

<tr>
	<td>
		<display:table name="invoices" export="true" id="row" sort="page" requestURI="ListInvoices.do" style="width: 100%">
			<display:column title="#" property="rownumber" sortable="true"/>
			<display:column title="Select" media="html"><center><input type="checkbox" name="cb" value="" /></center></display:column>
			<display:column title="Action" media="html"><center><img src="images/add_page_16.gif">&nbsp;<img src="images/del_page_16.gif">&nbsp;<img src="images/flag_16.gif"></center></display:column>
			<display:column title="Invoice" property="invoiceNumber" sortable="true" href="ViewInvoice.do" paramId="invoiceNumber"/>
				
			
			<display:column title="Date" property="invoiceDate" sortable="true"/>
			<display:column title="Client" property="name" sortable="true" />
			<display:column title="Account#" sortable="true"  href="ViewInvoice.do" paramId="invoiceNumber">43254-432</display:column>
			<display:column title="Terms" property="terms" sortable="true"/>
			<display:column title="Amount" property="totalAmount" sortable="true"/>
			<display:column title="Printed" property="datePrinted" sortable="true" />
			<display:setProperty name="export.pdf" value="true" />
			<display:setProperty name="export.pdf.filename" value="export.pdf" />
			<display:setProperty name="export.excel.filename" value="export.xls" />
			<display:setProperty name="export.csv.filename" value="export.csv" />
		</display:table>
	</td>
</tr>
</table>

<hr>
	<div align=right>
		<pager:recordCount />
	</div>
<!--
		<input type="button" class="submit3" value="Add Invoice">
		<input type="button" class="submit3" value="Delete Invoice">
		-->
<br>

<br><br>
</form>