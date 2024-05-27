package com.ts.ts_sso_service_1727.controller;

import com.ts.ts_sso_service_1727.config.RSAKeyRecord;
import com.ts.ts_sso_service_1727.config.jwtAuth.JwtTokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanmay
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DashboardController {
    private final RSAKeyRecord rsaKeyRecord;
    private final JwtTokenUtils jwtTokenUtils;


    //@PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_USER')")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/welcome-message")
    public ResponseEntity<String> getFirstWelcomeMessage(Authentication authentication){
        return ResponseEntity.ok("Welcome to the JWT Tutorial:"+authentication.getName()+"with scope:"+authentication.getAuthorities());
    }

   //@PreAuthorize("hasRole('ROLE_MANAGER')")
    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/manager-message")
    public ResponseEntity<String> getManagerData(Principal principal){
        return ResponseEntity.ok("Manager::"+principal.getName());

    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping("/admin-message")
    public ResponseEntity<String> getAdminData(@RequestParam("message") String message, Principal principal){
        return ResponseEntity.ok("Admin::"+principal.getName()+" has this message:"+message);

    }

    @GetMapping("/get-user-data")
    public ResponseEntity<?> getNew(HttpServletRequest request, Principal principal, Authentication authentication) {
        // Check if authentication and principal are not null
        if (principal == null || authentication == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        // Collect user details
        String username = principal.getName();
        boolean isAuthenticated = authentication.isAuthenticated();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object details = authentication.getDetails();

        // Create a response map
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("isAuthenticated", isAuthenticated);
        response.put("authorities", authorities);
        response.put("details", details);
        // Note: Do not include credentials in the response

        return ResponseEntity.ok(response);
    }
}