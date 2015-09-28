package com.webshop.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * OrderEntity class provides all the order details such as orderID, quantiy amd price. 
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


@Entity
@Table(name="order_lines")
public class OrderEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="Order_Id")
	private Integer orderid;
	@Column(name="Product_ID")
	private Integer productid;
	@Column(name="Qty")
	private Integer quantity;
	@Column(name="Price")
	private Double price;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the orderid
	 */
	public Integer getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the productid
	 */
	public Integer getProductid() {
		return productid;
	}
	/**
	 * @param productid the productid to set
	 */
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}




}
