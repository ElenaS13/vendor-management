package com.elena.vma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.elena.vma.dto.VendorProject;
import com.elena.vma.entities.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
	@Override
	public List<Vendor> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.vendor_id) as projectCount "
			+ "FROM vendor e left join project_vendor pe ON pe.vendor_id=e.vendor_id "
			+ "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<VendorProject> vendorProjects();
}
