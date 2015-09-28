package com.webshop.login.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.webshop.login.model.Role;
/**
 * Role repository will extends the JpaRepository to get the role for the user.
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
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public List<Role> findRoleByUsername(String authority);
}
