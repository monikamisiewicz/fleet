package com.monikamisiewicz.fleet;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

//this class helps to return current user
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return Optional.ofNullable(username).filter(s -> !s.isEmpty());
    }
}
