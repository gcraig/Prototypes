<%@ taglib uri='/WEB-INF/template.tld' prefix='template' %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title><template:get name='title'/></title>
		<link rel="stylesheet" href="screen.css" type="text/css" media="screen, print" />

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
		<template:get name='header'/>
	</td>
   </tr>

   <tr valign="top"  bgcolor="#FFFFCC">

	<td width="17%" valign="top" style="border-left: 1px solid navy">
		<template:get name='menu'/>
	</td> 

    <td width="66%" bgcolor="#FFFFCC" valign="top" align="left" valign=top>

		<template:get name='menutab'/>
		<br>
		<template:get name='content'/>
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