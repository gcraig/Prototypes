<%@ taglib uri="/WEB-INF/tld/displaytag-11.tld" prefix="display" %>
		
<display:table name="records" export="false" id="testit"  sort="page" requestURI="ListAddresses.do" width="100%" align="center">
	<display:setProperty name="basic.msg.empty_list" value="No addresses found." />
</display:table>

<!--

	display:column width="10%" title="Select" media="html"><center><input type="checkbox" name="cb" value="" /></center></display:column>
	display:column width="10%" title="ID" property="addressID" sortable="true"  align="center"/>
	display:column width="30%" title="Address" property="address1" sortable="true" />
	display:column width="20%" title="City" property="city" sortable="true" />
	display:column width="10%" title="State" property="state" sortable="true" />
	display:column width="10%" title="Postal Code" property="postalCode" sortable="true" />
	display:column width="10%" title="Country" property="country" sortable="true" />

-->