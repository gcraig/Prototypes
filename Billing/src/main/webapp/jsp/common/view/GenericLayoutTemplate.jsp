<%
/**
  * Title:        CKC Generic ResultList Layout JSP
  * Version:      $Revision:$
  * Copyright:    Copyright © 2003
  * Author:       Gary Dzik
  * Company:      Bank One
  * Description:  CKC Generic ResultList Layout JSP
  * Modifications:
  * $Log:$
 */
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri='/WEB-INF/tld/struts-tiles.tld' prefix='tiles' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <% System.out.println("in template");%>
  <title>Customer Knowledge Center</title>
  <meta http-equiv="Content-Type" Content="text/html; charset=iso-8859-1">
  <meta http-equiv="Pragma" Content="no-cache">
  <meta http-equiv="Expires" Content="0">
  <meta http-equiv="Cache-Control" Content="no cache">
  <link rel="stylesheet" type="text/css" href="/css/greyblue.css">
  <script language="Javascript" type="text/javascript" src="/js/subMenuURL.js"></script>
  <script language="Javascript" type="text/javascript" src="/js/common.js"></script>
  <script language="Javascript" type="text/javascript" src="/js/ckcutil.js"></script>
  <script language="Javascript" type="text/javascript" src="/js/DynamicOptionList.js"></script>
 </head>  
 <body onLoad="loaded();" onbeforeprint="hidePrint();" onafterprint="showPrint();">
<div id="waitbigdiv" style="position:absolute; top:126px;left:326px;visibility:hidden">
  <OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" WIDTH="175" HEIGHT="100" id="pleasewait" ALIGN=""> 
   <PARAM NAME=movie VALUE="/pleasewait.swf"> 
   <PARAM NAME=quality VALUE=high> 
   <PARAM NAME=bgcolor '+' VALUE=#FFFFFF>  
    <EMBED src="pleasewait.swf" quality=high bgcolor=#FFFFFF  WIDTH="175" HEIGHT="100" '+' NAME="/ckc/pleasewait" ALIGN="" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer">
   </EMBED> 
 </OBJECT>
</div>
    <div id="menudiv">
   <tiles:insert attribute="header" />
   <tiles:insert attribute="ckcmenu" />
    </div>
   <tiles:insert attribute="listheader" />
   <tiles:insert attribute="list" />
   <tiles:insert attribute="listfooter" />
   <tiles:insert attribute="footer" />
 </body>
</html>