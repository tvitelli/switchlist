package org.timvitelli.switchlist.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.timvitelli.switchlist.models.User;
import org.timvitelli.switchlist.security.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}