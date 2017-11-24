package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	private Long id;

	private String name;
	
	public Status() {
	}
	
	public Status(final String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
