package com.bezkoder.spring.security.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.security.postgresql.models.ApiEntry;
import com.bezkoder.spring.security.postgresql.models.User;


@Repository
public interface ApiEntryRepository extends JpaRepository<ApiEntry, Long> {
	List<ApiEntry> findByUser(User user);
}