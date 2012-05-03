<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/paginator.tld" prefix="pager" %>
<%@ taglib uri='/WEB-INF/template.tld' prefix='template' %> 

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
					<pager:recordCount />
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

		<template:get name='table' />

	</td>
</tr>
</table>

<hr>
	<div align=right>
		<pager:recordCount />
	</div>

</form>