package com.kyukeoton_b.kyukeotonB_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
//@SpringBootApplication
@SpringBootApplication( exclude = {
		org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
		org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
		org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class }
)
public class KyukeotonBBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyukeotonBBeApplication.class, args);
	}

}
