package com.jboss.examples.ejb2;

import com.jboss.examples.ejb.*;

import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;

import org.apache.log4j.Logger;

public class ExampleBean implements SessionBean, ExampleInterface
{
	protected SessionContext 	context;
	protected Logger log = Logger.getLogger( this.getClass() );

	public void ejbCreate() throws CreateException 
	{
		log.info("ExampleBean ejbCreate();");
	}

	public void ejbRemove()
	{
		log.info("ExampleBean ejbRemove();");
	}

	public void ejbActivate()
	{
		log.info("ExampleBean ejbActivate();");
	}

	public void ejbPassivate()
	{
		log.info("ExampleBean ejbPassivate();");
	}

	public void setSessionContext(SessionContext context)
	{
		this.context = context;
	}

	public String hello(String name) 
	{
		/*
		try {
			String callingClient = RemoteServer.getClientHost();
			log.info("Calling client: " + callingClient);
		} catch(ServerNotActiveException e) {
			log.info("Exception getting calling client", e);
		}
		*/
		
		log.info("ExampleBean hello("+name+")");
		return "Hello " + name;
	}

	public TransferReturnValue hello(TransferParameter name) 
	{
		log.info("ExampleBean hello( TransferParam: "+name+")");
		return new TransferReturnValue ( hello ( name.getValue() ) );
	}

}
