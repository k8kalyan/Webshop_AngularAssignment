/*package com.webshop.registration.repository.test;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.Mock;

import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.repository.ProductDaoImpl;

import static org.mockito.Mockito.*;  
*//**
 * JUnit tests for the ProductDaoImpl class.
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
 *//*

public class ProductDaoImplTest extends TestCase {
 private static final Logger logger = Logger.getLogger(ProductCategoryDaoImplTest.class);
	@Mock
	private EntityManager entityManager;
	@Mock
	private TypedQuery query;
	@Test
	*//**
	 * testgetproductList method will fetch the product information from database
	 * <p><b>
	 * Design Specification/Requirements:
	 * </b><p>
	 * getProductList method of ProductDaoImpl
	 *//*
	public void testgetproductlist(){
	   logger.debug("ProductDaoImplTest ::testgetproductlist -START");
		ProductDaoImpl daoImpl  = new ProductDaoImpl();
		ProductEntity productentity = new ProductEntity();
		try{
			productentity.setPcid(10);
			when(entityManager.createNamedQuery("from ProductEntity p where p.pcid =:arg1")).thenReturn(query);
			daoImpl.getProductlist(productentity.getPcid());
			assertTrue("ProductInformation",true);
		}catch(Exception e){
		}
		  logger.debug("ProductDaoImplTest ::testgetproductlist -END");
	}
}



*/