package com.webshop.registration.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.webshop.registration.model.ProductCategories;
/**
 * ProductCategoryDaoImpl invoke ProductCategoryDao class and calls the method getProductCategoriesList. 
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
public class ProductCategoryDaoImpl implements ProductCategoryDao {
 	
	@PersistenceContext
	private EntityManager entitymanager;
	public List<ProductCategories> getProductCategoriesList() {
		TypedQuery<ProductCategories> Query=entitymanager.createNamedQuery("ProductCategories.find",ProductCategories.class);
		List<ProductCategories> productCategorieslist=Query.getResultList();
		return productCategorieslist;
	}

}
