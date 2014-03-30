package com.jboss.examples.ejb2;

import javax.ejb.EJBHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

public interface ExampleHomeRemote extends EJBHome
{
	public static final String COMP_NAME="java:comp/env/ejb/Example";
	public static final String JNDI_NAME="Example";

	public ExampleRemote create() throws CreateException, RemoteException;
}
