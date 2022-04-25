package com.elena.vma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(generator = "vendor_seq")
	private long vendorId;
	
	@NotBlank(message="*Must give a first name")
	@Size(min=2, max=50)
	private String firstName;
	
	
	@NotBlank(message="*Must give a last name")
	@Size(min=1, max=50)
	private String lastName;
	
	@NotBlank
	@Email(message="*Must be a valid email address")
	private String email;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name="project_vendor", joinColumns=@JoinColumn(name="vendor_id"),
    inverseJoinColumns=@JoinColumn(name="project_id"))
	
	@JsonIgnore
	private List<Project> theProject;
	
	public Vendor() {
		
	}
	
	

	public Vendor(String firstName, String lastName, String companyName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		//this.companyName = companyName;
		this.email = email;
	}


    
	
	
	



	public List<Project> getTheProject() {
		return theProject;
	}



	public void setTheProject(List<Project> theProject) {
		this.theProject = theProject;
	}



	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getCompanyName() {
//		return companyName;
//	}
//
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	

}
