package com.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.common.enums.AddressType;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NotNull(message = "Area is Required")
	private String area;
	
	@NotNull(message = "State is Required")
	private String state;
	
	@NotNull(message = "District is Required")
	private String district;
	
	@NotNull(message = "Pincode is Required")
	private String pincode;
	
	@NotNull(message = "Address type is Required")
	private AddressType addresType;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Student student;
}
