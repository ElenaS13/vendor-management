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
import com.elena.vma.services.ProjectService;
import com.elena.vma.services.VendorService;

@Controller
@RequestMapping("projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	VendorService vendorService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		Iterable<Vendor> vendors = vendorService.getAll();
		model.addAttribute("allVendors", vendors);
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//this method saves the project to db
		
		proService.save(project);
		
		return "redirect:/projects/new";		
		
	}
	
	 @GetMapping("/update")
	    public String displayProjectUpdateForm(@RequestParam("id") long theId, Model model) {
	    	Project theProject = proService.findByProjectId(theId);
	    	model.addAttribute("project", theProject);
	    	return "project/new-project";
	    
	    }
	    
	    @GetMapping("delete")
	    	public String deleteProject(@RequestParam("id") long theId, Model model) {
	    		Project theProject = proService.findByProjectId(theId);
	    		proService.delete(theProject);
	    		return "redirect:/projects";
	    	}
	    

}
