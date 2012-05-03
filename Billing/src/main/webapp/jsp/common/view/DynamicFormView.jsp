<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<%@ page import="java.util.*" %>

<html> 
	<head>
		<title>Add</title>
	</head>
	<body>

	<%
		String title = (String) request.getAttribute("title");

//		List order = (List) request.getAttribute("order");
//		Map props = (Map) request.getAttribute("props");


	%>

		<font size=+1>Add <%=title%></font>

		<hr/>

		<html:form action="/AddProductSubmit"> 
		<table>
<%	
			String cla = "even";
			int i = -1;
			for (Object key : order)
			{  
				i++;
				Object value = props.get( key );
				
				if ((i % 2) == 0)
				{
					cla = "even";
				}
				else if ((i % 2) == 1)
				{
					cla = "odd";
				}
%>
				<tr class="<%=cla%>">
				<td><%=key%></td>
				<td>&nbsp;&nbsp;</td>
				<td>
				<input type="text" value="<%=value%>"/>
				</td>
				</tr>
<%
			}
%>
		</table>
		<html:submit/>
		</html:form>

	</body>
</html>
