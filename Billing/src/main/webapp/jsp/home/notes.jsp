<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/taglib61.tld" prefix="cal" %> 
<%@ page import="com.csr.clients.view.*" %>
<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td width="40%">
		<div valign=center>
		<font size=+1>
		Notes
		</font>
		</div>
	</td>
	<td>

	</td>
</tr>
</table>

<style> 
	.test1
	{ 
		background: #FFee88;
	} 
	.test2
	{ 
		color:white; 
		background: #fb0;
	} 
	table
	{
		margin: 10px
	}
</style> 

<table cellpadding=0 cellspacing=0 border=0 width="95%">
	<tr>
	<td colspan=2>
			<ul id="navigation" style="margin: 0; padding: 0;">
			<li><a href="Events.do"><span><font size=2>Events</font></span></a></li>
			<li><a href="ToDoList.do"><span><font size=2>To Do List</font></span></a></li>
			<li><a href="Notes.do"><span><font size=2>Notes</font></span></a></li>
			<li><a href="UserPreferences.do"><span><font size=2>User Preferences</font></span></a></li>
			</ul>
	</td>
	</tr>

	<tr>
			<td align=center valign=top style=" border-right: 1px gray solid; border-left: 1px gray solid; border-top: 1px gray solid;">
				<table width="90%" align="center" id="row">
				<thead>
				<tr>
				<th>Date</th>
				<th>Note</th>
				</tr>
				</thead>
				<tbody>
				<tr class="odd">
				<td>2005-08-05 7:00am</td>
				<td>Process all incoming results via telephone.</td>
				</tr>
				<tr class="even">
				<td>2005-08-15 3:00am</td>
				<td>System maintenance - Archival and Exception reporting</td>
				</tr>
				</tbody>
				</table>	
			</td>
		</tr>
	<tr>
			<td colspan=2 align=center valign=top style="border-left: 1px gray solid; border-bottom: 1px gray solid; border-right: 1px gray solid;">
				<input type="button" class="submit3" value="Add Note">
				<input type="button" class="submit3" value="Delete Note">
				<br><br>
			</td>
		</tr>

</table>