package com.webshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.webshop.registration.service.AdminManager;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;

/**
 * Admin controller class provides implementations for login user.
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

@RestController
public class AdminController {
	@Autowired
	AdminManager adminmanager;


	@RequestMapping("/getCategory")
	public @ResponseBody
	List<ProductCategories> getproductCategoryList() {
		List<ProductCategories> list = adminmanager.getproduct_categorylist();
		return list;
	}


	@RequestMapping(value = "/addCategory/{name}", method = RequestMethod.GET)
	public void addCategory(@PathVariable("name") String name) {
		try {

			ProductCategories category = new ProductCategories();
			category.setName(name);
			adminmanager.addCategory(category);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public void deleteCategory(@PathVariable("id") int id) {

		ProductCategories category = new ProductCategories();
		category.setId(id);

		adminmanager.deletecategory(id);

	}


	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public void deleteProduct(@PathVariable("id") int id) {

		adminmanager.deleteProduct(id);
	}


	@RequestMapping(value = "/addProducts/{name}/{pcid}/{price}", method = RequestMethod.GET)
	public void addProduct(@PathVariable("name") String name,
			@PathVariable("pcid") int pcid, @PathVariable("price") String price) {


		ProductEntity product = new ProductEntity();
		ProductCategories categories = new ProductCategories();
		categories.setId(pcid);
		product.setPcid(categories);
		product.setName(name);	
		product.setPrice(price);
		adminmanager.addProduct(product);

	}

}
