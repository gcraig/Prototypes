<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/paginator.tld" prefix="pager" %>
<%@ taglib uri='/WEB-INF/tld/struts-tiles.tld' prefix='tiles' %> 
<%@ page errorPage="/common/error.jsp" %>

<%
//	String BACKGROUND = "#FFFFCC";
//	String HILITE = "#FFee88";
//	String HEADER = "#339966";
// don't do this, just switch style sheets, colors.css
	String BACKGROUND = "white"; // "#6757DD"; // "#ACC6EE"; //"#E8E8DB"; // blue
	String HILITE =  "#EDEEAC"; //"#DEDED1";
	String HEADER = "#aaaaaa";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>

	<head>
		<title>
			<tiles:getAsString name='title' ignore="true"/>
		</title>
		<link rel="stylesheet" href="screen.css" type="text/css" media="screen, print" />
		<link rel="stylesheet" href="meyer.css" type="text/css" media="screen, print" />
		<link rel="stylesheet" href="style2.css" type="text/css" media="screen, print" />

		<script type="text/javascript" src="tabbed.js"></script>
	</head> 

	<body> 

		<table id="3column" width="98%" border="0" cellspacing="0" cellpadding="0" align=center>

		 <tr>
		  <td colspan=3 valign=top align=left>
		  
			<br>
			<!--
			<h1>
				QuickBill 2005
			</h1>
			-->
 		    <!-- header, tabs and logo image -->
			<!-- <img src="images/csrlogo3.jpg" border="0" alt=""> -->
			<tiles:get name='header' ignore="true"/>

		  </td>
		 </tr>
		 
		 <tr bgcolor="<%=HILITE%>">
		  <td colspan=3 valign=top 
			style="border: 1px solid black">
		  
			<!-- search, login status -->
			<table border="0" width="100%" cellpadding="4" cellspacing="0"><tr bgcolor="#9CA527">
				<td width="175"><b>&nbsp;&nbsp;QuickBill 2005</b></td>
				<td align="center"></td>
				<td width="250" align="right"><b>Welcome, George &nbsp;&nbsp;[ <a href="#">Sign Off</a> 
				| <a href="#">Help</a> ]</b>&nbsp;&nbsp;</td>
			</tr></table>				

		  </td>
		 </tr>
		 
		 <tr bgcolor="<%=HILITE%>">
		  <td width="175" rowspan1=4 valign=top align="center"
			style="border-left: 1px solid black">

			<!-- left menu -->
			<tiles:get name='menu' ignore="true"/>

		  </td>

		  <td valign="top">
		  
 		    <!-- page content -->
			<br>
			<br>
			<tiles:get name='content' ignore="true"/>

		  </td>

		  <td width="175" rowspan1=4 valign=top align="center" 
			style="border-right: 1px solid black">

			<!-- right menu -->
			<tiles:get name='info' ignore="true"/>

		  </td>
		 </tr>

		 <tr>
		  <td valign=top colspan=3
			style="border-top: 1px solid black">
		  
			<!-- footer -->
			<tiles:get name='footer' ignore="true"/>

		  </td>
		 </tr>

		</table>

	</body>

</html>