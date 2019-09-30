package com.myprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SpingCloudTasksinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingCloudTasksinkApplication.class, args);
	}

}

