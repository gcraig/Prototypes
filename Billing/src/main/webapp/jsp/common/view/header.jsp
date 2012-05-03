<!--
<img src="images/csrlogo3.jpg" width="150" height="80" border="0" alt="">
	<ul id="navigation" style="margin: 0; padding: 0">
	<li><a href="Home.do"><span><font size=2>Home</font></span></a></li>
	<li><a href="Billing.do"><span><font size=2>Billing</font></span></a></li>
	<li><a href="Clients.do"><span><font size=2>Clients</font></span></a></li>
	<li><a href="Inventory.do"><span><font size=2>Inventory</font></span></a></li>
	<li><a href="Integration.do"><span><font size=2>Integration</font></span></a></li>	
	<li><a href="Reports.do"><span><font size=2>Reports</font></span></a></li>	
	<li><a href="Admin.do"><span><font size=2>Admin</font></span></a></li>	
	</ul>
-->

<%
	// todo: use /biz/module/command.do and hilite off module
	String re = request.getRequestURL().toString();
	String s = re.substring( re.lastIndexOf('/') + 1, re.lastIndexOf('.') );
	// out.println(s);

	String c1, c2, c3, c4, c5, c6;

	c1 = ("Home".equalsIgnoreCase(s)) ? " id='current'": "";
	c2 = ("Billing".equalsIgnoreCase(s) || "ListInvoices".equalsIgnoreCase(s)) ? " id='current'": "";
	c3 = ("Clients".equalsIgnoreCase(s)) ? " id='current'": "";
	c4 = ("Integration".equalsIgnoreCase(s)) ? " id='current'": "";
	c5 = ("Reports".equalsIgnoreCase(s)) ? " id='current'": "";
	c6 = ("Admin".equalsIgnoreCase(s)) ? " id='current'": "";
%>

<ul id="tablist">
<li <%=c1%>><a href="Home.do">Home</a></li>
<li <%=c2%>><a href="Billing.do">Billing</a></li>
<li <%=c3%>><a href="Clients.do">Clients</a></li>
<li <%=c4%>><a href="Integration.do">Integration</a></li>
<li <%=c5%>><a href="Reports.do">Reports</a></li>
<li <%=c6%>><a href="Admin.do">Admin</a></li>
</ul>

<!-- <li><a href="Inventory.do">Inventory</a></li> -->
<!--
<div style="margin-bottom: 8px"></div>

class="current"
<li><a class="current" href="http://www.google.com" onClick="return handlelink(this)">Google</a></li>
<li><a href="http://www.yahoo.com" onClick="return handlelink(this)">Yahoo</a></li>
<li><a href="http://www.msn.com" onClick="return handlelink(this)">MSN</a></li>
<li><a href="http://www.news.com" onClick="return handlelink(this)">News.com</a></li>
<li><a href="http://www.dynamicdrive.com" onClick="return handlelink(this)">Dynamic Drive</a></li>

<iframe id="tabiframe" src="http://www.google.com" width="98%" height="350px"></iframe>
<form name="tabcontrol" style="margin-top:0">
<input name="tabcheck" type="checkbox" onClick="handleview()"> Open tab links in browser window instead.
</form>
-->