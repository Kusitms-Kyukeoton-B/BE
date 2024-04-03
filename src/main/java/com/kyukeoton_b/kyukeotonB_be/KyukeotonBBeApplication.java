package com.kyukeoton_b.kyukeotonB_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KyukeotonBBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyukeotonBBeApplication.class, args);
	}

}
