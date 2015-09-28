package com.webshop.registration.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.webshop.login.model.Role;
import com.webshop.login.repository.UsersRepository;
import com.webshop.registration.constants.WebshopConstants;
import com.webshop.registration.model.UserEntity;
/**
 * UserDAOImpl class invoke UserDAO and persist the data into database. 
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
public class UserDaoImpl  implements UserDao{
	@Autowired
	UsersRepository usersrepository;
	@PersistenceContext
	private EntityManager manager;

	/**
	 * This method will persist user details into the database.
	 * @param userEntity 
	 */
	public void addUser(UserEntity user){

		Role roles=new Role();
		String username=user.getUsername();
		String role=WebshopConstants.ROLE_ADMIN;
		manager.persist(user);
		roles.setAuthority(role);
		roles.setUsername(username);
		manager.persist(roles);
		
	}
	public String checkUser(UserEntity user){
	
		String Isthere="Isthere";
		String username=user.getUsername();
		List<UserEntity> users=usersrepository.findByUsername(username);
		if (users.size()==1){
			return Isthere;
		}
	
		return null;
	}
}
