package org.m2ii.service;

import org.m2ii.entities.AppRole;
import org.m2ii.entities.AppUser;

public interface AccountService {
   
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);
}
