package com.jboss.examples.ejb2;

import com.jboss.examples.ejb.*;

public interface ExampleInterface 
{
	public String hello(String name);

	public TransferReturnValue hello(TransferParameter name);
}
