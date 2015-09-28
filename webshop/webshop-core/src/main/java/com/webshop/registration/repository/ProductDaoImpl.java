
package com.webshop.registration.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;
/**
 * ProductDAOImpl class invoke ProductDAO and will get the list of product information. 
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

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao 
{
	/**
	 * This method will get the productlist from productEnity class.
	 * @param product 
	 */
	@PersistenceContext
	private EntityManager entitymanager;
	public List<ProductEntity> getProductlist(){
		 TypedQuery<ProductEntity> query=entitymanager.createNamedQuery("ProductEntity.find",ProductEntity.class);
		List<ProductEntity> productlist=query.getResultList();
	  	return productlist;
	
	}
	
}
