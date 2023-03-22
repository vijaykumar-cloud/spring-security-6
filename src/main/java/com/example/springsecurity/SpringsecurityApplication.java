package com.example.springsecurity;

import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.RoleName;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadRoleData(final RoleRepository roleRepository) {
		return args -> {
			roleRepository.deleteAll();
			roleRepository.save(new Role(RoleName.USER));
			roleRepository.save(new Role(RoleName.ADMIN));
			roleRepository.save(new Role(RoleName.SUPERADMIN));

		};
	}

	@Bean
	public CommandLineRunner createSuperAdmin(UserRepository userRepository, final RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			User user = new User();
			user.setFirstName("Super");
			user.setLastName("Admin");
			user.setEmail("super");
			user.setPassword(passwordEncoder.encode("super"));
			Role role = roleRepository.findByRoleName(RoleName.SUPERADMIN);
			user.setRoles(Collections.singletonList(role));
			userRepository.save(user);
		};
	}
}
