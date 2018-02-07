package com.startwithjava.simpleblog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Blog {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(Blog.class, args);
		String[] profiles = context.getEnvironment().getActiveProfiles();
		System.out.println("Active Profiles: "+ Arrays.toString(profiles));
	}
	private static class MyBean {
		@Value("${refresh.rate}")
		private int refreshRate;

		public void doSomething() {
			System.out.printf("Refresh Rate : %s%n", refreshRate);
		}
	}
} 