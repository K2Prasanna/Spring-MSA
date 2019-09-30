package com.myprojects;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpingCloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingCloudTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessor getTollProcessor()
	{
		return new TollProcessor();
	}
	
	
	protected class TollProcessor implements CommandLineRunner
	{

		@Override
		public void run(String... args) throws Exception {
			System.out.println("No of arguments: " + args.length);
			System.out.println(Arrays.toString(args));
			
		}
		
	}
}
