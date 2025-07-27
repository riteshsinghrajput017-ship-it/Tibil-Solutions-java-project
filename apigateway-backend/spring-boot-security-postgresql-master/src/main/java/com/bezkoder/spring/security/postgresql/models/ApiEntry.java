package com.bezkoder.spring.security.postgresql.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class ApiEntry {
	@Id
	@GeneratedValue
	private Long id;
	private String url;
	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String responseBody;
	private LocalDateTime fetchedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private User user;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public LocalDateTime getFetchedAt() {
		return fetchedAt;
	}

	public void setFetchedAt(LocalDateTime fetchedAt) {
		this.fetchedAt = fetchedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}