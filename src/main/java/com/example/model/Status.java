package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	private String name;

	public Status() {
	}

	public Status(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Status[id='%d', name='%s', description='%s']", id, name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null || !(obj instanceof Status)) { return false; }
		final Status rhs = (Status) obj;
		return new EqualsBuilder().append(name, rhs.getName()).build();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).build();
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
