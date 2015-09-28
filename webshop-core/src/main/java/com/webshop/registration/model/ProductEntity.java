package com.webshop.registration.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

/**
 * ProductEntity class provides all the product details such as productID and price. 
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
@Table(name="products")
@NamedQueries({
@NamedQuery(name="ProductEntity.find", query="select p from ProductEntity p"),
@NamedQuery(name="ProductEntity.findproductName", query="select p from ProductEntity p WHERE p.id = :id"),
@NamedQuery(name="ProductEntity.updateProduct",query="update ProductEntity p set p.name=:name,p.description=:description,p.price=:price where p.id=:id")
})
@SqlResultSetMapping(name="deleteProductResult", columns = {@ColumnResult(name = "count")})
@NamedNativeQueries({
	@NamedNativeQuery(
			name    =   "deleteProductById",
			query   =   "DELETE FROM products WHERE id = ?"
			,resultSetMapping = "deleteProductResult"
			)
})

public class ProductEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="DESCRIPION")
	private String description;
	@Column(name="NAME")
	private String name;
//	@Column(name="PCID")
	@ManyToOne
	private ProductCategories pcid;
	@Column(name="PRICE")
	private String price;
	//@Column(name="Qty")
	//private String quantity;

	/**
	 * @return the quantity
	 */
	/*public String getQuantity() {
		return quantity;
	}
	*//**
	 * @param quantity the quantity to set
	 *//*
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}*/
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pcid
	 */

	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the pcid
	 */
	public ProductCategories getPcid() {
		return pcid;
	}
	/**
	 * @param pcid the pcid to set
	 */
	public void setPcid(ProductCategories pcid) {
		this.pcid = pcid;
	}
	
		
}