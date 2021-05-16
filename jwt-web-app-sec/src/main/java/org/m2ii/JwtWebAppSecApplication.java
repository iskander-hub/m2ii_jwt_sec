package org.m2ii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.m2ii.entities.AppRole;
import org.m2ii.entities.AppUser;
import org.m2ii.entities.Task;

import java.util.stream.Stream;

import org.m2ii.dao.TaskRepository;
import org.m2ii.service.AccountService;

@SpringBootApplication
public class JwtWebAppSecApplication implements CommandLineRunner {
	@Autowired
	TaskRepository taskRepository; 
	@Autowired
	private AccountService accountService;
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtWebAppSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.saveUser(new AppUser(null, "admin", "1234",null));
		accountService.saveUser(new AppUser(null, "user", "1234",null));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		
		
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(null,t)); 
		});
		taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
		
	}

}
