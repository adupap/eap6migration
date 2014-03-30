package com.jboss.examples.ejb3.client;

/**
 * @author bmaxwell
 * Requires >= JBoss 4.2 for annotations
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{ 
			//Hello bean = new HelloUtil().getBean("morpheus");	
			//Hello bean = new HelloUtil().getBean("192.168.0.111");	
			//Hello bean = new HelloUtil().getBean("localhost");	
			//System.out.println("hello('JBoss') = " + bean.hello("JBoss"));
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	}
}
