package com.elena.vma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elena.vma.dao.ProjectRepository;
import com.elena.vma.dao.VendorRepository;
import com.elena.vma.entities.Project;
import com.elena.vma.entities.Vendor;


@Controller 
public class HomeController {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	VendorRepository vendorRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		
		List<Vendor> vendors = vendorRepo.findAll();
		model.addAttribute("vendorList", vendors);
		return "main/home";
	}
	
	
	
}
