package com.webshop.login.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.webshop.login.model.Role;
import com.webshop.registration.model.UserEntity;
/**
 * LoginDAOImpl will invoke the LoginDAO interface and will get username and password from database . 
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


@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
	@Autowired
	UsersRepository usersrepository;
	@Autowired
	RoleRepository rolerepository;
	@PersistenceContext
	private EntityManager manager;

	public UserEntity getAuthenticated(String username ,String password){
		List<UserEntity> users=usersrepository.findByUsername(username);
		if (users !=null){
			String dbpassword=users.get(0).getPassword();
			if(password.equals(dbpassword)){
				return users.get(0);
			}
		}
		return null;
	}

	public String getRole(String username){
		List<Role> userroles=rolerepository.findRoleByUsername(username);
		String role=userroles.get(0).getAuthority();
		return role;

	}

}
