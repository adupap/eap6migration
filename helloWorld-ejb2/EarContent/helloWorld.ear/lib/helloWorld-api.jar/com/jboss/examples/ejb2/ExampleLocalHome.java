package com.jboss.examples.ejb2;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * This is the home interface for the <code></code> bean.
 */
public interface ExampleLocalHome extends EJBLocalHome
{
   /**
    * Creates an EJB object.
    *
    * @return the newly created EJB object.
    */
    ExampleLocal create() throws CreateException;
}
