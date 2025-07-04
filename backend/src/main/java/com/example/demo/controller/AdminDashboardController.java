package com.example.demo.controller;

import com.example.demo.model.io.dto.dashboard.*;
import com.example.demo.service.intface.IDashboardService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/stats")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class AdminDashboardController {

    private final IDashboardService dashboardService;

    @GetMapping("/overview")
    public ResponseEntity<OverviewStats> getOverviewStats() {
        OverviewStats stats = dashboardService.getOverviewStats();
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/users")
    public ResponseEntity<UserStats> getUserStats() {
        UserStats stats = dashboardService.getUserStats();
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/content")
    public ResponseEntity<ContentStats> getContentStats() {
        ContentStats stats = dashboardService.getContentStats();
        return ResponseEntity.ok(stats);
    }
}
