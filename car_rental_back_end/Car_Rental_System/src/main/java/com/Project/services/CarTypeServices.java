package com.Project.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Project.entities.CarType;

public interface CarTypeServices {
	List<CarType> findCarTypeAll();

	CarType findById(int id);

	CarType saveCarType(CarType cartype, MultipartFile carimage);

	void deleteCategory(CarType carType);

}
