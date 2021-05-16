package org.m2ii.dao;

import org.m2ii.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<AppUser, Long> {
	
	public AppUser findByUsername(String username);

}
