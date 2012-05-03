<form action="AddProductSubmit.do">
<br>

<table cellpadding=0 cellspacing=0 border=0 width="100%">
<tr>
	<td width="40%">
		<div valign=center>
		<font size=+1>
		Add Product
		</font>
		</div>
	</td>
	<td>
		<!-- <div align=right>
		<input type="button" class="submit2" value="Add Invoice">
		<input type="button" class="submit2" value="Delete Invoice">
		</div> -->
	</td>
</tr>
</table>

<table cellpadding=0 cellspacing=0 width=80% align=center border=0>
<tr>
	<td width=30%>Product Category:</td>
	<td><select name="productCategory"><option>General</option></select></td>
</tr>
<tr>
	<td>Product Code:</td>
	<td><input type="text" name="productID"></td>
</tr>
<tr>
	<td>Parent Product Code:</td>
	<td><input type="text" name="parentProductID"> <input type="submit" class="submit3" value="View Hierarchy"></td>
</tr>
<tr>
	<td>Product Type:</td>
	<td><select name="productType"><option>Service</option><option>Good</option></select></td>
</tr>
<tr>
	<td>Description:</td>
	<td><input type="text" name="description"></td>
</tr>
<tr>
	<td>Price:</td>
	<td><input type="text" name="price"></td>
</tr>
<tr>
	<td>Taxable:</td>
	<td><input type="checkbox" name="taxable"></td>
</tr>
<tr>
	<td>Notes:</td>
	<td><textarea name="notes" rows="5" cols="25"></textarea></td>
</tr>
<tr>
	<td></td>
	<td> <br><Br><input type="submit" class="submit2" value="Save Product"></td>
</tr>
</table>
</form>