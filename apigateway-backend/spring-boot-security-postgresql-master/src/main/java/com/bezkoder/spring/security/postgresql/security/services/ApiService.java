package com.bezkoder.spring.security.postgresql.security.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bezkoder.spring.security.postgresql.models.ApiEntry;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.repository.ApiEntryRepository;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;

@Service
public class ApiService {

	@Autowired
	private ApiEntryRepository apiRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;

	public List<ApiEntry> getApis(String username) {
		User user = userRepo.findByUsername(username).orElseThrow();
		return apiRepo.findByUser(user);
	}

	public void saveApi(String username, String url) {
		String response = restTemplate.getForObject(url, String.class);

		User user = userRepo.findByUsername(username).orElseThrow();

		ApiEntry entry = new ApiEntry();
		entry.setUrl(url);
		entry.setResponseBody(response);
		entry.setFetchedAt(LocalDateTime.now());
		entry.setUser(user);

		apiRepo.save(entry);
	}
}
