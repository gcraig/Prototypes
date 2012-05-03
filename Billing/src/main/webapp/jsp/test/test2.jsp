<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.ejb.*" %>
<%@ page import="javax.rmi.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.csr.clients.ejb.*" %>
<%@ page import="com.csr.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<style>


/* Rounded corners */
* html div.modulecontainer{height:auto;}
.modulecontainer{padding:0 8px;}
.modulecontainer div{border-style:solid;border-width:1px;margin:-2px -8px;height:1em;}
html>body .modulecontainer div{height:auto;}
.modulecontainer div div{border-style:none;border-width:0;margin:0;}
.modulecontainer .first, .modulecontainer .last{position:relative;height:8px;margin:0;}			
.modulecontainer .first{border-width:1px 0 0 0;}
.modulecontainer .last{border-width:0 0 1px 0;}
.modulecontainer .first .first, .modulecontainer .first .last{margin-top:-1px;}
.modulecontainer .last .first, .modulecontainer .last .last{margin-bottom:-1px;}
.modulecontainer .first .first, .modulecontainer .first .last, .modulecontainer .last .first, .modulecontainer .last .last{border:0;position:absolute;z-index:1;width:8px;background-repeat:no-repeat;}
.modulecontainer .first .first, .modulecontainer .last .first{margin-left:-8px;}
.modulecontainer .first .last, .modulecontainer .last .last{right:0px;margin-right:-8px;}

