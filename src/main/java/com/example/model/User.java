package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, updatable = false)
	private String guid;
	
	@ManyToOne
	@JoinColumn(name = "status", nullable = false, updatable = false)
	private Status status;
	
	private String description;

	public User() {
	}

	public User(final String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return String.format("User[id='%d', guid='%s', description='%s']", id, guid, description);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null || !(obj instanceof User)) { return false; }
		final User rhs = (User) obj;
		return new EqualsBuilder().append(guid, rhs.getGuid()).build();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(guid).build();
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(final String guid) {
		this.guid = guid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(final Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}