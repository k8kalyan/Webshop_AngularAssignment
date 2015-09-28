package com.webshop.controller;



import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.webshop.registration.model.OrderShipment;
import com.webshop.registration.model.ProductEntity;
import com.webshop.registration.service.OrderManager;
import com.webshop.registration.model.OrderEntity;

/**
 * OrderController prepares the order entity object with price, product and
 * quantity information.
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
public class OrderController {
	@Autowired
	OrderManager manager;
	ProductEntity product = new ProductEntity();
	OrderEntity orderEntity = new OrderEntity();
	double totalPO = 0;

	@RequestMapping(value = "/addOrder/{shippingAddress}/{shippingCity}/{pin}/{status}/{itemList}", method = RequestMethod.GET)
	public void addOrder(
			@PathVariable("shippingAddress") String shippingAddress,
			@PathVariable("shippingCity") String shippingCity,
			@PathVariable("pin") String pin,
			@PathVariable("status") String status,
			@PathVariable("itemList") JSONArray itemList) {

		OrderShipment orderShipment = new OrderShipment();
		orderShipment.setShippingAddress(shippingAddress);
		orderShipment.setShippingCity(shippingCity);
		orderShipment.setPin(pin);
		orderShipment.setStatus(status);
		manager.addOrder(orderShipment);

		try {
			for (int i = 0; i < itemList.length(); ++i) {
				JSONObject jsonObject = itemList.getJSONObject(i);
				orderEntity.setPrice((double) (jsonObject.getInt("price") * jsonObject
						.getInt("quantity")));
				orderEntity.setQuantity(jsonObject.getInt("quantity"));
				orderEntity.setProductid(jsonObject.getInt("sku"));
				orderEntity.setOrderid(orderShipment.getId());
				manager.addOrderLines(orderEntity);

			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

}
