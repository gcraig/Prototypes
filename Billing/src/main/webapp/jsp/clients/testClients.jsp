<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %><%@ page import="com.csr.clients.view.*" %><%@ page import="com.csr.util.vlh.*" %><%@ page import="java.util.*" %>
<form name="frmClients" method="post" action="#" onSubmit="return ValidateForm(this,'cb')">
<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td width="40%">
		<font size=+1>
		Test Clients 
		</font>
	</td>
	<td align=right>
		<input type="button" class="submit2" value="Add Client">
		<input type="button" class="submit2" value="Delete Client">
	</td>
</tr>
</table>
<hr>
<table cellpadding=0 cellspacing=0 border=0 width="100%">
<%
	ValueListHandler handler = (ValueListHandler) request.getAttribute("handler");
	List clients = (List) request.getAttribute("clients");
	request.setAttribute("clients", clients);
	boolean ellipse = false;
	boolean printed = false;
//if (clients==null || clients.size()==0)
//{
	int total = handler.getTotal();
	int start = handler.getStart();
	int end = handler.getEnd();
	int pgPtr = handler.getPgPtr();
	int pgPtrSize = handler.getPgPtrSize();

//	if (pgPtr < 1)
//		pgPtr = 1;

//	if (pgPtr > pgPtrSize)
//		pgPtr = pgPtrSize;

	int prev = pgPtr - 1;
	int next = pgPtr +1;
%>
<tr>
	<td align=right valign=top>

			<table cellpadding=0 cellspacing=0 border=0 width=100%>
			<tr>
				<td>
					<input type="button" value="Select All" class="submit3" onClick="javascript:SetChecked(1,'cb')">
					<input type="button" value="Clear All" class="submit3" onClick="javascript:SetChecked(0,'cb')">
				</td>
				<td align=right>
					Pages
					[
					<%

						for (int i=0; i<pgPtrSize; i++)
						{
							if (pgPtr == (i+1))
							{
									out.print("&nbsp;" + (i + 1) + "&nbsp;" );

							} else {

									out.print("&nbsp;<a href='TestClients.do?pgPtr=" + (i + 1) + "'>" + (i + 1) + "</a>&nbsp;" );

/*
								if ((i+1)<3)
								{
									out.print("&nbsp;<a href='TestClients.do?pgPtr=" + (i + 1) + "'>" + (i + 1) + "</a>&nbsp;" );
									ellipse = true;
								}

								if (((i+1)>=3) && ellipse && !printed)
								{
									out.print("&nbsp;..&nbsp;" );
									printed = true;
								}

								if ( (pgPtrSize - 3) < (i+1))
									out.print("&nbsp;<a href='TestClients.do?pgPtr=" + (i + 1) + "'>" + (i + 1) + "</a>&nbsp;" );
*/
							}
						}
					%>
					]
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
					<%
						if (!(prev < 1))
						{
					%>
						<input type="button" value="<<" class="submit3" onClick="location.href='TestClients.do?pgPtr=1'">
						<input type="button" value="Prev" class="submit3" onClick="location.href='TestClients.do?pgPtr=<%=prev%>'">
					<%
						}
					%>
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60">
					<%
						if (!(next > pgPtrSize))
						{
					%>
						<input type="button" value="Next" class="submit3" onClick="location.href='TestClients.do?pgPtr=<%=next%>'">
						<input type="button" value=">>" class="submit3" onClick="location.href='TestClients.do?pgPtr=<%=pgPtrSize%>'">
					<%
						}
					%>
				</td>
			</tr>
			</table>


	</td>
</tr>
<%
//}
%>
<tr>
	<td>
		<display:table name="clients" export="false" id="testit"  sort="page" requestURI="TestClients.do" width="100%" align="center">
			<display:column width="4%" title="#" property="rownumber" sortable="true" align="center"/>
			<display:column width="6%" title="Select" media="html"><center><input type="checkbox" name="cb" value="" /></center></display:column>
			<display:column width="60%" title="Name" property="name" sortable="true" href="clientName"/>
			<display:column width="10%" title="Client  ID" property="id" sortable="true" align="center"/>
			<display:column width="10%" title="Credit Limit" property="creditLimit" sortable="true"  align="center"/>
			<display:column width="10%" title="Billable" property="billable" sortable="true"  align="center"/>
			<display:setProperty name="basic.msg.empty_list" value="No clients found." />
		</display:table>
		<hr>
		<div align=right>
			<%=start%> - <%=end%> of <%=total%> records.
		</div>
	</td>
</tr>
</table>
</form>