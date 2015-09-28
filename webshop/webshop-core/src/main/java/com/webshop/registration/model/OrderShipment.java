package com.webshop.registration.model;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="orders")
public class OrderShipment {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="User_Id")
	private Integer userid;
	@Column(name="Order_Date")
	private Date orderDate;
	@Column(name="Shipping_Address")
	private String shippingAddress;
	@Column(name="Shipping_City")
	private String shippingCity;
	@Column(name="PIN")
	private String pin;
	@Column(name="STATUS")
	private String status;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "orderid")
	private Set<OrderEntity> orderEntity; 
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
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	/**
	 * @return the shippingCity
	 */
	public String getShippingCity() {
		return shippingCity;
	}
	/**
	 * @param shippingCity the shippingCity to set
	 */
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the orderEntity
	 */
	public Set<OrderEntity> getOrderEntity() {
		return orderEntity;
	}
	/**
	 * @param orderEntity the orderEntity to set
	 */
	public void setOrderEntity(Set<OrderEntity> orderEntity) {
		this.orderEntity = orderEntity;
	}

}
