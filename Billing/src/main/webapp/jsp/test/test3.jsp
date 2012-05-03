<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.csr.stubs.dao.*" %>
<%@ page import="com.csr.product.dto.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
</head>
<body>

<%
	String dir = "C:/jakarta-tomcat-4.1.31/webapps/biz/WEB-INF/src/";

	CastorUtil castor = new CastorUtil();
	ProductList prodList = (ProductList) castor.fetch(dir + "mapping.xml", dir + "products.xml");
	out.println(prodList);
%>

</body>
</html>