<%@ page import="com.jboss.examples.ejb3.gui.BackingBean" %>
<HTML>
<BODY>
<%!
		String name = "JBoss";
		BackingBean bean = new BackingBean();
    System.out.println( "hello(JBoss) = "+ bean.hello(name)  );
    System.out.println( "hello(JBoss) = "+ bean.getResponse()  );
%>
</BODY>
</HTML>
