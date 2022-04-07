package com.elena.vma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elena.vma.entities.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
	@Override
	public List<Vendor> findAll();
}
