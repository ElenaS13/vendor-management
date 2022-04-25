package com.elena.vma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elena.vma.dao.ProjectRepository;

import com.elena.vma.entities.Project;
import com.elena.vma.entities.Vendor;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository proRepo;
	
	
	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> getAll() {
		return proRepo.findAll();
	}


	public Project findByProjectId(long theId) {
		
		return proRepo.findByProjectId(theId);
	}


	public void delete(Project theProject) {
		proRepo.delete(theProject);
		
	}


	



}