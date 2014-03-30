package com.jboss.examples.ejb;

import com.jboss.examples.ejb2.*;
import com.jboss.examples.ejb.*;

import javax.naming.*;
import java.util.*;

import javax.ejb.*;
import javax.rmi.*;
import java.lang.reflect.Method;

public class HelloUtil 
{

	public HelloUtil() 
	{
	}

	public Context getInitialContext( String host ) throws Exception
	{
		if ( host == null )
		{
			return new InitialContext();
		}
		else
		{
			// ------ This code sets up to call JNDI on a different server --------
		//	Properties properties = new Properties();
   // 	properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
   // 	properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
	//		//properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
   // 	properties.put("jnp.socket.Factory", "org.jnp.interfaces.TimedSocketFactory");
	//		properties.setProperty("java.naming.provider.url", "remote://"+ host +":1099");

			// ------- This is all the code required to get the EJB Remote interface from JNDI ------
			// ------- If you want to use the JNDI on localhost, you can just do new InitialContext() --

		//	return new InitialContext(properties);
			return new InitialContext();
		}
	}



	public ExampleRemote getEjb2Bean ( String host )
	{
		ExampleRemote bean = null;
		try {
			Context context = getInitialContext( host );

			//String jndi = "Example";
			
			//String jndi= "java:global/helloWorld/helloWorld-ejb/Example!com.jboss.examples.ejb2.ExampleHomeRemote";
			String jndi= "java:app/helloWorld-ejb/Example!com.jboss.examples.ejb2.ExampleHomeRemote";
			
			
    //  Object reference = context.lookup(jndi);

      // one way
/*
*/
      
      /*
      EJBHome home = (EJBHome) PortableRemoteObject.narrow(reference, EJBHome.class);
      Class aclass[] = new Class[0];
      Method method = home.getClass().getMethod ( "create", aclass );
      bean = (ExampleRemote)method.invoke(home, new Object[0]);
      */


      // bad way
      ExampleHomeRemote home = (ExampleHomeRemote) context.lookup(jndi);
      bean = (ExampleRemote) home.create();



    } catch(Exception e) {
      e.printStackTrace();
    }
		return bean;
	}

/*
	public Hello getBean(String host) throws Exception 
	{
		// ------ This code sets up to call JNDI on a different server --------
		Properties properties = new Properties();
    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		//properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
    properties.put("jnp.socket.Factory", "org.jnp.interfaces.TimedSocketFactory");
		properties.setProperty("java.naming.provider.url", "jnp://"+ host +":1099");

		// ------- This is all the code required to get the EJB Remote interface from JNDI ------
		// ------- If you want to use the JNDI on localhost, you can just do new InitialContext() --

		Context context = new InitialContext(properties);

		String providerJndi = "helloWorld/HelloBean/remote";
		return (Hello) context.lookup(providerJndi);
	}

	public HelloLocal getLocalBean(String host) throws Exception 
	{
		// ------ This code sets up to call JNDI on a different server --------
		Properties properties = new Properties();
    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		//properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
    properties.put("jnp.socket.Factory", "org.jnp.interfaces.TimedSocketFactory");
		properties.setProperty("java.naming.provider.url", "jnp://"+ host +":1099");

		// ------- This is all the code required to get the EJB Remote interface from JNDI ------
		// ------- If you want to use the JNDI on localhost, you can just do new InitialContext() --

		Context context = new InitialContext(properties);

		String providerJndi = "helloWorld/HelloBean/local";
		return (HelloLocal) context.lookup(providerJndi);
	}
	*/




}
