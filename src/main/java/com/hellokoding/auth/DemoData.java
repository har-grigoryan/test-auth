package com.hellokoding.auth;

import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.RoleRepository;
import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DemoData {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleRepository roleRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);


        User adminUser = new User();
        adminUser.setUsername("admin-user");
        adminUser.setPassword("12345678");
        adminUser.addRole(adminRole);

        User customerUser = new User();
        customerUser.setUsername("customer-user");
        customerUser.setPassword("12345678");
        customerUser.addRole(userRole);

        userService.save(adminUser);
        userService.save(customerUser);
    }
}
