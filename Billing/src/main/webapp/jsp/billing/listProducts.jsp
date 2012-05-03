<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ taglib uri="/WEB-INF/paginator.tld" prefix="pager" %>

<form name="frmListClients" method="post" action="#" onSubmit="return ValidateForm(this,'cb')">

<!-- page title -->
<h1>
	List Products
</h1>

<!-- breadcrumbs -->
<font color="#999999">
<b>Location: <a href="Billing.do">Billing</a> / <a href="ListProducts.do">List Products</a></b>
</font>

<br>
<br>

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
						<pager:pageNumber href="ListProducts.do" />  <!-- key='' to preserve separate session instances -->
				</td>
				<td width="110" align="right">
					Records:
					<select name="">
					<option>All
					<option>25
					<option>15
					<option>10
					</select>
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60" align="right">
						<pager:prevButton href="ListProducts.do" />
				</td>
				<td width="2">
					&nbsp;
				</td>
				<td width="60">
						<pager:nextButton href="ListProducts.do" />
				</td>
			</tr>
			</table>

	</td>
</tr>

<tr>
	<td>
		<display:table name="products" export="false" id="row" sort="page" requestURI="ListProducts.do" width="100%" align="center">
			<display:column width="4%" title="#" property="rownumber" sortable="true" align="center"/>
			<display:column width="6%" title="Select" media="html"><center><input type="checkbox" name="cb" value="" /></center></display:column>
			<display:column width="60%" title="Description" property="description" sortable="true"  href="ViewProduct.do"  paramId="id" paramProperty="productID"  />
			<display:column title="Product ID" property="productID" sortable="true" align="center"   href="ViewProduct.do"  paramId="id" paramProperty="productID"  />
			<display:column title="Type" property="productType" sortable="true"  align="center" />
			<display:column title="Price" property="price" sortable="true"  align="center" />
			<display:column title="Photo" media="html" align="center">view</display:column>
			<display:setProperty name="basic.msg.empty_list" value="No products found." />
		</display:table>
	</td>
</tr>
</table>

<hr>

	<div align=right>
		<pager:recordCount />
	</div>

</form>

<br>