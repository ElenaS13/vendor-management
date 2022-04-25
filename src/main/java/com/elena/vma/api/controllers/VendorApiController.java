package com.elena.vma.api.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elena.vma.dao.VendorRepository;
import com.elena.vma.entities.Vendor;

@RestController
@RequestMapping("/app-api/vendors")
public class VendorApiController {
	
	@Autowired
	VendorRepository vendorRepo;
	
	@GetMapping
	public Iterable<Vendor> getVendors(){
		return vendorRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Vendor getVendorById(@PathVariable("id") Long id) {
		return vendorRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendor create(@RequestBody Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Vendor update(@RequestBody @Validated Vendor vendor) {
		return vendorRepo.save(vendor);
	}
	
	@PatchMapping(path="/{id}", consumes= "application/json")
	public Vendor partialUpdate(@PathVariable("id") long id, @RequestBody @Validated Vendor patchEmployee) {
		Vendor emp = vendorRepo.findById(id).get();
		
		if(patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		if(patchEmployee.getFirstName() != null) {
			emp.setFirstName(patchEmployee.getFirstName());
		}
		if(patchEmployee.getLastName() != null) {
			emp.setLastName(patchEmployee.getLastName());
		}
		
		return vendorRepo.save(emp);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			vendorRepo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
//	@GetMapping(params= {"page", "size"})
//	@ResponseStatus(HttpStatus.OK)
//	public Iterable<Vendor> findPaginatedEmployees(@RequestParam("page") int page, 
//											@RequestParam("size") int size){
//		Pageable pageAndSize = PageRequest.of(page, size);
//		
//		return vendorRepo.getAll(pageAndSize);
//	}
	
}