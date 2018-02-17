package com.startwithjava.simpleblog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.startwithjava.simpleblog.services.mail.*;
import java.util.Arrays;

@SpringBootApplication
public class Blog {
	private static final long MEGABYTE = 1024L * 1024L;
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(Blog.class, args);
		String[] profiles = context.getEnvironment().getActiveProfiles();
		System.out.println("Active Profiles: "+ Arrays.toString(profiles));

		SMTP smtp = context.getBean(SMTP.class);
		System.out.println(smtp);
		System.out.println(smtp.getSmtpHost());
		System.out.println("SMTP HOST="+smtp.getEnvironment().getProperty("smtp.host"));
	}
	public static long bytesToMegabytes(long bytes) {
		return bytes / MEGABYTE;
	}
}
