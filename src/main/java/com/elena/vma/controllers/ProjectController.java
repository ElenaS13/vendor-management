package com.elena.vma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elena.vma.dao.ProjectRepository;
import com.elena.vma.dao.VendorRepository;
import com.elena.vma.entities.Project;
import com.elena.vma.entities.Vendor;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	VendorRepository vendorRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Vendor> vendors = vendorRepo.findAll();
		model.addAttribute("allVendors", vendors);
		model.addAttribute("project", aProject);
		return "/projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> vendors, Model model) {
		//this method saves the project to db
		
		proRepo.save(project);
		Iterable<Vendor> chosenVendors = vendorRepo.findAllById(vendors);
		for(Vendor ven : chosenVendors) {
			ven.setTheProject(project);
			vendorRepo.save(ven);
		}
		return "redirect:/projects/new";		
		
	}

}
