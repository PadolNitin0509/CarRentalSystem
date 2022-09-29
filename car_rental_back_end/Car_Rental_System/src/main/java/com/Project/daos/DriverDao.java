package com.Project.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.entities.Driver;

public interface DriverDao extends JpaRepository<Driver, Integer> {
	
}
