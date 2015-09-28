package com.webshop.registration.repository;

import com.webshop.registration.model.OrderShipment;
import com.webshop.registration.model.OrderEntity;

/**
 * OrderDAO class will invoke addOrder method . 
 * <P>
 * <B> Visibility decisions: </B>
 * <P>
 * Unless otherwise noted, attributes are private, and a public getter and
 * setter is provided for each.
 * <P>
 * <B> Design/implementation notes: </B>
 * <P>
 * Document any decisions, assumptions, issues, or other notes regarding the
 * implementation of this class.
 * <P>
 * <P>
 * <B> Revision History: </B>
 * 
 * <PRE>
 * 
 * =============================================================================
 * Prior Date            By                  Version  Project/CSR  Description 
 * ---------- --------------------------   ---------- ------------ ------------ 
 * 18/06/2015         kalyan             N/A          webshop        Created.
 * 
 * =============================================================================
 * 
 * </PRE>
 */

public interface OrderDao {
	 /**
     * This method used to add the order.
     * @param orderShipment 
     */
	public void addOrder(OrderShipment orderShipment);
	
	public void addOrderLines(OrderEntity orderEntity);

}
