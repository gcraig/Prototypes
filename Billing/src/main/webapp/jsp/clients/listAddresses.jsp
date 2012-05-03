<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/tld/paginator.tld" prefix="pager" %>

<form name="frmListAddresses" method="post" action="#" onSubmit="return ValidateForm(this,'cb')">

<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td width="40%">
		<font size=+1>
		List Addresses 
		</font>
	</td>
	<td align=right>
		<input type="button" class="submit3" value="Add Address">
		<input type="button" class="submit3" value="Delete Address">
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
						<pager:pageNumber href="ListAddresses.do" />  <!-- key='' to preserve separate session instances -->
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
						<pager:prevButton href="ListAddresses.do" />
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60">
						<pager:nextButton href="ListAddresses.do" />
				</td>
			</tr>
			</table>

	</td>
</tr>

<tr>
	<td>
		<!-- template:get name='table' -->

		<display:table name="records" export="false" id="testit"  sort="page" requestURI="ListAddresses.do" width="100%" align="center">
			<display:column width="4%" title="#" property="rownumber" sortable="true" align="center"/>
			<display:column width="6%" title="Select" media="html"><center><input type="checkbox" name="cb" value="" /></center></display:column>
			<display:column width="30%" title="Address" property="address1" sortable="true"  href="ViewAddress.do" paramProperty="addressID" paramId="id"/>
			<display:column width="10%" title="ID" property="addressID" sortable="true"  align="center"/>
			<display:column width="20%" title="City" property="city" sortable="true" />
			<display:column width="10%" title="State" property="state" sortable="true" />
			<display:column width="10%" title="Postal Code" property="postalCode" sortable="true" />
			<display:column width="10%" title="Country" property="country" sortable="true" />
			<display:setProperty name="basic.msg.empty_list" value="No addresses found." />
		</display:table>

	</td>
</tr>
</table>

<hr>
	<div align=right>
		<pager:recordCount />
	</div>


</form>