package com.webshop.registration.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.SqlResultSetMapping;
/**
 * ProductCategories class provides all the product category details. 
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
@Table(name="product_categories")
@NamedQueries({
	@NamedQuery(name="ProductCategories.find",query="select p from ProductCategories p"),
	@NamedQuery(name="ProductEntity.findCategoryName", query="select p from ProductCategories p WHERE p.id = :id"),
	@NamedQuery(name="ProductEntity.updateCategory",query="update ProductCategories p set p.name=:name where p.id=:id")
})
@SqlResultSetMapping(name="deleteResult", columns = { @ColumnResult(name = "count")})
@NamedNativeQueries({
	@NamedNativeQuery(
			name    =   "deleteEmployeeById",
			query   =   "DELETE FROM product_categories WHERE id = ?"
			,resultSetMapping = "deleteResult"
			)
})
public class ProductCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="NAME")
	private String name;
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	//@JoinColumn(name = "pcid")
	//private Set<ProductEntity> productEntity;
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
}
