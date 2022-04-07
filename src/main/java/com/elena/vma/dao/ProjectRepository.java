package com.elena.vma.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elena.vma.entities.Project;


public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
}
