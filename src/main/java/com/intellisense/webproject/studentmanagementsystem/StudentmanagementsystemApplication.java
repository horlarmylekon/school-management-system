package com.intellisense.webproject.studentmanagementsystem;

import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.repository.RoleRepository;
import com.intellisense.webproject.studentmanagementsystem.core.setup.SetupData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
public class StudentmanagementsystemApplication implements CommandLineRunner {

    private SetupData data;

    @Autowired
    public void setData(SetupData data){
        this.data = data;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentmanagementsystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        data.init();
    }
}
