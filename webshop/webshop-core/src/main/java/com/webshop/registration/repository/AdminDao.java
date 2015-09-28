package com.webshop.registration.repository;

import java.util.List;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;
/**
 * AdminDAO class will call the addCategory deleteCategory and addProduct methods. 
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
 * Prior Date            By              Version  Project/CSR  Description 
 * ---------- --------------------------   ---------- ------------ ------------ 
 * 18/06/2015         kalyan             N/A          webshop        Created.
 * 
 * =============================================================================
 * 
 * </PRE>
 */


public interface AdminDao {
	public List<ProductCategories> getproduct_categorylist();
	 /**
     * This method used to delete the category.
     * @param id 
     */
	boolean deletecategory(Integer id);
	/**
     * This method used to add the category.
     * @param id 
     */
	public void addCategory(ProductCategories productCategory);
	/**
     * This method used to add the product.
     * @param product 
     */
	public void addProduct(ProductEntity product);
	/**
     * This method used to add the productList.
     * @param ProductEntity 
     */
	public List<ProductEntity> getproduct_list();
	/**
     * This method used to add the delete the product.
     * @param id 
     */
	boolean deleteProduct(Integer id);
	/**
     * This method used to update the product categories.
     * @param productCategory 
     */
	boolean updateCategory(ProductCategories productCategory);
	/**
     * This method used to update the product.
     * @param product 
     */
	public boolean updateProduct(ProductEntity product);


}
