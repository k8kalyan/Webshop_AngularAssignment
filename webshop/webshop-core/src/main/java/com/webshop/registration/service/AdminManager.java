package com.webshop.registration.service;

import java.util.List;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;
/**
 * AdminManager will call the methods addCategory,deleteCategory and addproducts methods. 
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

public interface AdminManager {
	
	public List<ProductCategories> getproduct_categorylist();
	 /**
     * This Method Used to delete the category.
     * @param id 
     */
	boolean deletecategory(Integer id);
	 /**
     * This Method Used to add the category.
     * @param productCategory 
     */
	public void addCategory(ProductCategories productCategory);
	 /**
     * This Method Used to add the product.
     * @param product 
     */
	public void addProduct(ProductEntity product);
	 /**
     * This Method Used to get the productlist.
     * @param ProductEntity 
     */
	public List<ProductEntity> getproduct_list();
	 /**
     * This Method Used to delete the product.
     * @param id 
     */
	boolean deleteProduct(Integer id);
	 /**
     * This Method Used to update the Categories.
     * @param productCategory 
     */
	public boolean updateCategory(ProductCategories productCategory);
	 /**
     * This Method Used to update the product.
     * @param product 
     */
	public boolean updateProduct(ProductEntity product);

}
