package com.common.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
public class CurrentStudentSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private Integer userId;
	private String uuid;
	private LocalDateTime dateTime;
	public CurrentStudentSession(Integer userId, String uuid, LocalDateTime dateTime) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.dateTime = dateTime;
	}
}
