package com.example.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${foo}")
	String foo;

	@Autowired
	Bar bar;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Foo: " + foo);
		System.out.println("Bar: " + bar.getValue());
	}

	@Configuration
	static class BarConfig {
		@Bean
		@ConditionalOnProperty(name="foo")
		Bar bar() {
			return new Bar();
		}
	}

	static class Bar {
		public String getValue() {
			return "a-value";
		}
	}
}
