package com.webshop.registration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.repository.AdminDao;
/**
 * AdminManagerImpl invoke AdminManager class and calls the methods addCategory,deleteCategory and addproduct. 
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


@Service
public class AdminManagerImpl implements AdminManager {
	
	@Autowired
	AdminDao admindao;
	public List<ProductCategories> getproduct_categorylist() {
			
		return admindao.getproduct_categorylist();
	}
	 /**
     * This Method Used to delete the category.
     * @param id 
     */
	public boolean deletecategory(Integer id){
		return admindao.deletecategory(id);
	}
	 /**
     * This Method Used to add the category.
     * @param productCategory 
     */
	public void addCategory(ProductCategories productCategory)
	{
		admindao.addCategory(productCategory);
	}
	 /**
     * This Method Used to update the category.
     * @param productCategory 
     */
	public boolean updateCategory(ProductCategories productCategory){
		return admindao.updateCategory(productCategory);
	}
	 /**
     * This Method Used to add the product.
     * @param product 
     */
	public void addProduct(ProductEntity product)
	{
		admindao.addProduct(product);
	}
	 /**
     * This Method Used to update the product.
     * @param product 
     */
	public boolean updateProduct(ProductEntity product){
		return admindao.updateProduct(product);
	}
	 /**
     * This Method Used to get the productlist.
     * @param ProductEntity 
     */
	public List<ProductEntity> getproduct_list() {
		return admindao.getproduct_list();
	}
	 /**
     * This Method Used to delete the product.
     * @param id 
     */
	public boolean deleteProduct(Integer id){
		return admindao.deleteProduct(id);
	}

}
