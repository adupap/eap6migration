package com.jboss.examples.ejb3.gui;

import com.jboss.examples.ejb.*;

public class BackingBean 
{
	
	private String name = "JBoss";
	private String host = "";
	private String response = "";
	private Boolean useTransferObject = false;
	private Boolean useEjb3 = true;

	public BackingBean() 
	{
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getHost() 
	{
		if(host.length() == 0)
			return "localhost";
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public Boolean getUseTransferObject()
	{
		return useTransferObject;
	}
	public void setUseTransferObject ( Boolean useTransferObject )
	{
		this.useTransferObject = useTransferObject;
	}

	public Boolean getUseEjb3()
	{
		return useEjb3;
	}
	public void setUseEjb3 ( Boolean useEjb3 )
	{
		this.useEjb3 = useEjb3;
	}

	public String getResponse() 
	{
		return response;
	}
	// for the jstl page
	public String hello(String name) throws Exception 
	{
		this.name = name;
		return hello();
	}

	// looks up in JNDI on given host and calls hello with name
	public String hello() throws Exception 
	{
		System.out.println ( "Calling Remote interface - host: " + host + " useTransferObject: " + useTransferObject );	
		Object param = name;
		if ( useTransferObject )
		{
			response = new HelloUtil().getEjb2Bean(host).hello( new TransferParameter(name) ).getValue();
		}
		else
		{
			response = new HelloUtil().getEjb2Bean(host).hello(name);	
		}

		//if ( useEjb3 )
			//response = new HelloUtil().getBean(host).hello(name);	
		//else
		//	response = new HelloUtil().getEjb2Bean(host).hello(param);	
		return "";
	}

	public String helloLocal() throws Exception 
	{
		System.out.println ( "Calling Local interface - useTransferObject: " + useTransferObject );	
		Object param = name;
		if ( useTransferObject )
			param = new TransferParameter ( name );

			// TODO add local interface

			response = new HelloUtil().getLocalBean(host).hello(name);	
		return "";
	}


}
