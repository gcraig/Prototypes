<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<%@ page import="java.util.*" %>
 
<html> 
	<head>
		<title></title>
	</head>
	<body>
	<form action="">
	<h1>Add</h1>
	<table border=0>
	<%
			Map props = (Map) request.getAttribute("props");
			Set s = props.keySet();
			for ( Iterator it = s.iterator(); it.hasNext(); )
			{
				String key = (String) it.next();
				String value = (String) props.get(key);

				//String k = key.charAt(0) + "";
				//String m = k.toUpperCase() + key.substring(1);

				StringBuffer sb = new StringBuffer();

				for (int i=0;i<key.length();i++)
				{
					if (i == 0) 
						sb.append( Character.toUpperCase( key.charAt(i) ) );
					else
					{
						char c = key.charAt(i);
						int y = i-1;
						if (y<0) y = 0;
						char g = key.charAt(y);

						if ( Character.isUpperCase(c) && !Character.isUpperCase(g) ) 
						{
							sb.append(" ");
						}
						sb.append(c);
					}
				}
	%>
			<tr>
			<td><%=sb.toString()%></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><input type="text" name="" value="<%=value%>"></td>
			</tr>
	<%
				//System.out.println("key: " + key);
			}
	%>
	</table>

	<input type="submit" value="Save" class="submit3">
	<input type="submit" value="Save and Add" class="submit3">
	<input type="submit" value="Cancel" class="submit3">
	</form>
	</body>
</html>
