package com.example;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.Status;
import com.example.model.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public CommandLineRunner commandLineRunner(final JdbcTemplate jdbcTemplate, final UserRepository userRepository) {
		return (args) -> {

			log.info("entering the command line runner callback");

//			final String sql = "INSERT INTO `status` (`id`, `name`) VALUES (1, 'enabled'), (2, 'disabled')";
//			jdbcTemplate.execute(sql);
			
			final Status statusEnabled = new Status("enabled");
			final Status statusDisabled = new Status("disabled");
			
			final User rick = new User("rick");
			final User morty = new User("morty");
			
			rick.setStatus(statusEnabled);
			morty.setStatus(statusDisabled);
			
			userRepository.save(rick);
			userRepository.save(morty);
		};
	}

}