<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/paginator.tld" prefix="pager" %>
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='tiles' %> 
<%@ page errorPage="/common/error.jsp" %>

<%
//	String BACKGROUND = "#FFFFCC";
//	String HILITE = "#FFee88";
//	String HEADER = "#339966";

	String BACKGROUND = "#E8E8DB";
	String HILITE = "#DEDED1";
	String HEADER = "#aaaaaa";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title><tiles:get name='title' ignore="true"/></title>
		
		
	<link rel="stylesheet" href="/css/article.css" type="text/css" media="screen" title="Digital Web Magazine Style" />
	<link rel="alternate stylesheet" href="/css/print.css" type="text/css" media="screen" title="Print Preview" />
	<link rel="stylesheet" href="/css/print.css" type="text/css" media="print" />
		<!-- -->
		
		
		
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

		<script language = "Javascript">
		<!-- 
		/**
		 * DHTML check all/clear all links script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
		 */

		var form='frmClients' //Give the form name here

		function SetChecked(val,chkName) {
		dml=document.forms[form];
		len = dml.elements.length;
		var i=0;
		for( i=0 ; i<len ; i++) {
		if (dml.elements[i].name==chkName) {
		dml.elements[i].checked=val;
		}
		}
		}

		function ValidateForm(dml,chkName){
		len = dml.elements.length;
		var i=0;
		for( i=0 ; i<len ; i++) {
		if ((dml.elements[i].name==chkName) && (dml.elements[i].checked==1)) return true
		}
		alert("Please select at least one record to be deleted")
		return false;
		}
		// -->
		</script>


<style type="text/css">

/*Eric Meyer's based CSS tab*/

#tablist{
padding: 3px 0;
margin-left: 0;
margin-bottom: 0;
margin-top: 0.1em;
font: bold 12px Verdana;
}

#tablist li{
list-style: none;
display: inline;
margin: 0;
}

#tablist li a{
text-decoration: none;
padding: 3px 0.5em;
margin-left: 3px;
border: 1px solid #778;
border-bottom: none;
background: #cccccc;
}

#tablist li a:link, #tablist li a:visited{
color: navy;
}

#tablist li a:hover{
color: #000000;
/*background: #C1C1FF;*/
background: #DEDED1;
border-color: #227;
}

#tablist li a.current{
background: lightyellow;
}

</style>

<script type="text/javascript">

/***********************************************
* Tabbed Document Viewer script- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

var selectedtablink=""
var tcischecked=false

function handlelink(aobject){
selectedtablink=aobject.href
tcischecked=(document.tabcontrol && document.tabcontrol.tabcheck.checked)? true : false
if (document.getElementById && !tcischecked){
var tabobj=document.getElementById("tablist")
var tabobjlinks=tabobj.getElementsByTagName("A")
for (i=0; i<tabobjlinks.length; i++)
tabobjlinks[i].className=""
aobject.className="current"
document.getElementById("tabiframe").src=selectedtablink
return false
}
else
return true
}

function handleview(){
tcischecked=document.tabcontrol.tabcheck.checked
if (document.getElementById && tcischecked){
if (selectedtablink!="")
window.location=selectedtablink
}
}

</script>

	</head> 

<body bgcolor="#ffffff" leftmargin="0" topmargin="0"> 
<script type="text/javascript" src="ddmenu.js"></script>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align=center>

   <tr valign='top' bgcolor="#ffffff">
	<td colspan="3" style="border-bottom: 1px solid navy">
		<tiles:get name='header' ignore="true"/>
	</td>
   </tr>

   <tr valign='top' bgcolor="<%=HILITE%>">
	<td colspan="1" style="border-left: 1px solid navy">
		&nbsp;&nbsp;&nbsp;<a href="Billing.do">Billing</a> > <a href="ListInvoices.do">Invoices</a> > <a href="ViewInvoice.do">View Invoices</a>
	</td>
	<td colspan="1"></td>
	<td colspan="1" style="border-right: 1px solid navy" ><div align=right><%=new java.util.Date()%>&nbsp;&nbsp;</div>	</td>
   </tr>

   <tr valign="top"  bgcolor="<%=BACKGROUND%>">

	<td width="17%" valign="top" style="border-left: 1px solid navy">
		<tiles:get name='menu'  ignore="true"/>
	</td> 

	<td width="66%" bgcolor="<%=BACKGROUND%>" valign="top" align="left" valign=top>

		<tiles:get name='menutab'  ignore="true"/>
		<br>
		<tiles:get name='content'  ignore="true"/>
		<br>
		<tiles:get name='pageFooter'  ignore="true"/>

	</td> 

	<td width="17%" valign="top"  style="border-right: 1px solid navy">
		<tiles:get name='info'  ignore="true"/>
	</td> 

   </tr> 

   <tr valign='top' bgcolor="#ffffff">
	<td colspan="3" style="border-top: 1px solid navy">
		<tiles:get name='footer'  ignore="true"/>
	</td>
   </tr>

</table> 

<!--###[popups layers >>]###-->
<div id="popups" style="position:absolute; visibility:hidden; z-index:1000;"></div><!--###[<< popups layers]###-->

</body>
</html>