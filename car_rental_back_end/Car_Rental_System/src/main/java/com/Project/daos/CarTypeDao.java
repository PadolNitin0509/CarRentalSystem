package com.Project.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.entities.CarType;

public interface CarTypeDao extends JpaRepository<CarType, Integer>{

}
