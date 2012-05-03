<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>

<%@ page import="com.csr.clients.dto.Client" %>
<%@ page import="com.csr.common.dao.*" %>
<%@ page import="com.thoughtworks.xstream.XStream" %>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
</head>
<body>

<h1>XStream Example</h1>

<%
	DAO dao = DAOFactory.obtain("client");
	List clients = dao.search("1", 20);
	XStream xstream = new XStream();
	xstream.alias("client", Client.class);
	xstream.alias("clients", List.class);
	String xml = xstream.toXML(clients);
%>

<pre>
<%
	out.print(escapHTML(xml));
%>
</pre>

</body>
</html>

<%!
    /**
     * Turns a string into another string with '&lt;', '&gt;' and '&amp;' escaped to show correctly
     * @param html The incoming string
     * @return String The updated string with '&lt;', '&gt;' and '&amp;' escaped to show correctly
     */
    public String escapHTML(String html)
    {
        if((html.indexOf('<') == -1) && 
           (html.indexOf('>') == -1) && 
           (html.indexOf('&') == -1)) {
            return html;
        } 
        
        int len = html.length();
        StringBuffer sb = new StringBuffer(html.length());
        for(int i = 0 ; i < len ; i++) {
            char c = html.charAt(i);
            if('<' == c) {
                sb.append("&lt;");
            } else if('>' == c) {
                sb.append("&gt;");
            } else if('&' == c) {
                sb.append("&amp;");
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
%>