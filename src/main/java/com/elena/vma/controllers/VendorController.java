package com.elena.vma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

import com.elena.vma.entities.Vendor;
import com.elena.vma.services.VendorService;

@Controller
@RequestMapping("vendors")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@GetMapping
	public String displayVendors(Model model) {
		Iterable<Vendor> vendors = vendorService.getAll();
		model.addAttribute("vendors", vendors);
		return "vendors/list-vendors";
	}

    @GetMapping("/new")	
	public String displayVendorForm(Model model) {
		Vendor aVendor = new Vendor();
		model.addAttribute("vendor", aVendor);
		return "vendors/new-vendor";
	}
    
    @PostMapping("/save")
    public String createVendor(Model model, @Valid Vendor vendor, Errors errors) {
    	if(errors.hasErrors())
    		return "vendors/new-vendor";
    	
    	vendorService.save(vendor);
    	
    	return "redirect:/vendors/new";
    }
    
    @GetMapping("/update")
    public String displayVendorUpdateForm(@RequestParam("id") long theId, Model model) {
    	Vendor theVendor = vendorService.findByVendorId(theId);
    	model.addAttribute("vendor", theVendor);
    	return "vendors/new-vendor";
    
    }
    
    @GetMapping("delete")
    	public String deleteVendor(@RequestParam("id") long theId, Model model) {
    		Vendor theVendor = vendorService.findByVendorId(theId);
    		vendorService.delete(theVendor);
    		return "redirect:/vendors";
    	}
    
	

}
