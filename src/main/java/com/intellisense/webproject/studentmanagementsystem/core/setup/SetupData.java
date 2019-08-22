package com.intellisense.webproject.studentmanagementsystem.core.setup;


import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model.Permissions;
import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model.Roles;
import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.repository.PrivilegeRepository;
import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.repository.RoleRepository;
import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.Admin;
import com.intellisense.webproject.studentmanagementsystem.user_mgnt.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class SetupData{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Transactional
    public void init(){

        if(userRepository.count() == 0){
            initPrivileges();
            initRole();
            initUsers();
        }
    }


    private void initUsers(){

        Roles adminRoles = roleRepository.findByName("SADMIN");

        logger.info("Creating a super admin user");
        final Admin adminUser = new Admin();
        adminUser.setFirstname("Test");
        adminUser.setMiddlename("Test");
        adminUser.setLastname("Test");
        adminUser.setUsername("Test");
        adminUser.setPassword(bCryptPasswordEncoder.encode("test"));
        adminUser.setEmail("test@gmail.com");
        if (adminRoles!=null){
            System.out.println("role is not null");
            roleRepository.save(adminRoles);
            adminUser.setRole(adminRoles);
        }
        adminUser.setEnabled(true);

        userRepository.save(adminUser);

    }

    private void initRole() {

        final Permissions permissions1 = privilegeRepository.findByName("CREATE_USER_PRIVILEGE");
        final Permissions permissions2 = privilegeRepository.findByName("CREATE_ROLE_PRIVILEGE");
        final Roles roles1 = new Roles();
        roles1.setName("SADMIN");
        roles1.setPermissions(new HashSet<>(Arrays.asList(permissions1, permissions2)));
        roleRepository.save(roles1);
    }

    private void initPrivileges() {

        final Permissions permissions1 = new Permissions();
        permissions1.setName("CREATE_USER_PRIVILEGE");
        privilegeRepository.save(permissions1);
        //
        final Permissions permissions2 = new Permissions();
        permissions2.setName("CREATE_ROLE_PRIVILEGE");
        privilegeRepository.save(permissions2);
    }


}
