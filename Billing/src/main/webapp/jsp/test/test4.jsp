<%@ taglib uri="/WEB-INF/displaytag-11.tld" prefix="display" %>

<%@ page import="javax.naming.*" %>
<%@ page import="javax.jms.*" %>

<%@ page import="javax.rmi.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
</head>
<body>

<h1>OpenJMS Send Example</h1>

<%
	Properties env = new Properties();
	env.setProperty("java.naming.provider.url", "tcp://localhost:3035");
	env.setProperty("java.naming.factory.initial", "org.exolab.jms.jndi.InitialContextFactory");
	InitialContext jndi = new InitialContext(env);
	
    String factoryName = "ConnectionFactory";
	String destName = "topic1";
	
	// Look up a JMS topic
	ConnectionFactory factory = (ConnectionFactory) jndi.lookup(factoryName);
	Destination dest = (Destination) jndi.lookup(destName);

	// create the connection
	Connection connection = factory.createConnection();

	// create the session
	Session _session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	// create the sender
	MessageProducer sender = _session.createProducer(dest);

	// start the connection, to enable message sends
	connection.start();

	TextMessage message = _session.createTextMessage();
    message.setText("Hey, there, this is a message");
    sender.send(message);

	connection.close();
%>

<h2>Message ... sent</h2>

</body>
</html>