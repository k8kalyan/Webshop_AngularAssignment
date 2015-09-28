package com.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.webshop.login.service.LoginManager;
import com.webshop.registration.service.UserManager;
import com.webshop.registration.model.UserEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login controller class  provides implementations for login user. 
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

public class LoginController {

	@Autowired
	UserManager userManager;
	@Autowired
	LoginManager loginManager;

	@RequestMapping(value = "/addUser/{fname}/{lname}/{email}/{username}/{password}/{address}/{city}/{pincode}", method = RequestMethod.GET)
	public void addUser(@PathVariable("fname") String fname,
			@PathVariable("lname") String lname,
			@PathVariable("email") String email,
			@PathVariable("username") String username,
			@PathVariable("password") String password,
			@PathVariable("address") String address,
			@PathVariable("city") String city,
			@PathVariable("pincode") String pincode) {

		UserEntity user = new UserEntity();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(lname);
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setCity(city);
		user.setPincode(pincode);

		userManager.addUser(user);
	}

	@RequestMapping(value = "/getAuthenticted/{username}/{password}", method = RequestMethod.GET)
	public UserEntity getAuthenticted(@PathVariable("username") String username,
			@PathVariable("password") String password) {

		UserEntity userLogin = new UserEntity();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
		userLogin = loginManager.getAuthenticted(username, password);
		String authority=loginManager.getRole(username);

		return userLogin;
	}

}