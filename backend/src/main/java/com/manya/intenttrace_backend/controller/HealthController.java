package com.manya.intenttrace_backend.controller;

import com.manya.intenttrace_backend.service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/api/health")
    public String healthCheck() {
        return healthService.getStatus();
    }
}