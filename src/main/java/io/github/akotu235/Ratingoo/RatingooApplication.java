package io.github.akotu235.Ratingoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class RatingooApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingooApplication.class, args);
	}

	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
