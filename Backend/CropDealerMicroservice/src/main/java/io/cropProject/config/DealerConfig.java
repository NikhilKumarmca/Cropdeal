package io.cropProject.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DealerConfig {

	
	@Bean
	@LoadBalanced
	public RestTemplate resttemplate()
	{
		return new RestTemplate();
	}
}
