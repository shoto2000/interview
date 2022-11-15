package com.prospecta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Prospecta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	private String category;
	
	
	public Prospecta(String title, String description, String category) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
	}
	
	
}
