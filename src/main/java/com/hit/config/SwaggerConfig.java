package com.hit.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket custumerApi() {
		return new Docket(DocumentationType.SWAGGER_2).
				select()
				.apis(RequestHandlerSelectors.basePackage("com.hit.controller"))
				.build()
				.apiInfo(apiMetaData());
	}

	private ApiInfo apiMetaData() {
		Contact contact = new Contact("hosam project","www.hosam.com","hosam@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Spring Boot Api", "Spring Rest Api for Online Store", "1.0", "Teame Of Service",
		          contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		
		return apiInfo;
	}
}
