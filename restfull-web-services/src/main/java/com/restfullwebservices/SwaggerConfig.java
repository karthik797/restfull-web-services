package com.restfullwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2


public class SwaggerConfig {

	
	  public static final Contact DEFAULT_CONTACT = new Contact("karthik", "https:www.test.com", "karthiknarayana.akula@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Rest web services Api Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");	
	  public static final Set<String> PRODUCER_CONSUMER= new HashSet<String>(Arrays.asList("application/json"));
	
	@Bean
	public Docket api()
	{
	return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(DEFAULT_API_INFO)
			.produces(PRODUCER_CONSUMER)
			.consumes(PRODUCER_CONSUMER)
			
			;
	
	}
}
