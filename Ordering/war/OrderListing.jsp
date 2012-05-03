<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import="com.starbucks.ordering.services.IOrderService" %>		

<!doctype html>

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Ordering.css">
    <title>Starbucks Ordering</title>
  </head>

  <body>

    
    <center>
        <img src="images/logo.png">
        <h1>Starbucks Orders</h1>
    </center>

	<div id="orders">
	
	<%
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml",});
		IOrderService service = (IOrderService) context.getBean("orderService");
		out.println(service.getAllOrders());
			
	%>
	
	<input type="button" value="Fill Order">
	
	</div>
	
  
  </body>
</html>
