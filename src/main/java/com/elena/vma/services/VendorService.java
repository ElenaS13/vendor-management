package com.elena.vma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elena.vma.dao.VendorRepository;
import com.elena.vma.dto.VendorProject;
import com.elena.vma.entities.Vendor;

@Service
public class VendorService {
	
	@Autowired
	VendorRepository vendorRepo;
	
	
	public Vendor save(Vendor vendor) {
		return vendorRepo.save(vendor);
	}


	public Iterable<Vendor> getAll() {
		return vendorRepo.findAll();
	}


	public List<VendorProject> vendorProjects() {
		return vendorRepo.vendorProjects();
	}



	public void delete(Vendor theVendor) {
		vendorRepo.delete(theVendor);
		
	}
	


	public Vendor findByVendorId(long theId) {
		return vendorRepo.findByVendorId(theId);
	}


	

	
}