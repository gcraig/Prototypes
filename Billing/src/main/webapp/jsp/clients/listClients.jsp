<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/paginator.tld" prefix="pager" %>
<%@ taglib uri='/WEB-INF/tld/struts-tiles.tld' prefix='tiles' %> 

<form name="frmListClients" method="post" action="#" onSubmit="return ValidateForm(this,'cb')">
<style>

div.exportlinks {
	background-color: #FFFFCE;
	border: 1px dotted #999;
	padding: 2px 8px 2px 4px;
}

span.export {
	padding: 0 0px 5px 20px;
	display:inline; 
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
background-image: url(images/wi0111-32.gif);
	background-repeat: no-repeat;

/*	border-bottom: 1px dotted #ccc;*/
}
</style>


<!-- page title -->
<h2>
	List Clients
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
	<a href="Clients.do">Clients</a> / <a href="ListClients.do">List Clients</a></b><br>
	<a href="/biz/ViewClients.do?invoiceNumber=1526">Karpentry by Kush</a>
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
					Filter:
					<select name="">
						<option>None</option>
						<option>Balance > 1000</option>
						<option>Credit Limit > 1000</option>
					</select>
				</td>
				<td align=right>
						<pager:pageNumber href="ListClients.do" />  <!-- key='' to preserve separate session instances -->
				</td>
				<td width="110" align="right">
					Records:
					<select name="">
					<option>All
					<option>25
					<option>15
					<option>10
					</select>
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60" align="right">
						<pager:prevButton href="ListClients.do" />
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60">
						<pager:nextButton href="ListClients.do" />
				</td>
			</tr>
			</table>

	</td>
</tr>

<tr>
	<td>
		<display:table name="clients" export="true" id="testit"  sort="page" requestURI="ListClients.do" style="width:100%">
			<display:column title="#" property="rownumber" sortable="true"/>
			<display:column title="Select" media="html"><center><input type="checkbox" name="cb" value="" /></center></display:column>
			<display:column title="Name" property="clientName" sortable="true" href="ViewClient.do"  paramId="clientID" paramProperty="clientID" />
			<display:column title="URL">www.myco.com</display:column>
			<display:column title="Email">company@company.com</display:column>
			<display:column title="Address">Chicago, IL</display:column>
			<display:column title="Client ID" property="clientID" sortable="true" href="ViewClient.do" paramId="clientID" paramProperty="clientID" />
			<display:column title="Credit Limit" property="creditLimit" sortable="true" />
			<display:column title="Billable" property="billable" sortable="true"  />
			<display:setProperty name="basic.msg.empty_list" value="No clients found." />
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

<!-- <div align=right>
<input type="button" class="submit3" value="Add Client">
<input type="button" class="submit3" value="Delete Client">
</div>
 -->
 <br><br><br>
</form>