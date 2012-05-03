<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.ejb.*" %>
<%@ page import="javax.rmi.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.csr.clients.ejb.*" %>
<%@ page import="com.csr.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
</head>
<body>

<table>
<tr>
	<td valign=top>
		<h1>Clients</h1>
		<%
				ServiceLocator serviceLocator = ServiceLocator.getInstance();
				ClientEntityHome home = (ClientEntityHome) serviceLocator.getHome("ejb/ClientEntity", ClientEntityHome.class);
				Collection clients = (Collection) home.findAll();
				int ctr = 1;
				for (Iterator i = clients.iterator(); i.hasNext();)
				{
					ClientEntity client = (ClientEntity) i.next();
					out.println(ctr + ". ");
					out.println(	client.getClientID());
					out.println(" - ");
					out.println(	client.getClientNumber());
					out.println(" - ");
					out.println(	client.getClientName());
					out.println("<br>");
					ctr++;
				}
		%>
	</td>
	<td valign=top>
		<h1>Addresses</h1>
		<%
				ClientEntity client = home.findByPrimaryKey(new Integer(0));
				Collection addrs = client.getAddresses();
				ctr = 1;
				for (Iterator i = addrs.iterator(); i.hasNext();)
				{
					AddressEntity addr = (AddressEntity) i.next();
					out.println(ctr + ". ");
					out.println(	addr.getAddressID());
					out.println(" - ");
					out.println(	addr.getAddress1());
					out.println(" - ");
					out.println(	addr.getCity());
					out.println("<br>");
					ctr++;
				}
		%>
	</td>
</tr>
</table>

<br><br>

</body>
</html>