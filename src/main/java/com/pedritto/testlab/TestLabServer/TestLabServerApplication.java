package com.pedritto.testlab.TestLabServer;

import com.pedritto.testlab.TestLabServer.repository.CategoryRepository;
import com.pedritto.testlab.TestLabServer.repository.TestCaseRepository;
import com.pedritto.testlab.TestLabServer.resolver.Mutation;
import com.pedritto.testlab.TestLabServer.resolver.Query;
import com.pedritto.testlab.TestLabServer.resolver.TestCaseResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestLabServerApplication {

	@Bean
	public TestCaseResolver testCaseResolver(TestCaseRepository testCaseRepository) {
		return new TestCaseResolver(testCaseRepository);
	}

	@Bean
	public Query query(CategoryRepository categoryRepository, TestCaseRepository testCaseRepository) {
		return new Query(categoryRepository, testCaseRepository);
	}

	@Bean
	public Mutation mutation(CategoryRepository categoryRepository, TestCaseRepository testCaseRepository) {
		return new Mutation(categoryRepository, testCaseRepository);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestLabServerApplication.class, args);
	}
}
