package com.key_stones.Security;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.key_stones.ENUM.Permissions;
import com.key_stones.Entity.UserAuth;
import com.key_stones.Repository.UserAuthRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserAuthRepository userRepo;

    public CustomerUserDetailsService(UserAuthRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAuth user = userRepo.findByUserEmail(username)
                .orElseThrow(() ->
                    new UsernameNotFoundException(
                        "User not found: " + username));

        Set<Permissions> permissions =
                RoleBasedPermission.getRoleBasedPermissions()
                    .getOrDefault(user.getRole(), Collections.emptySet());

        var authorities = permissions.stream()
                .map(permission ->
                    new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getUserEmail(),
                user.getPassword(),
                authorities
        );
    }
}