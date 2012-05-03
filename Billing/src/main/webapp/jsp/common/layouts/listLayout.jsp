<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/paginator.tld" prefix="pager" %>
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %> 
<%@ page errorPage="/common/error.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title><template:get name='title'/></title>
		<link rel="stylesheet" href="screen.css" type="text/css" media="screen, print" />
<!-- 	<LINK href="common.css" rel="stylesheet" type="text/css">
	<LINK href="ddmenu.css" rel="stylesheet" type="text/css">
 -->
<SCRIPT type="text/javascript" src="EventList.js"></SCRIPT>
	<script type="text/javascript" src="writeSelect.js"></script>
	<script type="text/javascript" src="select.js"></script>
	<script type="text/javascript" src="fade.js"></script>
	<script language="JavaScript" type="text/JavaScript" src="common.js"></script>
	<script language="JavaScript" type="text/JavaScript" src="popup.js"></script>
	<script type="text/javascript" src="en.js"></script>
	<script type="text/javascript" src="fckeditor.js"></script>

		<SCRIPT language="JavaScript">
		<!--
		if (document.images)
		{
		  pic1= new Image(10,16); 
		  pic1.src="http://localhost:7001/billing/images/left-tab-hover.gif"; 
		  pic2= new Image(10,16); 
		  pic2.src="http://localhost:7001/billing/images/right-tab-hover.gif"; 
		  pic3= new Image(10,16); 
		  pic3.src="http://localhost:7001/billing/images/left-tab.gif"; 
		  pic4= new Image(10,16); 
		  pic4.src="http://localhost:7001/billing/images/right-tab.gif"; 
		  pic5= new Image(10,10); 
		  pic5.src="http://localhost:7001/billing/images/icon_r_arrow.gif"; 
		}
		//-->
		</SCRIPT>
	</head> 

<body bgcolor="#ffffff" leftmargin="0" topmargin="0"> 

<table width="98%" border="0" cellspacing="0" cellpadding="0" align=center>

   <tr valign='top' bgcolor="#ffffff">
	<td colspan="3" style="border-bottom: 1px solid navy">
		<template:get name='header' ignore='true' />
	</td>
   </tr>

   <tr valign="top"  bgcolor="#FFFFCC">

	<td width="17%" valign="top" style="border-left: 1px solid navy">
		<template:get name='menu'  ignore="true"/>
	</td> 

    <td width="66%" bgcolor="#FFFFCC" valign="top" align="left" valign=top>

		<template:get name='menutab'/>
		<br>
		

<form name="frmList" method="post" action="#" onSubmit="return ValidateForm(this,'cb')">

<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td width="40%">
		<font size=+1>
		List ${Object} 
		</font>
	</td>
	<td align=right>
		<input type="button" class="submit2" value="Add ${Object}">
		<input type="button" class="submit2" value="Delete ${Object}">
	</td>
</tr>
</table>

<hr>

<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td align=right valign=top>

			<table cellpadding=0 cellspacing=0 border=0 width=100%>
			<tr>
				<td>
					<input type="button" value="Select All" class="submit3" onClick="javascript:SetChecked(1,'cb')">
					<input type="button" value="Clear All" class="submit3" onClick="javascript:SetChecked(0,'cb')">
				</td>
				<td align=right>
						<pager:pageNumber href="List${Object}.do" />  <!-- key='' to preserve separate session instances -->
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
						<pager:prevButton href="List${Object}.do" />
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60">
						<pager:nextButton href="List${Object}.do" />
				</td>
			</tr>
			</table>

	</td>
</tr>

<tr>
	<td>

		<template:get name='tableName'/>

	</td>
</tr>
</table>

<hr>
	<div align=right>
		<pager:recordCount />
	</div>

</form>


		<br>
		<template:get name='pageFooter'/>

	</td> 

	<td width="17%" valign="top"  style="border-right: 1px solid navy">
		<template:get name='info'/>
	</td> 

   </tr> 

   <tr valign='top' bgcolor="#ffffff">
	<td colspan="3" style="border-top: 1px solid navy">
		<template:get name='footer'/>
	</td>
   </tr>

</table> 

</body>
</html>