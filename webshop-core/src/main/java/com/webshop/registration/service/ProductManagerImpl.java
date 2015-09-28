
package com.webshop.registration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.repository.ProductDao;

/**
 * ProductManagerImpl invoke ProductManager class and calls the method getProductList. 
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
public class ProductManagerImpl implements ProductManager{
	@Autowired 
	ProductDao productdao;
	public List<ProductEntity> getProductlist(){
		return productdao.getProductlist();
	}

}
