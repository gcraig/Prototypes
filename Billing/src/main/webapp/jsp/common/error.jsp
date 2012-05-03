<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style>
		.noteMacro { border-style: solid; border-width: 1px; border-color: #F0C000; background-color: #FFFFCE; text-align:left;}
		.warningMacro { border-style: solid; border-width: 1px; border-color: #c00; background-color: #fcc; text-align:left; }
		.infoMacro { border-style: solid; border-width: 1px; border-color: #3c78b5; background-color: #D8E4F1; text-align:left;}
		.tipMacro { border-style: solid; border-width: 1px; border-color: #090; background-color: #dfd; text-align:left;}
		.informationMacroPadding { padding: 5px 0 0 5px; }
		</style>
		<title>Error</title>
	</head>

<body>

	<table width="100%" cellpadding=2 cellspacing=0>
		<tr><td>
		<div class="information-block" align='center'>
		<div class='informationMacroPadding'>
		<table cellpadding='5' width='98%' cellspacing='0' class='warningMacro' border='0'><tr><td width='16' valign='top'><img src="images/New Folder/error.gif" width="16" height="16" align="absmiddle" alt="" border="0"></td><td>
		<b><font color=dd3333 size="2">ERROR</font></b>
		<br><%= exception %></td></tr></table>
		</div></div>

		<br><br>

<pre>
<%
//	java.io.StringWriter s = new java.io.StringWriter();
//	exception.printStackTrace(new java.io.PrintWriter(s));
//	out.println(s);
%>
</pre>

		</td></tr>
	</table>

</body>
</html>