package org.m2ii.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.m2ii.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole,Long>{
	
	public AppRole findByRoleName(String roleName);

}
