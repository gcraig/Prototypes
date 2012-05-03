<%@ page language="java"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/struts-nested.tld" prefix="nested" %>
<%@ page import="java.util.*" %>
<%@ page import="com.csr.common.action.*" %>


	<html:errors/>

	<%
	/*
	you can use logic:iterate with indexed, mapped properties in dynaform,
	otherwise, use beanutils to describe dynaform props and iterate through map
	*/
	%>

	<%
		String title = (String) request.getAttribute("title");
		String sub = (String) request.getAttribute("sub");
		Map frmProps = (Map) request.getAttribute("frmProps");
		Map order = (Map) request.getAttribute("order");
	%>

<!-- page title -->
<h1>
	Add <%=title%>
</h1>

<!-- breadcrumbs -->
<font color="#999999">
<b>Location: <a href="Billing.do">Billing</a> / <a href="ListProducts.do">List Products</a></b>
</font>

		<font color=green>
		<br/><br/>
		<b>
		<logic:notEmpty name="messageBean">
			<bean:write name="messageBean" property="message"/>
		</logic:notEmpty>
		</b>
		</font>

		<hr/>

		<html:form action="<%=sub%>"> 
		<table>

			<%
			if (frmProps!=null)
			{
				Iterator it = order.keySet().iterator();
				while(it.hasNext())
				{
					String key = (String) it.next();
					String displayName = (String) order.get(key);
			%>
					<tr>
						<td>
							<%=displayName%>
						</td>
						<td>
							&nbsp;&nbsp;
						</td>
						<td>
							<html:text name="frmProps" property="<%=key%>" />
						</td>
					</tr>
				<%
					}
			}
			%>

		</table>
		<br>
		<input type="submit" value="Save"  class="submit3"/>
		<input type="submit" value="Save / Add Another" class="submit3"/>
		<input type="reset" value="Reset" class="submit3"/>
		<input type="submit" value="Cancel" class="submit3"/>
		</html:form>