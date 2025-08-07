package com.mortgage.portal_api.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserIdGenerator {

    private final AtomicInteger userCounter = new AtomicInteger(1);
    private final AtomicInteger adminCounter = new AtomicInteger(1);

    public String generateUserId(String role) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if ("Admin".equalsIgnoreCase(role)) {
            return String.format("A%03d%s", adminCounter.getAndIncrement(), date);
        } else {
            return String.format("U%03d%s", userCounter.getAndIncrement(), date);
        }
    }

    public String resolveRoleId(String role) {
        return "Admin".equalsIgnoreCase(role) ? "01" : "02";
    }
}
