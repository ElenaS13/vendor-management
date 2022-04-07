package com.elena.vma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elena.vma.dao.VendorRepository;
import com.elena.vma.entities.Vendor;

@Controller
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	VendorRepository vendorRepo;
	
	@GetMapping
	public String displayVendors(Model model) {
		List<Vendor> vendors = vendorRepo.findAll();
		model.addAttribute("vendors", vendors);
		return "vendors/list-vendors";
	}

    @GetMapping("/new")	
	public String displayVendorForm(Model model) {
		Vendor aVendor = new Vendor();
		model.addAttribute("vendor", aVendor);
		return "/vendors/new-vendor";
	}
    
    @PostMapping("/save")
    public String createVendor(Model model, Vendor vendor) {
    	vendorRepo.save(vendor);
    	
    	return "redirect:/vendors/new";
    }
    
	

}
