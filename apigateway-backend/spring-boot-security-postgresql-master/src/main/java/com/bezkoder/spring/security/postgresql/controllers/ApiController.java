package com.bezkoder.spring.security.postgresql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.dto.ApiRequest;
import com.bezkoder.spring.security.postgresql.models.ApiEntry;
import com.bezkoder.spring.security.postgresql.security.services.ApiService;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/apis")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public ResponseEntity<List<ApiEntry>> getApis(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<ApiEntry> entries = apiService.getApis(userDetails.getUsername());
        return ResponseEntity.ok(entries);
    }

    @PostMapping
    public ResponseEntity<?> saveApi(@RequestBody ApiRequest apiRequest,
                                     @AuthenticationPrincipal UserDetailsImpl userDetails) {
        apiService.saveApi(userDetails.getUsername(), apiRequest.getUrl());
        return ResponseEntity.ok("API Saved Successfully");
    }
}
