package com.jboss.examples.ejb2;

import com.jboss.examples.ejb.*;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

/**
 * This is the Remote interface.
 */
public interface ExampleRemote extends EJBObject
{
	public String hello(String name) throws RemoteException;

	public TransferReturnValue hello(TransferParameter name) throws RemoteException;
}