/* Rounded corners */
div.content div{border-color:#b2c3cc;background-color:#FFF;}
div.content .first .first{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_c4c3w_nw_1.gif);}
div.content .first .last{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_c4c3w_ne_1.gif);}
div.content .last .first{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_c4c3w_sw_1.gif);}
div.content .last .last{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_c4c3w_se_1.gif);}
div.filled div{border-color:#b2c3cc;background-color:#ecf2f4;}
div.filled .first .first{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_wc3c5_nw_1.gif);}
div.filled .first .last{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_wc3c5_ne_1.gif);}
div.filled .last .first{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_wc3c5_sw_1.gif);}
div.filled .last .last{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/grayorg/rc_wc3c5_se_1.gif);}
div.sidebar div{border-color:#C1C1C1;background-color:#FFF;}
div.sidebar .first .first{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/all/rc_wg2w_nw_1.gif);}
div.sidebar .first .last{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/all/rc_wg2w_ne_1.gif);}
div.sidebar .last .first{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/all/rc_wg2w_sw_1.gif);}
div.sidebar .last .last{background-image:url(http://us.i1.yimg.com/us.yimg.com/i/us/pim/r/medici/all/rc_wg2w_se_1.gif);}
#searchnav li, #optionsnav li{border-color:#FFF;background-color:#FFF;}
#searchnav li.selected, #optionsnav li.selected{border-color:#E4E6E3;background-color:#ecf2f4;}
#searchnav li.hover, #optionsnav li.hover{background-color:#E6E6E6;border-color:#C1C1C1;}
#searchnav li:hover, #optionsnav li:hover{background-color:#E6E6E6;border-color:#C1C1C1;}1;}#optionsnav li:hover{background-color:#E6E6E6;border-color:#C1C1C1;}

</style>
</head>

<body>

<br><br>

<div class="modulecontainer filled nomessages">
<div class="first">
<span class="first"></span>
<span class="last"></span>
</div>
<div>
<div>
<center>
<p>Clients</p></center>
</div>
</div>
<div class="last">
<span class="first"></span>
<span class="last"></span>
</div>
</div>	

<%
/*
		ServiceLocator serviceLocator = ServiceLocator.getInstance();
		ClientEntityHome home = (ClientEntityHome) serviceLocator.getHome("ejb/ClientEntity", ClientEntityHome.class);
		Collection clients = (Collection) home.findAll();

		int ctr = 1;
		for (Iterator i = clients.iterator(); i.hasNext();)
		{
			ClientEntity client = (ClientEntity) i.next();
			out.println(ctr + ". ");
			out.println(	client.getClientID());
			out.println(" - ");
			out.println(	client.getClientNumber());
			out.println(" - ");
			out.println(	client.getClientName());
			out.println("<br>");
			ctr++;
		}
		*/
%>


<div class="modulecontainer filled nomessages">
<div class="first">
<span class="first"></span>
<span class="last"></span>
</div>
<div>
<div>
<center>
<p>Addresses</p></center>
</div>
</div>
<div class="last">
<span class="first"></span>
<span class="last"></span>
</div>
</div>	


<%
/*
		AddressEntityHome home2 = (AddressEntityHome) serviceLocator.getHome("ejb/AddressEntity", AddressEntityHome.class);
		Collection addrs = (Collection) home2.findAll();

		ctr = 1;
		for (Iterator i = addrs.iterator(); i.hasNext();)
		{
			AddressEntity addr = (AddressEntity) i.next();
			out.println(ctr + ". ");
			out.println(	addr.getAddressID());
			out.println(" - ");
			out.println(	addr.getAddress1());
			out.println(" - ");
			out.println(	addr.getCity());
			out.println("<br>");
			ctr++;
		}
*/

		ServiceLocator serviceLocator = ServiceLocator.getInstance();
		ClientEntityHome home = (ClientEntityHome) serviceLocator.getHome("ejb/ClientEntity", ClientEntityHome.class);

		ClientEntity client = home.findByPrimaryKey(new Integer(2));
			out.println(	client.getClientID());
			out.println(" - ");
			out.println(	client.getClientNumber());
			out.println(" - ");
			out.println(	client.getClientName());
			out.println("<br>");


			Set s = new 
			AddressEntity.create
			add to client
			client.add

		Collection addrs = client.getAddresses();
		int ctr = 1;
		for (Iterator i = addrs.iterator(); i.hasNext();)
		{
			AddressEntity addr = (AddressEntity) i.next();
			out.println(ctr + ". ");
			out.println(	addr.getAddressID());
			out.println(" - ");
			out.println(	addr.getAddress1());
			out.println(" - ");
			out.println(	addr.getCity());
			out.println("<br>");
			ctr++;
		}
/*
		 client = home.findByPrimaryKey(new Integer(22));
			out.println(	client.getClientID());
			out.println(" - ");
			out.println(	client.getClientNumber());
			out.println(" - ");
			out.println(	client.getClientName());
			out.println("<br>");

		 client = home.findByPrimaryKey(new Integer(2));
			out.println(	client.getClientID());
			out.println(" - ");
			out.println(	client.getClientNumber());
			out.println(" - ");
			out.println(	client.getClientName());
			out.println("<br>");

		 client = home.findByPrimaryKey(new Integer(4));
			out.println(	client.getClientID());
			out.println(" - ");
			out.println(	client.getClientNumber());
			out.println(" - ");
			out.println(	client.getClientName());
			out.println("<br>");

	*/		

/*
		ClientEntity client = home.findByPrimaryKey(new Integer(12));
			out.println(	client.getClientID());
			out.println(" - ");
			out.println(	client.getClientNumber());
			out.println(" - ");
			out.println(	client.getClientName());
			out.println("<br><br><br>");

		Collection clients = (Collection) client.getByRange( new Integer(10),  new Integer(5) );
		Iterator itr = clients.iterator();
		int ctr = 1;
		while (itr.hasNext())
		{
			ClientEntity client2 = (ClientEntity) itr.next();
			out.println(ctr + ". ");
			out.println(	client2.getClientID());
			out.println(" - ");
			out.println(	client2.getClientNumber());
			out.println(" - ");
			out.println(	client2.getClientName());
			out.println("<br>");
			ctr++;
		}
/*

		out.println(	client.getClientNumber());
		out.println(	client.getClientName());
		ClientEntity client2 = home.create(
				new Integer(401),
				"44444",
				"Pepsi, Co.",
				new Double(2000.00),
				new Boolean(true));
		out.println(	client2.getClientName());
*/
		//InitialContext initialContext = new InitialContext();
		//javax.sql.DataSource ds = (javax.sql.DataSource) initialContext.lookup("java:/MySqlDS");
		//java.sql.Connection conn = ds.getConnection();
/*
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "jnp://192.168.1.100:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming.client");
		props.setProperty("j2ee.clientName", "ClientService");
   		InitialContext jndiContext = new InitialContext( props );
		Object ref  = jndiContext.lookup("ejb/ClientService");
		ClientServiceHome home = (ClientServiceHome) PortableRemoteObject.narrow (ref, ClientServiceHome.class);
		ClientService client = home.create();	
		client.addClient();
*/
//		ServiceLocator serviceLocator = ServiceLocator.getInstance();
//		ClientServiceHome home = (ClientServiceHome) serviceLocator.getHome("ejb/ClientService", ClientServiceHome.class);
//		ClientService client = home.create();	
//		client.addClient();

%>
<br><br>

</body>
</html>