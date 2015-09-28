package com.webshop.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.service.ProductManager;
/**
 * ProductController prepares the order entity object with price, product and quantity information. 
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
public class ProductController {
	@Autowired
	ProductManager productmanager;
	
	@RequestMapping(value="/getProduct" )
	public @ResponseBody
	List<ProductEntity> getproductList() {
		List<ProductEntity> prList=productmanager.getProductlist();
		return prList;
	}

}
