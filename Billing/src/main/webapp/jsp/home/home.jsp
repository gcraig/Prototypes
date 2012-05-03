<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/taglib61.tld" prefix="cal" %> 

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
</style> 

<!-- page title -->
<h1>
	Home
</h1>

<!-- breadcrumbs -->
<font color="#999999">
<b>Location: <a href="Home.do">Home</a></b>
</font>

<br>
<br>

<table cellpadding=0 cellspacing=0 border=0 width="98%">
	<tr>
		<td>
			<ul id="tablist">
			<li><a href="Events.do">Events</a></li><li><a href="ToDoList.do">To Do List</a></li><li><a href="Notes.do">Notes</a></li><li><a href="UserPreferences.do">User Preferences</a></li>
			</ul>
		</td>
	</tr>

	<tr>
		<td style="border-top: 1px gray solid; border-left: 1px gray solid; border-right: 1px gray solid;">
			&nbsp;
		</td>
	</tr>
	

	<tr>
		<td align=center valign=top style="border-left: 1px gray solid;border-right: 1px gray solid;">
			

			<table border=0 cellpadding=0 cellspacing=0 width=90%>
				<tr>
					<td valign=top>
						<cal:Calendar month="8" header="true"> 
						   <cal:setTitleStyle>font-size:10pt; color:#FF0000;background: #fb0;</cal:setTitleStyle> 
						   <cal:setHeaderStyle>color: white; background:#339966; text-decoration:none; </cal:setHeaderStyle> 
						   <cal:setLink day="5">http://www.servletsuite.com</cal:setLink> 
						   <cal:setLink day="15">http://www.servletsuite.com/jsp.htm?$d</cal:setLink> 
						   <cal:setDateClass >test1</cal:setDateClass> 
						   <cal:setDateClass day="15">test2</cal:setDateClass> 
						   <cal:setTarget>_blank</cal:setTarget> 
						   <cal:setNextMonth>Home.do</cal:setNextMonth> 
						   <cal:setPrevMonth>Home.do</cal:setPrevMonth> 
						</cal:Calendar> 	
						<br>
					</td>
					<td valign=top>
						<table width="90%" align="center" id="row">
						<thead>
						<tr>
						<th>Date</th>
						<th>Event</th>
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
						<tr class="odd">
						<td>2005-08-15 7:00am</td>
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
					<td valign=top>
						<cal:Calendar month="9" header="true"> 
						   <cal:setTitleStyle>font-size:10pt; color:#FF0000;background: #fb0;</cal:setTitleStyle> 
						   <cal:setHeaderStyle>color: white; background:#339966; text-decoration:none; </cal:setHeaderStyle> 
						   <cal:setLink day="5">http://www.servletsuite.com</cal:setLink> 
						   <cal:setLink day="15">http://www.servletsuite.com/jsp.htm?$d</cal:setLink> 
						   <cal:setDateClass >test1</cal:setDateClass> 
						   <cal:setDateClass day="15">test2</cal:setDateClass> 
						   <cal:setTarget>_blank</cal:setTarget> 
						   <cal:setNextMonth>Home.do</cal:setNextMonth> 
						   <cal:setPrevMonth>Home.do</cal:setPrevMonth> 
						</cal:Calendar> 				
					</td>
					<td valign=top>
						<table width="90%" align="center" id="row">
						<thead>
						<tr>
						<th>Date</th>
						<th>Event</th>
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
			</table>

		</td>
		
	</tr>

	<tr>
		<td align=center valign=top style="border-left: 1px gray solid; border-bottom: 1px gray solid; border-right: 1px gray solid;">
				<br>
				<input type="button" class="submit3" value="Add Event">
				<input type="button" class="submit3" value="Delete Client">
				<br><br>
		</td>

	</tr>

</table>
