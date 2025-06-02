package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.entity.Role;
import com.matheuslustosa.user_registration.exceptions.RoleNotFoundException;
import com.matheuslustosa.user_registration.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getOrThrow(String roleName){
        return roleRepository.findByName(roleName).orElseThrow(
                () -> new RoleNotFoundException("Role '%s' not found".formatted(roleName)));



    }

}
