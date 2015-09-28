package com.webshop.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webshop.login.repository.LoginDao;
import com.webshop.registration.model.UserEntity;
/**
 * LoginManagerImpl will invoke the LoginManager interface and will get username and password from database . 
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
public class LoginManagerImpl implements LoginManager {

	@Autowired
	LoginDao logindao;

	public UserEntity getAuthenticted(String username, String password) {
		return logindao.getAuthenticated(username, password);
	}
	public String getRole(String username){
		return logindao.getRole(username);
	}

}
