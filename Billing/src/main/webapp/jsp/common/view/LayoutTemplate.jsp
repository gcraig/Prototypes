<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri='/WEB-INF/tld/struts-tiles.tld' prefix='tiles' %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
 <head>
  <title>Billing System</title>
	<link rel="stylesheet" href="/css/screen.css" type="text/css" media="screen, print" />
 </head>  

 <body>
 
 <table>

	<tr><td><tiles:insert attribute="header" /></td></tr>

	<tr><td><tiles:insert attribute="menu" /></td><td><tiles:insert attribute="body" /></td></tr>

	<tr><td><tiles:insert attribute="footer" /></td></tr>

 </table>
   
 </body>

</html>