package com.Project.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Project.entities.CarCategory;

public interface CarCategoryService {

	CarCategory findById(int id);
	List<CarCategory> findBycarTypeId(int id);
	List<CarCategory> findAll();
	List<CarCategory> findCarBycategoryId(int id);
	CarCategory saveCarCategory(CarCategory carCategory, MultipartFile cartypeimg);
	void deleteCategory(CarCategory category);


}
