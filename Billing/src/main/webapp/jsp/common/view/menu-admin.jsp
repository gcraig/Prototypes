<span id="menutitle">
	<h3>Admin Menu</h3>
</span>

<table class="boxtable">
<tr>
	<td class="boxtitle">
		Security
	</td>
</tr>
<tr>
	<td>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">Users</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ViewInvoice.do">Roles</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ViewInvoice.do">Apply Rights</a><br>
	</td>
</tr>
</table>

<table class="boxtable">
<tr>
	<td class="boxtitle">
		Environment
	</td>
</tr>
<tr>
	<td>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">RSS News Feeds</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">View Logfile</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">Themes</a><br>
	</td>
</tr>
</table>

<table class="boxtable">
<tr>
	<td class="boxtitle">
		Setup
	</td>
</tr>
<tr>
	<td>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">Company</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">Batch Invoicing</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">Clients</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ViewInvoice.do">Products</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ViewInvoice.do">Reports (Invoices, etc.)</a><br>
	<!-- if setup, checkmark exists before -->
	</td>
</tr>
</table>

<table class="boxtable">
<tr>
	<td class="boxtitle">
		Scheduled Tasks
	</td>
</tr>
<tr>
	<td>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">List Tasks</a><br>
	<img src="images/icon_r_arrow.gif" border=0> <a href="ListInvoices.do">Add Task</a><br>
	</td>
</tr>
</table>

<%
	//com.csr.common.dao.CommonDAO dao = new com.csr.common.dao.CommonDAO();
	//String ver = dao.mysqlVersion();
	String ver = "4.0";
	javax.servlet.ServletContext sc = getServletContext();
%>
<table class="boxtable">
<tr>
	<td class="boxtitle">
		Version: 1.0
	</td>
</tr>
<tr>
	<td>
		Build #: 1.0.2313<br>
		Build Date: 12/02/2005<br>
		<%=sc.getServerInfo()%><br>
		MySQL: <%=ver%><br> 
		Hibernate: <%=org.hibernate.cfg.Environment.VERSION%><br>
		Spring: <%= new org.springframework.core.SpringVersion().getVersion() %><br>
	</td>
</tr>
</table>