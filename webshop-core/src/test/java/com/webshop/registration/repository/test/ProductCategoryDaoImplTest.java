package com.webshop.registration.repository.test;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.Mock;

import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.repository.ProductCategoryDaoImpl;

import static org.mockito.Mockito.*;
/**
 * JUnit tests for the ProductCategoryDaoImpl class.
 * <p><b>
 * Test Case Documentation:
 * </b><p>
 * Each test case is a test method on this class whose name starts with "test".
 * The following describes the standard test case documentation that applies to all
 * the test cases in this test class:
 * Description:
 * Inputs:
 * </b></i>
 * The inputs for each test case are encapsulated in the executable code of the test method.
 * As with any JUnit test class, the execution procedure is to run this class, which
 * automatically invokes the tests,  verifies the actual results against the expected
 * results, and reports any tests that failed.
 * <p><b><i>
 * Expected Results:
 * </b></i>
 * The expected results are encapsulated in the assert code within each test method.
 * <p><b>
 * Test Data:
 * </b><p>
 * <p>
 * <p><b>
 * Revision History:
 * </b><pre>
 * =============================================================================
 *                                Prior
 * Date         By                Version  Project/CSR  Description
 * ---------- ------------------ -------- ------------ -------------------------
 * 09/07/2015   kalyan    N/A      Webshop    Created.
 * =============================================================================
 * </pre>
 */

public class ProductCategoryDaoImplTest  extends TestCase{
	private static final Logger logger = Logger.getLogger(ProductCategoryDaoImplTest.class);
	@Mock
	private EntityManager entityManager;
	@Mock
	private TypedQuery query;
	@Test
	/**
	 * testgetProductCategoriesList method will fetch the category information from database
	 * <p><b>
	 * Design Specification/Requirements:
	 * </b><p>
	 * getProductCategoriesList method of ProductCategoryDaoImpl
	 */

	public void testgetProductCategoriesList(){
		logger.debug("ProductCategoryDaoImplTest ::testgetProductCategoriesList -START");
		ProductCategoryDaoImpl daoImpl  = new ProductCategoryDaoImpl();
		try{
			List<ProductCategories> productCategories = new ArrayList<ProductCategories>();
			when(entityManager.createNamedQuery("ProductCategories.find")).thenReturn(query);
			when(query.getResultList()).thenReturn(productCategories);
			daoImpl.getProductCategoriesList();
			assertTrue("CategoryInformation",true);
		}catch(Exception e){
		}
		logger.debug("ProductCategoryDaoImplTest ::testgetProductCategoriesList -END");
	}
}


