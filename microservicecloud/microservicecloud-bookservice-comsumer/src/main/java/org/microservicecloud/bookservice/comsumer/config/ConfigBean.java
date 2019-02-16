package org.microservicecloud.bookservice.comsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean 
{
	@Bean
    public RestTemplate initRestTemplate() {
    	return new RestTemplate();
    }
}
