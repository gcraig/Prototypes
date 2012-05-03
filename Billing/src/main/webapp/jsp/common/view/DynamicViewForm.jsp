<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ page import="java.util.*" %>
<%@ page import="com.csr.common.action.*" %>

<html> 
	<head>
		<title>View</title>
	</head>
	<body>

	<html:errors/>

	<%
	/*
	you can use logic:iterate with indexed, mapped properties in dynaform,
	otherwise, use beanutils to describe dynaform props and iterate through map
	*/
	%>

	<%
		String title = (String) request.getAttribute("title");
		Map frmProps = (Map) request.getAttribute("props");
		Map order = (Map) request.getAttribute("order");
	%>

		<font size=+1>View <%=title%></font>

		<font color=green>
		<br/><br/>
		<b>
		<logic:notEmpty name="messageBean">
			<bean:write name="messageBean" property="message"/>
		</logic:notEmpty>
		</b>
		</font>

		<hr/>

		<table width="80%">
<%	
			if (frmProps!=null)
			{
				int i = -1;
				String cla = "even";

				Iterator it = order.keySet().iterator();
				while(it.hasNext())
				{
					i++;
					if ((i % 2) == 0)
						cla = "even";
					else if ((i % 2) == 1)
						cla = "odd";

					String key = (String) it.next();
					String displayName = (String) order.get(key);
					Object displayValue = frmProps.get( displayName );
%>
					<tr class="<%=cla%>">
						<td align="right" width="25%">
							<%=displayName%>:
						</td>
						<td width="8%">
						</td>
						<td>
							<%=displayValue%>
						</td>
					</tr>
<%
				}
			}
%>
		</table>

	</body>
</html>