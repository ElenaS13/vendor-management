package com.elena.vma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elena.vma.dao.ProjectRepository;
import com.elena.vma.entities.Project;
import com.elena.vma.entities.Vendor;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		return "/projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//this method saves the project to db
		
		proRepo.save(project);
		return "redirect:/projects/new";		
		
	}

}