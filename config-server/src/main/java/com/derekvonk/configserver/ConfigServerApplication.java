package com.derekvonk.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	@Value("${spring.application.name}")
	private static String name;

	public static void main(String[] args) {
		System.out.println("Application name = " + name);
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
