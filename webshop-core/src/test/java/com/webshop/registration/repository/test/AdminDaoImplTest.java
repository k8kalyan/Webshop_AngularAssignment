package com.webshop.registration.repository.test;
import org.apache.log4j.Logger;
import com.webshop.registration.constants.WebshopConstants;
import com.webshop.registration.model.ProductCategories;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.repository.AdminDaoImpl;
import junit.framework.TestCase;

/**
 * JUnit tests for the AdminDaoImpl class.
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
public class AdminDaoImplTest extends TestCase {
private static final Logger logger = Logger.getLogger(AdminDaoImplTest.class);	
 AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

	 /**
     * testupdateCategory method will update the category information in database
      * <p><b>
     * Design Specification/Requirements:
     * </b><p>
     * updateCategory method of AdminDaoImpl
     */

	public void testupdateCategory() throws Exception{
		logger.debug("AdminDaoImplTest ::testupdateCategory -START");
		adminDaoImpl = new AdminDaoImpl();
		ProductCategories categories = new ProductCategories();
		categories.setId(10);
		categories.setName(WebshopConstants.CATEGORY_NAME);
		adminDaoImpl.updateCategory(categories);
		assertTrue("updated",true);
		logger.debug("AdminDaoImplTest ::testupdateCategory -START");

	}
	 /**
     * testupdateProduct method will update the product information in database
      * <p><b>
     * Design Specification/Requirements:
     * </b><p>
     * updateProduct method of AdminDaoImpl
     */

	public void testupdateProduct() throws Exception{
	    logger.debug("AdminDaoImplTest ::testupdateProduct -START");
		adminDaoImpl = new AdminDaoImpl();
		ProductEntity product = new ProductEntity();
		product.setId(10);
		product.setName(WebshopConstants.CATEGORY_NAME);
		adminDaoImpl.updateProduct(product);
		assertTrue("updated",true);
		logger.debug("AdminDaoImplTest ::testupdateProduct -END");

	}
	 /**
     * testdeleteCategory method will delete the Category information in database
      * <p><b>
     * Design Specification/Requirements:
     * </b><p>
     * deleteCategory method of AdminDaoImpl
     */
	public void testdeleteCategory() throws Exception{
	   logger.debug("AdminDaoImplTest ::testdeleteCategory -START");
		adminDaoImpl = new AdminDaoImpl();
		ProductCategories productCategories = new ProductCategories();
		productCategories.setId(10);
		productCategories.setName(WebshopConstants.CATEGORY_NAME);
		adminDaoImpl.deletecategory(productCategories.getId());
		assertTrue("deleted", true);
	   logger.debug("AdminDaoImplTest ::testdeleteCategory -START");

	}
	 /**
     * testdeleteProduct method will delete the Product information in database
      * <p><b>
     * Design Specification/Requirements:
     * </b><p>
     * deleteProduct method of AdminDaoImpl
     */
	public void testdeleteProduct() throws Exception{
	   logger.debug("AdminDaoImplTest ::testdeleteProduct -START");
		adminDaoImpl = new AdminDaoImpl();
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(10);
		productEntity.setName(WebshopConstants.PRODUCTS_NAME);
		adminDaoImpl.deleteProduct(productEntity.getId());
		assertTrue("deleted", true);
	   logger.debug("AdminDaoImplTest ::testdeleteProduct -START");

	}
}
