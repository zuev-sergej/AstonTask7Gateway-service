package ru.aston.gatewayservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/user-service")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public Mono<String> userServiceFallback() {
        return Mono.just("User service временно недоступен");
    }

    @GetMapping("/notification-service")
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public Mono<String> notificationServiceFallback() {
        return Mono.just("Notification Service временно недоступен");
    }
}
